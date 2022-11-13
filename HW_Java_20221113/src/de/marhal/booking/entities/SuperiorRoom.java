package de.marhal.booking.entities;

import de.marhal.booking.RoomType;

public class SuperiorRoom extends Room {
    public SuperiorRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public long getPrice() {
        return 100L;
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.SUPERIOR;
    }

    @Override
    public boolean isFitnessCenterAccessIncl() {
        return false;
    }

    @Override
    public String toString() {
        return "SuperiorRoom{} " + super.toString();
    }
}
