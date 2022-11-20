package de.marshal.booking.service;

import de.marshal.booking.api.BookingDAO;
import de.marshal.booking.api.BookingService;
import de.marshal.booking.api.RoomDAO;
import de.marshal.booking.api.RoomType;
import de.marshal.booking.dto.Booking;
import de.marshal.booking.dto.Room;
import de.marshal.booking.util.CustomDateInterval;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    private RoomDAO roomDAO;
    private BookingDAO bookingDAO;

    public BookingServiceImpl(RoomDAO roomDAO, BookingDAO bookingDAO) {
        this.roomDAO = roomDAO;
        this.bookingDAO = bookingDAO;
    }

    @Override
    public Booking getBooking(long bookingId) {
        return bookingDAO.getById(bookingId);
    }

    @Override
    public List<Booking> listAllBookings(SortType sortType) {
        List<Booking> bookings = bookingDAO.findAll();

        Map<Long, Room> rooms = new HashMap<>();
        for (Room room : roomDAO.findAll()) {
            rooms.put(room.getId(), room);
        }

        switch (sortType) {
            case ID:
                bookings.sort(Comparator.comparingLong(Booking::getId));
                break;
            case ROOM_TYPE:
                bookings.sort((b1, b2) -> {
                    Room firstBookingRoom = rooms.get(b1.getRoomId());
                    Room secondBookingRoom = rooms.get(b2.getRoomId());

                    return firstBookingRoom.getRoomType().compareTo(secondBookingRoom.getRoomType());
                });
                break;
            case START_DATE:
                bookings.sort((b1, b2) -> b1.getInterval().getStart().compareTo(b2.getInterval().getStart()));
                break;
            case END_DATE:
                bookings.sort((b1, b2) -> b1.getInterval().getEnd().compareTo(b2.getInterval().getEnd()));
                break;
            case PRICE:
                bookings.sort(Comparator.comparingLong(Booking::getPrice));
                break;
        }

        return bookings;
    }

    @Override
    public Booking addBooking(long roomId, boolean fc, CustomDateInterval interval) {
        Objects.requireNonNull(interval);

        Room room = roomDAO.getById(roomId);
        if (room == null) {
            throw new IllegalArgumentException("Room with id " + roomId + " does not exist");
        }

        List<Booking> roomBookings = bookingDAO.findByRoomId(roomId);
        for (Booking roomBooking : roomBookings) {
            if (CustomDateInterval.isIntersected(interval, roomBooking.getInterval())) {
                throw new IllegalArgumentException("This interval is intersected with already existing booking");
            }
        }

        Booking booking = new Booking(
                roomId,
                fc,
                interval,
                calculateBookingPrice(room.getRoomType(), interval.toDays(), fc)
        );

        bookingDAO.add(booking);

        return booking;
    }

    @Override
    public Booking updateBooking(long bookingId, long nextRoomId, boolean nextFc, CustomDateInterval nextInterval) {
        Objects.requireNonNull(nextInterval);

        Booking existingBooking = bookingDAO.getById(bookingId);
        if (existingBooking == null) {
            throw new IllegalArgumentException("Booking with id " + bookingId + " does not exist");
        }

        Room room = roomDAO.getById(nextRoomId);
        if (room == null) {
            throw new IllegalArgumentException("Room with id " + nextRoomId + " does not exist");
        }

        List<Booking> nextRoomBookings = bookingDAO.findByRoomId(nextRoomId);
        for (Booking nextRoomBooking : nextRoomBookings) {
            if (nextRoomBooking.getId() == bookingId) {
                continue;
            }

            if (CustomDateInterval.isIntersected(nextInterval, nextRoomBooking.getInterval())) {
                throw new IllegalArgumentException("This interval is intersected with already existing booking");
            }
        }

        long nextPrice = calculateBookingPrice(room.getRoomType(), nextInterval.toDays(), nextFc);

        existingBooking.setRoomId(nextRoomId);
        existingBooking.setFc(nextFc);
        existingBooking.setInterval(nextInterval);
        existingBooking.setPrice(nextPrice);

        bookingDAO.update(existingBooking);

        return existingBooking;
    }

    @Override
    public Booking removeBooking(long bookingId) {
        Booking existingBooking = bookingDAO.getById(bookingId);
        if (existingBooking == null) {
            throw new IllegalArgumentException("Booking with id " + bookingId + " does not exist");
        }

        bookingDAO.remove(existingBooking);

        return existingBooking;
    }

    private long calculateBookingPrice(RoomType roomType, int days, boolean fc) {
        return roomType.getRoomPrice() * days + (fc ? roomType.getFcPrice() : 0L);
    }
}
