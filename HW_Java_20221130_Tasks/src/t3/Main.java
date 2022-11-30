package t3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    /*
      3. Есть два списка одинаковой длины с целыми числами.
       Написать метод, который вернет список с элементами Yes или No,
       где значение на i-м месте зависит от того, равны ли элементы двух списков под номером i.

       {1,2,3,4} ,{5,2,3,8} ->{No,Yes,Yes,No}
     */

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(5, 2, 3, 8);

        System.out.println(getComparedList(list1, list2));
    }

    public static List<String> getComparedList(List<Integer> list1, List<Integer> list2) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {
            res.add(Objects.equals(list1.get(i), list2.get(i)) ? "Yes" : "No");
        }

        return res;
    }
}
