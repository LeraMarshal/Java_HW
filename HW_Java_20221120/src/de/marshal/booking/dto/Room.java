package de.marshal.booking.dto;

import de.marshal.booking.api.RoomType;

public class Room {
    private Long id; // id сущности, если null, то в БД его нет
    private RoomType roomType;

    public Room(Long id, RoomType roomType) {
        this.id = id;
        this.roomType = roomType;
    }

    public Room(RoomType roomType) {
        this.roomType = roomType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (this.id != null){
            throw new IllegalArgumentException("Can not change id on an existing entity");
        }
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomType=" + roomType +
                '}';
    }
}
