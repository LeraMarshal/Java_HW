package t6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
    Есть лист  целых чисел. Написать метод, который вернет список без элементов, больше числа n.

    public List withoutElementsMoreThanN(List ints, int n)
     */

    public static void main(String[] args) {
        System.out.println(withoutElementsMoreThanN(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)), 4));
    }

    public static List<Integer> withoutElementsMoreThanN(List<Integer> ints, int n) {
//        List<Integer> res = new ArrayList<>();
//
//        for (Integer elem : ints) {
//            if (elem <= n){
//                res.add(elem);
//            }
//        }

        List<Integer> res = new ArrayList<>(ints);

        res.removeIf(i -> i > n);

        return res;
    }
}
