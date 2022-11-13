package de.marhal.booking.entities;

import de.marhal.booking.RoomType;

public class DeLuxeRoom extends Room{
    public DeLuxeRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public long getPrice() {
        return 150L;
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.DELUXE;
    }

    @Override
    public boolean isFitnessCenterAccessIncl() {
        return true;
    }

    @Override
    public String toString() {
        return "DeLuxeRoom{} " + super.toString();
    }
}
