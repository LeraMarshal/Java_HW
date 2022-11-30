package t4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    /*
     4. Написать метод, реверсирующий список, т.е. возвращающий список элементов в обратном порядке.
     Можно использовать методы класса Collections.

     1,2,3 -> 3,2,1
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(reverse(list));
        System.out.println(reverseUsingCollections(list));
    }

    public static List<Integer> reverse(List<Integer> list) {
        List<Integer> res = new ArrayList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            res.add(list.get(i));
        }

        return res;
    }

    public static List<Integer> reverseUsingCollections(List<Integer> list) {
        List<Integer> res = new ArrayList<>(list);

        Collections.reverse(res);

        return res;
    }
}


