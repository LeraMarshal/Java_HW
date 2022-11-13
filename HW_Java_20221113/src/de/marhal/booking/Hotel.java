package de.marhal.booking;

import de.marhal.booking.entities.Booking;
import de.marhal.booking.entities.Room;
import de.marhal.booking.util.MyDate;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;
    private List<Booking> bookings = new ArrayList<>();

    public Hotel(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void printBookings(){
        for (int i = 0; i < bookings.size(); i++) {
            System.out.printf("Бронирование %d: %s\n", i, bookings.get(i));
        }
    }

    public void addBooking(int roomNumber, MyDate begin, MyDate end, boolean fitnessCenter){
        for (Booking booking : bookings) {
            if (booking.getRoom().getRoomNumber() == roomNumber && MyDate.isIntersected(begin, end, booking.getBegin(), booking.getEnd())) {
                System.out.println("Есть пересекающееся бронирование: " + booking);
                return;
            }
        }

        bookings.add(new Booking(getRoomByNumber(roomNumber), begin, end, fitnessCenter));
    }

    public void removeBooking(int index){
        bookings.remove(index);
    }

    public void printBooking(int index){
        Booking booking = bookings.get(index);
        Room room = booking.getRoom();

        long price = room.getPrice() * MyDate.daysInInterval(booking.getBegin(), booking.getEnd())
                + ((!room.isFitnessCenterAccessIncl() && booking.isFitnessCenterAccess()) ? 20L : 0L);

        System.out.println("Номер комнаты: " + room.getRoomNumber());
        System.out.println("Тип номера: " + room.getRoomType());
        System.out.println("Доступ в ФЦ: " + (room.isFitnessCenterAccessIncl() || booking.isFitnessCenterAccess()));
        System.out.println("Начало бронирования: " + booking.getBegin());
        System.out.println("Конец бронирования: " + booking.getEnd());
        System.out.println("Стоимость бронирования: " + price);
    }

    private Room getRoomByNumber(int roomNumber){
        for (Room room : rooms) {
            if (roomNumber == room.getRoomNumber()){
                return room;
            }
        }
        return null;
    }


}
