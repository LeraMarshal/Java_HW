import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        /*
        Создать новый проект написать. Написать программу, в которой задано 2 дробных числа.
        Программа должна выводить на экран результат сложения, вычитания, умножения и деления этих чисел.
        Например: задано 2 переменных: 10.6 и 2.2  в результате:
        10.6 + 2.2=12.8
        10.6 - 2.2=8.4
        10.6 * 2.2=23.32
        10.6 / 2.2=4.818181
        */

        double a = 10.6;
        double b = 2.2;

        System.out.println(a + " + " + b + " = " + (a + b)); // 10.6 + 2.2 = 12.8
        System.out.println(a + " - " + b + " = " + (a - b)); // 10.6 - 2.2 = 8.399999999999999
        System.out.println(a + " * " + b + " = " + (a * b)); // 10.6 * 2.2 = 23.32
        System.out.println(a + " / " + b + " = " + (a / b)); // 10.6 / 2.2 = 4.8181818181818175

        DecimalFormat df = new DecimalFormat("#.######" , new DecimalFormatSymbols(Locale.US));

        System.out.println(a + " + " + b + " = " + df.format(a + b)); // 10.6 + 2.2 = 12.8
        System.out.println(a + " - " + b + " = " + df.format(a - b)); // 10.6 - 2.2 = 8.4
        System.out.println(a + " * " + b + " = " + df.format(a * b)); // 10.6 * 2.2 = 23.32
        System.out.println(a + " / " + b + " = " + df.format(a / b)); // 10.6 / 2.2 = 4.818182
    }
}