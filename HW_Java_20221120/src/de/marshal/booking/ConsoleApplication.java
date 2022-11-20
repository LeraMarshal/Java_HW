package de.marshal.booking;

import de.marshal.booking.api.BookingService;
import de.marshal.booking.api.RoomService;
import de.marshal.booking.api.RoomType;
import de.marshal.booking.dto.Booking;
import de.marshal.booking.dto.Room;
import de.marshal.booking.util.CustomDate;
import de.marshal.booking.util.CustomDateInterval;

import java.util.Scanner;

public class ConsoleApplication {
    private Scanner scanner;
    private RoomService roomService;
    private BookingService bookingService;

    public ConsoleApplication(Scanner scanner, RoomService roomService, BookingService bookingService) {
        this.scanner = scanner;
        this.roomService = roomService;
        this.bookingService = bookingService;
    }

    public void menu() {
        while (true) {
            System.out.println("--------------------");
            System.out.println("1. ADD BOOKING");
            System.out.println("2. UPDATE BOOKING");
            System.out.println("3. REMOVE BOOKING");
            System.out.println("4. LIST BOOKINGS");
            System.out.println("5. LIST ROOMS");
            System.out.println("6. PRINT BOOKING");
            System.out.println("0. EXIT");
            System.out.println("--------------------");

            try {
                int option = scanner.nextInt();
                switch (option) {
                    case 1: // add
                        createNewBooking();
                        break;

                    case 2: // update
                        updateBooking();
                        break;

                    case 3: // remove
                        removeBooking();
                        break;

                    case 4: // list bookings
                        printBookings();
                        break;

                    case 5: // list rooms
                        printRooms();
                        break;

                    case 6: // print selected booking
                        printSelectedBooking();
                        break;

                    case 0:
                        return;
                }
            } catch (Exception ex) {
                System.out.println("Error during operation: " + ex);
            }
        }
    }

    private void createNewBooking() {
        System.out.print("Enter room id: ");
        long roomId = scanner.nextLong();

        System.out.print("Include fitness center (true or false): ");
        boolean fc = scanner.nextBoolean();

        System.out.println("Enter start date (yyyy mm dd): ");
        int startYear = scanner.nextInt();
        int startMonth = scanner.nextInt();
        int startDay = scanner.nextInt();

        System.out.println("Enter end date (yyyy mm dd): ");
        int endYear = scanner.nextInt();
        int endMonth = scanner.nextInt();
        int endDay = scanner.nextInt();

        System.out.println(bookingService.addBooking(
                roomId,
                fc,
                new CustomDateInterval(
                        new CustomDate(startYear, startMonth, startDay),
                        new CustomDate(endYear, endMonth, endDay)
                )
        ));
    }

    private void updateBooking() {
        System.out.print("Enter booking id: ");
        long bookingId = scanner.nextLong();

        System.out.print("Enter new room id: ");
        long roomId = scanner.nextLong();

        System.out.print("Include fitness center (true or false): ");
        boolean fc = scanner.nextBoolean();

        System.out.println("Enter new start date (yyyy mm dd): ");
        int startYear = scanner.nextInt();
        int startMonth = scanner.nextInt();
        int startDay = scanner.nextInt();

        System.out.println("Enter new end date (yyyy mm dd): ");
        int endYear = scanner.nextInt();
        int endMonth = scanner.nextInt();
        int endDay = scanner.nextInt();

        Booking previousBooking = bookingService.getBooking(bookingId);
        Booking nextBooking = bookingService.updateBooking(
                bookingId,
                roomId,
                fc,
                new CustomDateInterval(
                        new CustomDate(startYear, startMonth, startDay),
                        new CustomDate(endYear, endMonth, endDay)
                )
        );

        System.out.println("Previous booking: " + previousBooking);
        System.out.println("Next booking: " + nextBooking);
        System.out.println("Price difference: " + (nextBooking.getPrice() - previousBooking.getPrice()));
    }

    private void removeBooking() {
        System.out.print("Enter booking id: ");
        long bookingId = scanner.nextLong();

        System.out.println(bookingService.removeBooking(bookingId));
    }

    private void printBookings() {
        System.out.println("Enter sort type:");
        System.out.println("  1. End date");
        System.out.println("  2. Start date");
        System.out.println("  3. Id");
        System.out.println("  4. Room type");
        System.out.println("  5. Price");

        int sortTypeOption = scanner.nextInt();

        BookingService.SortType sortType = BookingService.SortType.ID;
        switch (sortTypeOption) {
            case 1:
                sortType = BookingService.SortType.END_DATE;
                break;

            case 2:
                sortType = BookingService.SortType.START_DATE;
                break;

            case 3:
                sortType = BookingService.SortType.ID;
                break;

            case 4:
                sortType = BookingService.SortType.ROOM_TYPE;
                break;

            case 5:
                sortType = BookingService.SortType.PRICE;
                break;
        }

        for (Booking booking : bookingService.listAllBookings(sortType)) {
            System.out.println(booking);
        }
    }

    private void printRooms() {
        for (Room room : roomService.listAllRooms()) {
            System.out.println(room);
        }
    }

    private void printSelectedBooking() {
        System.out.print("Enter booking id: ");
        long bookingId = scanner.nextLong();

        Booking booking = bookingService.getBooking(bookingId);
        if (booking == null) {
            System.out.println("Booking with id " + bookingId + " does not exist");
            return;
        }

        Room room = roomService.getRoom(booking.getRoomId());
        if (room == null) {
            System.out.println("Room with id " + booking.getRoomId() + " does not exist");
            return;
        }

        RoomType roomType = room.getRoomType();

        System.out.println("Booking #" + booking.getId() + " (" + booking.getInterval() + ")");
        System.out.println("Room #" + room.getId());
        System.out.println("Room type: " + roomType.name());
        System.out.println("Price per night: " + roomType.getRoomPrice());
        System.out.println("Fitness center access: " + ((booking.getFc() || roomType.getFcPrice() == 0L) ? "yes" : "no"));
        System.out.println("Total price: " + booking.getPrice());
    }
}
