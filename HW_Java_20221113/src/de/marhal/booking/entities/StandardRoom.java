package de.marhal.booking.entities;

import de.marhal.booking.RoomType;

public class StandardRoom extends Room{
    public StandardRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public long getPrice() {
        return 50L;
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.STANDARD;
    }

    @Override
    public boolean isFitnessCenterAccessIncl() {
        return false;
    }

    @Override
    public String toString() {
        return "StandardRoom{} " + super.toString();
    }
}
