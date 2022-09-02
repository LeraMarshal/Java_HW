public class Main {
    public static int T_MAX = 300;
    public static int T_LOW = 100;
    public static int T_HIGH = 200;

    public static void main(String[] args) {
        /*
        First level: Допустим, у вас есть прибор, у которого есть 3 колбы.
        Каждая колба имеет датчик температуры. Считается, что прибор работает правильно,
        если температура в каждой из трех колб не меньше 100 или есть такая колба,
        температура которой более 200 градусов.
        Напишите программу проверки корректности работы такого прибора.
         */

        int flask1 = getRandomTemperature(T_MAX);
        int flask2 = getRandomTemperature(T_MAX);
        int flask3 = getRandomTemperature(T_MAX);

        boolean everyFlaskTempEqOrGreaterThanTLow = flask1 >= T_LOW && flask2 >= T_LOW && flask3 >= T_LOW;
        boolean someFlaskTempGreaterThanTHigh = flask1 > T_HIGH || flask2 > T_HIGH || flask3 > T_HIGH;

        boolean isRunningCorrectly = everyFlaskTempEqOrGreaterThanTLow || someFlaskTempGreaterThanTHigh;

        System.out.println("Flask 1 = " + flask1);
        System.out.println("Flask 2 = " + flask2);
        System.out.println("Flask 3 = " + flask3);

        System.out.println("Is running correctly: " + isRunningCorrectly);
    }

    public static int getRandomTemperature(int tMax) {
        return (int) Math.round(tMax * Math.random());
    }
}
