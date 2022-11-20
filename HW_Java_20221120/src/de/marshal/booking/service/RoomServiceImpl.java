package de.marshal.booking.service;

import de.marshal.booking.api.RoomDAO;
import de.marshal.booking.api.RoomService;
import de.marshal.booking.api.RoomType;
import de.marshal.booking.dto.Room;

import java.util.List;

public class RoomServiceImpl implements RoomService {
    private RoomDAO roomDAO;

    public RoomServiceImpl(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Override
    public Room getRoom(long roomId) {
        return roomDAO.getById(roomId);
    }

    @Override
    public List<Room> listAllRooms() {
        return roomDAO.findAll();
    }

    @Override
    public Room addRoom(long roomTypeId) {
        RoomType roomType = RoomType.ofTypeId(roomTypeId);
        Room room = new Room(roomType);

        roomDAO.add(room);

        return room;
    }
}
