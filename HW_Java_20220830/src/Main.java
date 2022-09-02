public class Main {
    public static void main(String[] args) {
        /*
        Необходимо написать программу, которая печатает все целые числа в диапазоне
        между num1 и num2 включительно. Учтите, num1 может быть как меньше,
        так больше или равно  num2.

        Например: num1=3   num2=5;   Выводим
        3
        4
        5
         */

        int num1 = 5;
        int num2 = 3;

        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);

        int i = min;
        while (i <= max) {
            System.out.println(i);
            i++;
        }
    }
}
