import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, -1, 4, -5, 9};

        System.out.println(Arrays.toString(arr));
        System.out.println(returnMin(arr));
    }

    /*
    Дан массив целых чисел. Реализовать метод, который возвращает минимальное значение в данном массиве.
    Например: {1,3,6,-1,4,-5,9} -> -5
    */
    private static int returnMin(int[] arr) {
        int res = arr[0];
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if (res > arr[i]) {
                res = arr[i];
            }
        }

        return res;
    }
}
