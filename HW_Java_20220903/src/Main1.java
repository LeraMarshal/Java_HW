public class Main1 {
    public static void main(String[] args) {
        /*
            Дано целое число num. Необходимо написать программу, которая считает, сколько разрядов в этом числе.
            Например:
           	3 -> 1
           	343 -> 3
           	98761 -> 5
         */

        int num = 98761;
        int count = 0;

        System.out.printf("%d -> ", num);

        do {
            count++;
            num /= 10;
        } while (num != 0);

        System.out.println(count);
    }
}
