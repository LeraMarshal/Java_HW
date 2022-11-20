package de.marshal.booking.api;

import de.marshal.booking.dto.Booking;

import java.util.List;

public interface BookingDAO {
    Booking getById(long id);

    List<Booking> findAll();

    List<Booking> findByRoomId(long roomId);

    void add(Booking booking);

    void update(Booking booking);

    void remove(Booking booking);
}
