public class Main {
    public static void main(String[] args) {
        printNumbers(7);

        System.out.println();

        System.out.println(sumNumbers(7));
    }

    /*
    First level: C помощью цикла for написать метод, печатающий цифры от 1 до  числа  n.
    */
    private static void printNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    /*
    Second level: C помощью цикла for написать метод возвращающий сумму цифр от 1 до числа n
     */
    private static long sumNumbers(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}