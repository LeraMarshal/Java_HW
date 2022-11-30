package t2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    /*
    2. есть список с именами Ivan,Maria, Stephan, John,Amalia.
    Написать метод, который вернет список, не содержащий имена исходного списка длиной 4.

    Ivan,Maria, Stephan, John,Amalia. -> Maria, Stephan,Amalia.
     */

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "Ivan", "Maria", "Stephan", "John", "Amalia"
        ));

        System.out.println(longThanFour(list));
        System.out.println(longThanFourStream(list));
        System.out.println(longThanFourLambda(list));
        System.out.println(longThanFourAnonClass(list));
    }

    public static List<String> longThanFour(List<String> list) {
        List<String> res = new ArrayList<>();

        for (String s : list) {
            if (s.length() != 4){
                res.add(s);
            }
        }

        return res;
    }

    public static List<String> longThanFourStream(List<String> list) {
        return list.stream()
                .filter(s -> s.length() != 4)
                .collect(Collectors.toList());
    }

    public static List<String> longThanFourLambda(List<String> list) {
        List<String> res = new ArrayList<>(list);

        res.removeIf(s -> s.length() == 4);

        return res;
    }

    public static List<String> longThanFourAnonClass(List<String> list) {
        List<String> res = new ArrayList<>(list);

        res.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 4;
            }
        });

        return res;
    }
}
