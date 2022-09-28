import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arr = new String[]{
                "jack",
                "nick",
                "john",
                "jack",
                "tom",
                "john",
                "ann",
                "john"
        };

        System.out.println(countOccurrence(arr, "john", 1, 6));
        System.out.println(countOccurrence(arr, "sad", 0, 6));
        System.out.println(countOccurrence(arr, "john", 0, 7));

        System.out.println(Arrays.toString(createEvenIntArray(4, 21)));
    }

    /*
    First level:
    Реализовать метод, который возвращает сколько раз заданная имя
    встречается в массиве начиная с позиции start до позиции finish (включительно).
    Если строка не найдена, то возвращаем 0

    Например:
    countOccurrence({“jack”, “nick”, “john”,”jack”,”tom”,”john”,”ann”,”john”}, “john”,1,6) ->2
    countOccurrence({“jack”, “nick”, “john”,”jack”,”tom”,”john”,”ann”,”john”}, “sad”,0,6) ->0
    countOccurrence({“jack”, “nick”, “john”,”jack”,”tom”,”john”,”ann”,”john”}, “john”,0,7) ->3
     */
    private static int countOccurrence(String[] arr, String str, int start, int finish) {
        int realStart = Math.max(start, 0);
        int realFinish = Math.min(finish, arr.length);

        int count = 0;

        for (int i = realStart; i <= realFinish; i++) {
            if (str.equals(arr[i])) {
                count++;
            }
        }

        return count;
    }

    /*
    Реализовать метод, который создает массив из первых n четных чисел, начиная с заданного числа start.
    Например, для заданных n=4, start=21: {22,24,26,28}
     */
    private static int[] createEvenIntArray(int n, int start) {
        int[] res = new int[n];

        int realStart = (start % 2 == 0) ? start : start + 1;
        int realFinish = realStart + (2*n);

        for (int i = 0, elem = realStart; i < n; i++, elem += 2) {
            res[i] = elem;
        }

        return res;
    }
}