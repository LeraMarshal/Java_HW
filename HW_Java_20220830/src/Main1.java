public class Main1 {
    public static void main(String[] args) {
        /*
        ( Необходимо написать программу, которая печатает все целые числа в диапазоне
        между num1 и num2 включительно. Учтите, num1 может быть как меньше,
        так больше или равно  num2.)

        lvl2:
        В предыдущей задаче (см. выше), для каждого числа, которое делится на 2 выводить надпись «делиться на 2».
        Для каждого числа, которое делится на 3 выводить надпись «делится на 3»
         */

        int num1 = 2;
        int num2 = 12;

        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);

        int i = min;
        while (i <= max) {
            System.out.print(i);
            if (i % 2 == 0) {
                System.out.print(", делится на 2");
            }
            if (i % 3 == 0) {
                System.out.print(", делится на 3");
            }
            System.out.println();
            i++;
        }
    }
}
