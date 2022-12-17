import java.util.*;
import java.util.function.BiFunction;

public class Main {
    /*
    Дана MapAB. Написать метод, который вернет мапу, такую, что
    если в исходной мапе есть ключи "а" и "b" то нужно создать новый ключ "аb"
    с суммой значений от ключей а и b, а если нет, ничего не менять.

    Примеры:
       mapAB {"a":"Hi", b:There}-> {"a":Hi; ab: HiThere;b:There}
       mapAB {a:Hi}->{a:Hi}
       mapAB {b:There}->{b:There}
     */

    public static void main(String[] args) {

        Map<String, String> map1 = Map.of("a", "Hi", "b", "There");
        Map<String, Integer> map2 = Map.of("a", 1, "b", 2);
        Map<Integer, String> map3 = Map.of(1, "Hi", 2, "There");

        var mapAB1 = mapAB(map1, "a", "b", String::concat, String::concat); // (s1, s2) -> s1 + s2
        var mapAB2 = mapAB(map2, "a", "b", String::concat, Integer::sum); // (n1, n2) -> n1 + n2
        var mapAB3 = mapAB(map3, 1, 2, (n1, n2) -> Integer.parseInt(n1.toString() + n2.toString()), String::concat);

        System.out.println(mapAB1); // {a=Hi, b=There, ab=HiThere}
        System.out.println(mapAB2); // {a=1, b=2, ab=3}
        System.out.println(mapAB3); // {1=Hi, 2=There, 12=HiThere}
    }

    public static <K, V> Map<K, V> mapAB(
            Map<K, V> map,
            K k1,
            K k2,
            BiFunction<K, K, K> keyCombiner,
            BiFunction<V, V, V> valueCombiner
    ) {
        Map<K, V> result = new LinkedHashMap<>(map);

        if (result.containsKey(k1) && result.containsKey(k2)) {
            K nextKey = keyCombiner.apply(k1, k2);
            V nextValue = valueCombiner.apply(result.get(k1), result.get(k2));

            result.put(nextKey, nextValue);
        }

        return result;
    }
}
