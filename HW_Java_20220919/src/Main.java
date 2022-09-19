public class Main {
    public static void main(String[] args) {
        System.out.println(doubleStringLength("hello"));

        System.out.println(end("abcd"));

        System.out.println(start("abcd"));
    }

    /*
     First level: Написать метод, возвращающий целое число равное двойной длине строки,
     принимаемой в качестве аргумента метода.  Пример: hello -> 10
    */
    private static int doubleStringLength(String str) {
        return str.length() * 2;
    }

    /*
     Second level: Написать 2 метода:  один метод переставляет первую букву в конец строки (abcd-> bcda).
     Второй  метод переставляет последнюю букву в начало строки (abcd->dabc)
     */
    private static String end(String str) {
        if (str.length() <= 1){
            return str;
        }

        return str.substring(1) + str.charAt(0);
    }

    private static String start(String str) {
        if (str.length() <= 1){
            return str;
        }

        return str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
    }

}