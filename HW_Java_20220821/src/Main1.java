public class Main1 {
    public static int T_MAX = 200;
    public static int T_LOW = 100;
    public static int T_HIGH = 150;
    public static int T_SUM = 250;

    public static void main(String[] args) {
        /*
        Second level: Допустим, у вас есть прибор, у которого есть 3 колбы.
        Каждая колба имеет датчик температуры. Считается, что прибор работает правильно,
        если температура в одной из трех колб (не известно в какой) температура более 150 градусов,
        а в остальных менее100 градусов, и при этом сумма температур всех трех колб не превышает 250 градусов.
         */

        int flask1 = Main.getRandomTemperature(T_MAX);
        int flask2 = Main.getRandomTemperature(T_MAX);
        int flask3 = Main.getRandomTemperature(T_MAX);

        boolean condition1 = false
                || (flask1 > T_HIGH && flask2 < T_LOW && flask3 < T_LOW)
                || (flask1 < T_LOW && flask2 > T_HIGH && flask3 < T_LOW)
                || (flask1 < T_LOW && flask2 < T_LOW && flask3 > T_HIGH);
        boolean condition2 = (flask1 + flask2 + flask3) <= T_SUM;

        boolean isRunningCorrectly = condition1 && condition2;

        System.out.println("Flask 1 = " + flask1);
        System.out.println("Flask 2 = " + flask2);
        System.out.println("Flask 3 = " + flask3);

        System.out.println("Is running correctly: " + isRunningCorrectly);
    }
}
