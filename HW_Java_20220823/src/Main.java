public class Main {
    public static void main(String[] args) {
       /*
       First level: Используя знания об операторе IF, напишите программу,
       которая выводит на экран большее из 3 чисел. Числа заданы в виде переменных num1, num2, num3.
        */

        int num1 = getRandomNumber();
        int num2 = getRandomNumber();
        int num3 = getRandomNumber();

        int max = num1;

        max = (num2 > max) ? num2 : max;
        max = (num3 > max) ? num3 : max;

        System.out.println("Num1 = " + num1);
        System.out.println("Num2 = " + num2);
        System.out.println("Num3 = " + num3);
        System.out.println("Max = " + max);
    }

    // возвращает случайное число от 0 до 9
    public static int getRandomNumber() {
        return (int) (10 * Math.random());
    }
}