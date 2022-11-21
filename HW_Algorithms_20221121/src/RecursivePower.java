public class RecursivePower {
    /*
    1. Даны два целых числа x и n, напишите функцию для вычисления x^n
     решение 1 - рекурсивно O(n)
     решение 2 - улучшить решение 1 до O(lon n)
     */

    public static void main(String[] args) {
        System.out.println(powRecLinear(2, 10));
        System.out.println(powRecLog(2, 11));
    }

    private static long powRecLinear(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return x * powRecLinear(x, n - 1);
    }

    private static long powRecLog(int x, int n) {
        if (n == 0) {
            return 1;
        }

        long halfPow = powRecLog(x, n/2);

        if (n % 2 == 0) {
            return halfPow * halfPow;
        } else {
            return halfPow * halfPow * x;
        }
    }
}
