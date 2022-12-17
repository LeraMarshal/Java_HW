import java.util.Arrays;
import java.util.function.Function;

public class Runner {
    static long[] arr = new long[100];

    static long COUNT = 0;

    public static void main(String[] args) {
        Arrays.fill(arr, 0, arr.length - 1, -1);

        for (int i = 0; i <= 5; i++) {
            System.out.printf("i=%d fib=%d fibTab=%d fibMemo=%d\n", i, fib(i), fibTab(i), fibMemo(i));
        }
        /*
        i=0 fib=1 fibTab=1 fibMemo=1
        i=1 fib=1 fibTab=1 fibMemo=1
        i=2 fib=2 fibTab=2 fibMemo=2
        i=3 fib=3 fibTab=3 fibMemo=3
        i=4 fib=5 fibTab=5 fibMemo=5
        i=5 fib=8 fibTab=8 fibMemo=8
         */

        System.out.println("Testing fib");
        test(Runner::fib, 5, 10, 25, 50);
        /*
        Testing fib
        testFunction(5) = 8, count=15, elapsedMs=0
        testFunction(10) = 89, count=177, elapsedMs=0
        testFunction(25) = 121393, count=242785, elapsedMs=3
        testFunction(50) = 20365011074, count=40730022147, elapsedMs=71602
         */

        System.out.println("Testing fibTab");
        test(Runner::fibTab, 5, 10, 25, 50);
        /*
        Testing fibTab
        testFunction(5) = 8, count=4, elapsedMs=0
        testFunction(10) = 89, count=9, elapsedMs=0
        testFunction(25) = 121393, count=24, elapsedMs=0
        testFunction(50) = 20365011074, count=49, elapsedMs=0
         */

        System.out.println("Testing fibMemo");
        test(Runner::fibMemo, 5, 10, 25, 50);
        /*
        Testing fibMemo
        testFunction(5) = 8, count=1, elapsedMs=0
        testFunction(10) = 89, count=11, elapsedMs=0
        testFunction(25) = 121393, count=31, elapsedMs=0
        testFunction(50) = 20365011074, count=51, elapsedMs=0
         */
    }

    public static void test(Function<Integer, Long> testFunction, int ...ns) {
        for (int n : ns) {
            COUNT = 0;

            long start = System.currentTimeMillis();
            long value = testFunction.apply(n);
            long stop = System.currentTimeMillis();

            System.out.printf("testFunction(%d) = %d, count=%d, elapsedMs=%d\n", n, value, COUNT, stop-start);
        }
    }

    /*
    В этой функции мы считаем числа с нуля.
    Т.е. последовательность [1, 1, 2, 3, 5, 8, ...], f(5) = 8
     */
    public static long fib(int n) {
        COUNT++;

        if (n < 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    /*
    В этой функции числа считались с 1. Т.е. последовательность [1, 1, 1, 2, 3, 5, ...], f(5) = 5
    Чтобы между функциями была согласованность, код изменен таким образом, чтобы f(5) = 8.
    При этом, в оригинальном коде в случае n < 2 выбрасывался бы IndexOutOfBoundsException, это тоже исправлено.
    Теперь код выдает ту же последовательность, что и fib(n): [1, 1, 2, 3, 5, 8, ...], f(5) = 8
     */
    public static long fibTab(int n) {
        if (n < 2) {
            return 1;
        }

        long[] arr2 = new long[n + 1];
        arr2[0] = 1;
        arr2[1] = 1;

        for (int i = 2; i <= n; i++) {
            COUNT++;

            arr2[i] = arr2[i - 1] + arr2[i - 2];
        }

        return arr2[n];
    }

    /*
    В этой функции мы считаем числа с нуля.
    Т.е. последовательность [1, 1, 2, 3, 5, 8, ...], f(5) = 8
     */
    public static long fibMemo(int n) {
        COUNT++;

        if (arr[n] != -1) {
            return arr[n];
        }

        if (n < 2) {
            return 1;
        }

        arr[n] = fibMemo(n - 1) + fibMemo(n - 2);
        return arr[n];
    }
}

