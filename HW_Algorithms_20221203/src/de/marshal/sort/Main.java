package de.marshal.sort;

import java.util.Random;

public class Main {
    /*
    1. На основе кода из гита выполнить сравнение производительности алгоритмов bubble sort и quick sort
    при количестве элементов в 1000, 10000, 1000000 (Опционально можно применить эти же проверки к merge sort)

    Вычислить скорость выполнения обоих алгоритмов сортировки в наносекундах (использовать System.nanoTime) до и после выполнения метода
     */

    public static void main(String[] args) {
        test(1000);
        test(10000);
        test(100000);
        test(1000000);

        /*
        Bubble sort, size=1000, count=499500, time=0,008
        Quick sort, size=1000, count=11070, time=0,001
        Quick sort is 45,12 times quicker

        Bubble sort, size=10000, count=49995000, time=0,095
        Quick sort, size=10000, count=167209, time=0,002
        Quick sort is 299,00 times quicker

        Bubble sort, size=100000, count=4999950000, time=10,916
        Quick sort, size=100000, count=2148347, time=0,007
        Quick sort is 2327,35 times quicker

        Bubble sort, size=1000000, count=499999500000, time=1143,762
        Quick sort, size=1000000, count=24603275, time=0,073
        Quick sort is 20322,48 times quicker
         */
    }

    private static void test(int size) {
        Random r = new Random();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt() % size;
        }

        int[] tmp = new int[size];
        long start;
        long stop;

        // bubble sort
        System.arraycopy(arr, 0, tmp, 0, size);
        start = System.nanoTime();

        BubbleSort.bubbleSort(tmp);

        stop = System.nanoTime();
        System.out.printf("Bubble sort, size=%d, count=%d, time=%.3f\n", size, BubbleSort.count, 1.0 * (stop - start) / 1_000_000_000);

        // quick sort
        System.arraycopy(arr, 0, tmp, 0, size);
        start = System.nanoTime();

        QuickSort.quickSort(tmp);

        stop = System.nanoTime();
        System.out.printf("Quick sort, size=%d, count=%d, time=%.3f\n", size, QuickSort.count, 1.0 * (stop - start) / 1_000_000_000);

        System.out.printf("Quick sort is %.2f times quicker\n\n", 1.0 * BubbleSort.count / QuickSort.count);
    }
}
