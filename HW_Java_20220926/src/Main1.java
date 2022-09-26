import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        String[] arr1 = {"qwe", "axcvbn", "qwertyuio", "qas" };
        String[] arr2 = {};

        System.out.println(Arrays.toString(arr1));
        System.out.println(maxElemLengthIdx(arr1));
        System.out.println(maxElemLengthIdx(arr2));
    }

    /*
    Дан массив строк. Реализовать метод, который возвращает индекс самой длинной строки в данном массиве.
    Например: {“qwe”,”axcvbn”,”qwertyuio”,”qas”} -> 2
    */
    private static int maxElemLengthIdx(String[] arr) {
        if (arr.length == 0) {
            return -1;
        }

        int len = arr.length;

        int maxElemLen = arr[0].length();
        int maxElemIdx = 0;

        for (int i = 0; i < len; i++) {
            int elemLen = arr[i].length();
            if (elemLen > maxElemLen) {
                maxElemLen = elemLen;
                maxElemIdx = i;
            }
        }

        return maxElemIdx;
    }
}
