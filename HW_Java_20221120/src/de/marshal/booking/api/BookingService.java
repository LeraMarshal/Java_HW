package de.marshal.booking.api;

import de.marshal.booking.dto.Booking;
import de.marshal.booking.util.CustomDateInterval;

import java.util.List;

public interface BookingService {
    enum SortType {
        END_DATE,
        START_DATE,
        ID,
        ROOM_TYPE,
        PRICE
    }

    Booking getBooking(long bookingId);

    List<Booking> listAllBookings(SortType sortType);

    Booking addBooking(long roomId, boolean fc, CustomDateInterval interval);

    Booking updateBooking(long bookingId, long nextRoomId, boolean nextFc, CustomDateInterval nextInterval);

    Booking removeBooking(long bookingId);
}
