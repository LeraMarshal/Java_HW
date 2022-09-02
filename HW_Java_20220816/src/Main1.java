public class Main1 {
    public static void main(String[] args) {

        /*
        // Эксперименты. При математических операциях с дробными числами результат не всегда предсказуем.

        System.out.println(1000000.0f + 1.2f - 1000000.0f);                     // 1.1875
        System.out.println(1000000000000000.0 + 1.2 - 1000000000000000.0);      // 1.25
        System.out.println(1000000000000000000L + 12L - 1000000000000000000L);  // 12

        double a = 3.65;
        double b = 0.05;
        double c = 3.70;
        System.out.println(a + b == c); // false

        */

        // Но конкретно это работает.
        double price = 123.45;
        double tax = 0.19;

        double taxAmount = Math.round(price * tax * 100.0)/100.0;
        System.out.println(price + taxAmount);   // 146.91
    }
}
