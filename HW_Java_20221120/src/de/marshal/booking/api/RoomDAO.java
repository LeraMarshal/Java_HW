package de.marshal.booking.api;

import de.marshal.booking.dto.Room;

import java.util.List;

public interface RoomDAO {
    Room getById(long id);

    List<Room> findAll();

    void add(Room room);
}
