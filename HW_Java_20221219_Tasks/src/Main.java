import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // 1.
        System.out.println(mapStringBoolean(new String[]{"a", "b", "a", "c", "b"})); // {a=true, b=true, c=false}
        System.out.println(mapStringBoolean(new String[]{"c", "c", "c", "c", "c"})); // {c=true}

        // 2.
        List<String> list = List.of("Vasily", "John", "Vasily", "Jack", "Vasily");
        System.out.println(nameToNumberOccurence(list, "Vasily"));  // 3

        // 3.
        System.out.println(findDominantElem(new int[]{1, 2, 2, 2, 3, 4, 2, 5, 2, 2})); // 2
        System.out.println(findDominantElem(new int[]{1, 2, 2, 2, 3, 4, 2, 5, 7, 6})); // -1

        // 4.
        System.out.println(anagramsList("ivan", List.of("ivan", "maria", "kolya", "vani", "amari", "vian")));
    }

    /*
    1. Дан массив строк (не пустой) написать метод, возвращающий Map<String,Boolean>,
    где каждая строка является ключом, а значением является true, если строка в массиве
    встречается больше одного раза, и false, если только один раз.
     */
    public static Map<String, Boolean> mapStringBoolean(String[] arr) {
        Map<String, Boolean> map = new LinkedHashMap<>();

//        for (String s : arr) {
//            Boolean value = map.get(s);
//
//            if (value == null) {
//                map.put(s, false);
//            } else if (value == false) {
//                map.put(s, true);
//            }
//        }

        for (String s : arr) {
            map.merge(s, false, (prev, curr) -> true);
        }

        return map;
    }

    /*
    2. Дан лист имен, где некоторые имена повторяются. Написать метод, который по имени
     вернет количество вхождений этого имени в список.
     */
    public static int nameToNumberOccurence(List<String> list, String name) {
        Map<String, Integer> map = new LinkedHashMap<>();

        for (String s : list) {
            map.merge(s, 1, Integer::sum);
        }

        return map.get(name);
    }

    /*
     3. Дан массив положительных целых чисел. Найти элемент (если он есть), который
     встречается в массиве >length/2 (доминантный элемент). В противном случае вернуть -1
     */
    public static int findDominantElem(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i : arr) {
            Integer val = map.merge(i, 1, Integer::sum);
            if (val > arr.length / 2) {
                return i;
            }
        }

        return -1;
    }

    /*
     4. Написать метод, который принимает список имен и их анаграмм, и имя, по которому он выдаст
     список всех анаграмм этого имени, включая само имя.
     */
    public static List<String> anagramsList(String name, List<String> strings) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> requiredCounters = strToCharCountersMap(name);

        int requiredLength = name.length();
        for (String s : strings) {
            if (s.length() != requiredLength) {
                continue;
            }

            if (requiredCounters.equals(strToCharCountersMap(s))) {
                result.add(s);
            }
        }

        return result;
    }

    private static Map<Character, Integer> strToCharCountersMap(String s) {
        Map<Character, Integer> counters = new LinkedHashMap<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            counters.merge(s.charAt(i), 1, Integer::sum);
        }

        return counters;
    }
}
