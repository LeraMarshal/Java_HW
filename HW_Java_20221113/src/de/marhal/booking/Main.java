package de.marhal.booking;

import de.marhal.booking.entities.DeLuxeRoom;
import de.marhal.booking.entities.PresidentRoom;
import de.marhal.booking.entities.StandardRoom;
import de.marhal.booking.entities.SuperiorRoom;
import de.marhal.booking.util.MyDate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        Необходимо написать программу для сохранения данных о бронирование номеров гостиницы.

        В вашей программе должно быть несколько типов номеров, например:
            - standard
            - superior
            - de luxe
            - president
        Естественно, номера отличаются ценой проживания.

        Кроме того, номера категории de luxe, president предполагают доступ в fitness center,
        для остальных категорий номеров доступ в fitness center оплачивается как отдельная услуга.

        Ваша программа должна позволять сотрудникам отеля:
        1. Посмотреть все бронирования.
        2. Сохранить данные о бронировании
        3. Просмотреть данные о бронировании
        4. Отменить бронирование

        Данные о бронирование, если хотите, можно задать в программе константно или ввести через Scanner.

        Для отражения дат бронирования необходимо использовать написанный ранее класс MyDate (в данной задаче не
        используем стандартные Java классы для работы с датой).

        В качестве дополнительных задач: в классе MyDate реализовать методы:
        -подсчета количества дней в заданном интервале дат
        -определения пересечения интервалов
         */

        /*
        Hotel:

        Хранит в себе список номеров
        Список номеров передается через конструктор

        Хранит в себе список бронирований

        1. Посмотреть все бронирования
            Пройти по списку
                Распечатать индекс бронирования в списке (i)
                Распечатать само бронирование

        2. Сохранить данные о бронировании (добавить бронирование)
            ввести номер комнаты
            ввести дату начала
            ввести дату окончания
            ввести нужен ли доступ в фц
            создать бронирование
            сохранить бронирование в список

        3. Просмотреть данные о бронировании (по номеру бронирования в списке)
            Номер №...
            Тип номера: STANDARD
            Доступ в ФЦ: есть/нет
            Начало бронирования: YYYY/MM/DD
            Конец бронирования: YYYY/MM/DD
            Стоимость бронирования: ...

            Взять бронированирование с номером i из списка
            Распечатываем данные о бронировании

        4. Отменить бронирование (по номеру бронирования в списке)
            Удалить элемент с индексом i из списка

         Room:
            абстрактный
            int roomNumber
            abstract long getPrice()
            abstract RoomType getRoomType();
            abstract boolean isFitnessCenterAccessIncluded();

         StandardRoom, SuperiorRoom, DeluxeRoom, PresidentRoom

         RoomType:
            enum
            STANDARD, SUPERIOR, DELUXE, PRESIDENT

         Booking:
            Room room
            MyDate begin
            MyDate end
            boolean fitnessCenterAccess
         */

        Hotel hotel = new Hotel(List.of(
                new StandardRoom(1),
                new SuperiorRoom(2),
                new DeLuxeRoom(3),
                new PresidentRoom(4)
        ));

        hotel.addBooking(
                1,
                new MyDate(2022,10,12),
                new MyDate(2022,10,22),
                true
        );

        hotel.addBooking(
                1,
                new MyDate(2022, 10, 15),
                new MyDate(2022, 10, 18),
                false
        );

        hotel.addBooking(
                1,
                new MyDate(2022, 10, 22),
                new MyDate(2022, 10, 25),
                false
        );

        hotel.printBookings();
        System.out.println();

        hotel.printBooking(0);
        System.out.println();

        hotel.printBooking(1);
        System.out.println();

        hotel.removeBooking(1);

        hotel.printBookings();
    }
}
