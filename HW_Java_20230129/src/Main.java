import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Напишите код, который создает Stream из массива чисел, фильтрует его по четным числам и выводит результат в консоль.
        Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
        System.out.println();

        // Напишите код, который создает Stream из списка строк, отсортировывает его по длине строк и выводит результат в консоль.
        List.of("abc", "a", "ab").stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
        System.out.println();

        // Напишите код, который создает Stream из диапазона чисел, отображает каждое число к его квадрату и выводит результат в консоль.
        IntStream.range(1, 4)
                .map(e -> e * e)
                .forEach(System.out::println);
        System.out.println();

        // Напишите код, который создает Stream из списка объектов, объединяет их в одну строку и выводит результат на консоль.
        System.out.println(
                List.of(1, 2, 3).stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "))
        );
        System.out.println();

        // Напишите код, который создает Stream из списка чисел, используя метод reduce() находит наибольшее число в списке.
        System.out.println(
                List.of(1, 2, 3).stream()
                        .reduce(null, (acc, next) -> (acc == null || acc < next) ? next : acc)
        );
        System.out.println();

        // Напишите код, который создает Stream из Map и, используя метод filter() и метод forEach(), выводит ключ-значение только тех элементов, значение которых больше заданного.
        Map.of("a", 1, "b", 2, "c", 3).entrySet().stream()
                .filter(e -> e.getValue() > 2)
                .forEach(System.out::println);
        System.out.println();

        // Напишите код, который считывает текстовый файл и используя Stream API, подсчитывает количество слов в файле.
        try (Stream<String> stream = Files.lines(Paths.get("Java_HW/HW_Java_20230129/src/faust.txt"))) {
            System.out.println(
                    stream.map(s -> s.trim().split("[\s\t\r\n]+"))
                            .flatMap(Arrays::stream)
                            .count()
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
