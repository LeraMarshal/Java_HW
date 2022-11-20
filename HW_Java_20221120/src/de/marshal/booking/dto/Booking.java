package de.marshal.booking.dto;

import de.marshal.booking.util.CustomDateInterval;

public class Booking {
    private Long id;

    private long roomId;

    // fitness center
    private boolean fc;

    private CustomDateInterval interval;

    private long price;

    public Booking(Long id, long roomId, boolean fc, CustomDateInterval interval, long price) {
        this.id = id;
        this.roomId = roomId;
        this.fc = fc;
        this.interval = interval;
        this.price = price;
    }

    public Booking(long roomId, boolean fc, CustomDateInterval interval, long price) {
        this.roomId = roomId;
        this.fc = fc;
        this.interval = interval;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (this.id != null) {
            throw new IllegalArgumentException("Cannot change id on an existing entity");
        }

        this.id = id;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public boolean getFc() {
        return fc;
    }

    public void setFc(boolean fc) {
        this.fc = fc;
    }

    public CustomDateInterval getInterval() {
        return interval;
    }

    public void setInterval(CustomDateInterval interval) {
        this.interval = interval;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", fc=" + fc +
                ", interval=" + interval +
                ", price=" + price +
                '}';
    }
}
