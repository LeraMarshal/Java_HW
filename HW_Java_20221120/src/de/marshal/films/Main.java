package de.marshal.films;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*
    2. Создать класс Film c полями: название, жанр, рейтинг, год; Создать список фильмов. Программа должна спрашивать,
    какая сортировка нужна пользователю (по названию, по рейтингу, по жанру или году) и выводить отсортированный список на экран.
     */

    public static void main(String[] args) {
        List<Film> films = new ArrayList<>(List.of(
                new Film("T5", "G5", 5, 2005),
                new Film("T3", "G3", 3, 2003),
                new Film("T1", "G1", 1, 2001),
                new Film("T2", "G2", 2, 2002),
                new Film("T4", "G4", 4, 2004)
        ));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter sort field:");
        System.out.println("  1. Title");
        System.out.println("  2. Genre");
        System.out.println("  3. Rating");
        System.out.println("  4. Year");

        int option = scanner.nextInt();

        switch (option) {
//            case 1: films.sort((f1, f2) -> f1.getTitle().compareTo(f2.getTitle())); break;
            case 1:
                films.sort(Comparator.comparing(Film::getTitle));
                break;

//            case 2: films.sort((f1, f2) -> f1.getGenre().compareTo(f2.getGenre())); break;
            case 2:
                films.sort(Comparator.comparing(Film::getGenre));
                break;

//            case 3: films.sort((f1, f2) -> {
//                if (f1.getRating() == f2.getRating()) {
//                    return 0;
//                }
//                return (f1.getRating() > f2.getRating()) ? 1 : -1;
//            }); break;
            case 3:
                films.sort(Comparator.comparingDouble(Film::getRating));
                break;

//            case 4: films.sort((f1, f2) -> f1.getYear() - f2.getYear()); break;
            case 4:
                films.sort(Comparator.comparingInt(Film::getYear));
                break;
        }

        for (Film film : films) {
            System.out.println(film);
        }
    }
}
