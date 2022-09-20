import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = createArr(10, -10, 10);

        System.out.println(Arrays.toString(arr));

        System.out.println(sumPositives(arr));
    }

    /* first lvl
    Реализовать метод, который создает и заполняет массив числами int в диапазоне от minValue до maxValue
     */
    private static int[] createArr(int length, int minValue, int maxValue) {
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
        }

        return arr;
    }

    /*
    Дан массив int. Реализовать метод, который считает сумму положительных элементов массива.
    {3, 2, -1, 5, -3} ->10
    */
    public static int sumPositives(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
            }
        }
        return sum;
    }
}


