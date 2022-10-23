package de.marshal.tickets;

public class MyDateTime {
    private int year;
    private int mouth;
    private int day;
    private int hour;
    private int min;

    public MyDateTime(int year, int mouth, int day, int hour, int min) {
        this.year = year;
        this.mouth = mouth;
        this.day = day;
        this.hour = hour;
        this.min = min;
    }

    @Override
    public String toString() {
        return "MyDateTime{" +
                "year=" + year +
                ", mouth=" + mouth +
                ", day=" + day +
                ", hour=" + hour +
                ", min=" + min +
                '}';
    }
}
