package de.marshal.booking.api;

import de.marshal.booking.dto.Room;

import java.util.List;

public interface RoomService {
    Room getRoom(long roomId);

    List<Room> listAllRooms();

    Room addRoom(long roomTypeId);
}
