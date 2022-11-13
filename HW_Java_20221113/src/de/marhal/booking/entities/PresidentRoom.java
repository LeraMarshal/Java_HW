package de.marhal.booking.entities;

import de.marhal.booking.RoomType;

public class PresidentRoom extends Room{
    public PresidentRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public long getPrice() {
        return 200L;
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.PRESIDENT;
    }

    @Override
    public boolean isFitnessCenterAccessIncl() {
        return true;
    }

    @Override
    public String toString() {
        return "PresidentRoom{} " + super.toString();
    }
}
