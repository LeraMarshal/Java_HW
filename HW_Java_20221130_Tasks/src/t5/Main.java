package t5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
    5*. Написать метод, который возвращает строку, встречающуюся раньше в листе:
    - самую короткую или самую длинную.
    Если несколько строчек самые короткие или самые длинные, тогда вернуть первую встреченную из них.
    (Лист не пустой)

    "bb","a","ff","ddd" -> "a"
    "bb","aaa","ff","d" -> "aaa"
     */

    public static void main(String[] args) {
        System.out.println(getFirstMinMaxStr(Arrays.asList("bb", "a", "ff", "ddd")));
        System.out.println(getFirstMinMaxStr(Arrays.asList("bb", "aaa", "ff", "d")));
    }

    private static String getFirstMinMaxStr(List<String> list) {
//        String max = list.get(0);
//        String min = list.get(0);
//
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i).length() > max.length()){
//                max = list.get(i);
//            }
//            if (list.get(i).length() < min.length()){
//                min = list.get(i);
//            }
//           }
//
//        if (list.indexOf(min) < list.indexOf(max)){
//            return min;
//        }
//
//        return max;

//        int minInd = 0;
//        int maxInd = minInd;

        String min = list.get(0);
        String max = min;

        int minLen = min.length();
        int maxLen = minLen;

        boolean maxLast = false; // последним было найдено максимальное значение

//        int i = 0;
        for (String elem : list) {
            int elemLen = elem.length();

            if (elemLen > maxLen) {
                max = elem;
//                maxInd = i;
                maxLen = elemLen;
                maxLast = true;
            }

            if (elemLen < minLen) {
                min = elem;
//                minInd = i;
                minLen = elemLen;
                maxLast = false;
            }

//            i++;
        }

//        return (minInd < maxInd) ? min : max;

        return (maxLast) ? min : max;
    }

}
