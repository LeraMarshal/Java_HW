package de.marshal.booking.util;

import java.util.Objects;

public class CustomDateInterval {
    private CustomDate start;
    private CustomDate end;

    public CustomDateInterval(CustomDate start, CustomDate end) {
        Objects.requireNonNull(start);
        Objects.requireNonNull(end);

        if (start.compareTo(end) >= 0){
            throw new IllegalArgumentException("End date must be after start date");
        }

        this.start = start;
        this.end = end;
    }

    public int toDays() {
        return end.daysSince2020() - start.daysSince2020();
    }

    public CustomDate getStart() {
        return start;
    }

    public CustomDate getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return start + "/" + end;
    }

    public static boolean isIntersected(CustomDateInterval i1, CustomDateInterval i2){
        return !(i1.end.compareTo(i2.start) <= 0 || i2.end.compareTo(i1.start) <= 0);
    }
}
