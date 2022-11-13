package de.marhal.booking.util;

public class MyDate {
    public static int daysSince2020(MyDate date) {
        int days = 0;

        for (int i = 2020; i < date.year; i++) {
            days += isLeapYear(i) ? 366 : 365;
        }

        for (int i = 1; i < date.month; i++) {
            days += getDaysInMonth(i, date.year);
        }

        days += date.day - 1;

        return days;
    }

    public static int daysInInterval(MyDate begin, MyDate end) {
        return daysSince2020(end) - daysSince2020(begin);
    }

    public static boolean isIntersected(MyDate begin1, MyDate end1, MyDate begin2, MyDate end2) {
        // !(begin1 > end2 || begin2 > end1)
        return !(daysSince2020(begin1) >= daysSince2020(end2) || daysSince2020(begin2) >= daysSince2020(end1));
    }

    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        if (year < 2020) {
            throw new IllegalArgumentException("Date must be after or equal to 2020-01-01");
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be in range of 1..12");
        }

        if (day < 1 || day > getDaysInMonth(month, year)) {
            throw new IllegalArgumentException("Day must be in range of 1..daysInMonth");
        }

        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    private static int getDaysInMonth(int month, int year) {
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

    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }
}
