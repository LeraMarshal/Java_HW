package de.marshal.booking;

import de.marshal.booking.api.*;
import de.marshal.booking.dao.MemoryBookingDAO;
import de.marshal.booking.dao.MemoryRoomDAO;
import de.marshal.booking.service.BookingServiceImpl;
import de.marshal.booking.service.RoomServiceImpl;
import de.marshal.booking.util.CustomDate;
import de.marshal.booking.util.CustomDateInterval;

import java.util.Scanner;

public class Main {
    /*
    1. В классе MyDate задать натуральный порядок дат, т.е. реализовать интерфейс Comparable.
    При этом пусть считается, что 01.01.2020 < 01.01.2022, т.е. дата тем больше, чем более поздний момент она отражает.

    3. Доработать программу про отель: добавить диалог с пользователем.

    Программа должна предлагать пользователю:
        добавить новую запись
        удалить запись
        вывести список бронирований
        завершить работу с программой

    Пользователь должен иметь возможность задать порядок вывода бронирований на экран:
        по дате заезда
        по дате выезда
        по порядку бронирований
        по категории номера
        по цене
     */

    public static void main(String[] args) {
        RoomDAO roomDAO = new MemoryRoomDAO();
        BookingDAO bookingDAO = new MemoryBookingDAO();

        RoomService roomService = new RoomServiceImpl(roomDAO);
        BookingService bookingService = new BookingServiceImpl(roomDAO, bookingDAO);

        Scanner scanner = new Scanner(System.in);

        // Вручную добавим комнаты
        System.out.println(roomService.addRoom(RoomType.STANDARD.getId()));
        System.out.println(roomService.addRoom(RoomType.STANDARD.getId()));
        System.out.println(roomService.addRoom(RoomType.STANDARD.getId()));
        System.out.println(roomService.addRoom(RoomType.STANDARD.getId()));

        System.out.println(roomService.addRoom(RoomType.SUPERIOR.getId()));
        System.out.println(roomService.addRoom(RoomType.SUPERIOR.getId()));
        System.out.println(roomService.addRoom(RoomType.SUPERIOR.getId()));

        System.out.println(roomService.addRoom(RoomType.DELUXE.getId()));
        System.out.println(roomService.addRoom(RoomType.DELUXE.getId()));

        System.out.println(roomService.addRoom(RoomType.PRESIDENT.getId()));

        // Вручную добавим некоторые бронирования
        System.out.println(bookingService.addBooking(
                1L,
                true,
                new CustomDateInterval(new CustomDate(2022, 11, 10), new CustomDate(2022, 11, 15)))
        );
        System.out.println(bookingService.addBooking(
                1L,
                false,
                new CustomDateInterval(new CustomDate(2022, 11, 15), new CustomDate(2022, 11, 17)))
        );
        System.out.println(bookingService.addBooking(
                1L,
                true,
                new CustomDateInterval(new CustomDate(2022, 11, 20), new CustomDate(2022, 11, 22)))
        );

        ConsoleApplication consoleApplication = new ConsoleApplication(
                scanner,
                roomService,
                bookingService
        );

        consoleApplication.menu();
    }
}
