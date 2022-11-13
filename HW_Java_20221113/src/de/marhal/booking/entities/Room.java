package de.marhal.booking.entities;

import de.marhal.booking.RoomType;

public abstract class  Room {
    private int roomNumber;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public abstract long getPrice();

    public abstract RoomType getRoomType();

    public abstract boolean isFitnessCenterAccessIncl();

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                '}';
    }
}
