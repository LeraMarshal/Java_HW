package de.marhal.booking.entities;

import de.marhal.booking.util.MyDate;

public class Booking {
    private Room room;
    private MyDate begin;
    private MyDate end;
    private boolean fitnessCenterAccess;

    public Booking(Room room, MyDate begin, MyDate end, boolean fitnessCenterAccess) {
        this.room = room;
        this.begin = begin;
        this.end = end;
        this.fitnessCenterAccess = fitnessCenterAccess;
    }

    public Room getRoom() {
        return room;
    }

    public MyDate getBegin() {
        return begin;
    }

    public MyDate getEnd() {
        return end;
    }

    public boolean isFitnessCenterAccess() {
        return fitnessCenterAccess;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", begin=" + begin +
                ", end=" + end +
                ", fitnessCenterAccess=" + fitnessCenterAccess +
                '}';
    }
}
