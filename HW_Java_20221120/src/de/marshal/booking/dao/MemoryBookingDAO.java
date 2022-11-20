package de.marshal.booking.dao;

import de.marshal.booking.api.BookingDAO;
import de.marshal.booking.dto.Booking;
import de.marshal.booking.util.CustomDate;
import de.marshal.booking.util.CustomDateInterval;

import java.util.*;

public class MemoryBookingDAO implements BookingDAO {
    /*
    bookings
    | id | room_id | fc | start_year | start_month | start_day | end_year | end_month | end_day | price |
    -----------------------------------------------------------------------------------------------------
    | 1  | 1       | t  | 2022       | 11          | 11        | 2022     | 11        | 13      | 150   |
    | 2  | 1       | f  | 2022       | 11          | 13        | 2022     | 11        | 15      | 200   |

     */

    private class Row {
        long id;

        long room_id;

        boolean fc;

        int start_year;
        int start_month;
        int start_day;

        int end_year;
        int end_month;
        int end_day;

        long price;
    }

    /*
                id  room_id   ...
        1 =>  | 1  | 1      | ...
        2 =>  | 2  | 1      | ...

        id => Row
        id => | id | * | ...
     */
    private Map<Long, Row> DB = new HashMap<>();

    @Override
    public Booking getById(long id) {
        return convertRowToEntity(DB.get(id));
    }

    @Override
    public List<Booking> findAll() {
        List<Booking> list = new ArrayList<>();

        for (Row row : DB.values()) {
            list.add(convertRowToEntity(row));
        }

        return list;
    }

    @Override
    public List<Booking> findByRoomId(long roomId) {
        List<Booking> list = new ArrayList<>();

        for (Row row : DB.values()) {
            if (row.room_id == roomId) {
                list.add(convertRowToEntity(row));
            }
        }

        return list;
    }

    @Override
    public void add(Booking booking) {
        Row row = convertEntityToRow(booking);

        DB.put(row.id, row);
    }

    @Override
    public void update(Booking booking) {
        Row row = convertEntityToRow(booking);

        if (getById(row.id) == null) {
            throw new IllegalArgumentException("Entity with id " + row.id + " does not exist");
        }

        DB.put(row.id, row);
    }

    @Override
    public void remove(Booking booking) {
        Row row = convertEntityToRow(booking);

        if (getById(row.id) == null) {
            throw new IllegalArgumentException("Entity with id " + row.id + " does not exist");
        }

        DB.remove(row.id);
    }

    private Booking convertRowToEntity(Row row) {
        if (row == null) {
            return null;
        }

        return new Booking(
                row.id,
                row.room_id,
                row.fc,
                new CustomDateInterval(
                        new CustomDate(row.start_year, row.start_month, row.start_day),
                        new CustomDate(row.end_year, row.end_month, row.end_day)
                ),
                row.price
        );
    }

    private Row convertEntityToRow(Booking booking) {
        Objects.requireNonNull(booking);

        if (booking.getId() == null) {
            booking.setId(getNextId());
        }

        CustomDateInterval interval = booking.getInterval();
        CustomDate start = interval.getStart();
        CustomDate end = interval.getEnd();

        // По-хорошему, нужно дополнительно проверить, что start < end, но для простоты этого делать не будем

        Row row = new Row();

        row.id = booking.getId();
        row.room_id = booking.getRoomId();
        row.fc = booking.getFc();

        row.start_year = start.getYear();
        row.start_month = start.getMonth();
        row.start_day = start.getDay();

        row.end_year = end.getYear();
        row.end_month = end.getMonth();
        row.end_day = end.getDay();

        row.price = booking.getPrice();

        return row;
    }

    private Long getNextId() {
        Long max = 0L;

        for (Long key : DB.keySet()) {
            if (key > max) {
                max = key;
            }
        }

        return max + 1L;
    }
}
