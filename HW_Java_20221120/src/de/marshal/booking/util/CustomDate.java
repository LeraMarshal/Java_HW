package de.marshal.booking.util;

public class CustomDate implements Comparable<CustomDate> {
    private int year;
    private int month;
    private int day;

    public CustomDate(int year, int month, int day) {
        if (year < 2020) {
            throw new IllegalArgumentException("Year must be greater or equal to 2020");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be in range of 1..12");
        }
        if (day < 1 || day > daysInMonth(year, month)) {
            throw new IllegalArgumentException("Day must be in range of 1..days in month");
        }

        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public int compareTo(CustomDate d) {
        if (this.year != d.year) {
            return this.year - d.year;
        }

        if (this.month != d.month) {
            return this.month - d.month;
        }

        if (this.day != d.day) {
            return this.day - d.day;
        }

        return 0;
    }

    public int daysSince2020(){
        int days = 0;

        for (int i = 2020; i < year; i++) {
            days += (isLeapYear(i) ? 366 : 365);
        }

        for (int i = 1; i < month; i++) {
            days += daysInMonth(year,i);
        }

        days += (day - 1);

        return days;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    private static int daysInMonth(int year, int month) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
}
