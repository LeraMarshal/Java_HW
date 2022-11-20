package de.marshal.films;

public class Film {
    private String title;
    private String genre;
    private double rating;
    private int year;

    public Film(String title, String genre, double rating, int year) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", year=" + year +
                '}';
    }
}
