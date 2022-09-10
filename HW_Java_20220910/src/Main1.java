public class Main1 {
    public static void main(String[] args) {
        /*
         2) Дана строка и 2 числа int: startIndex, endIndex. Необходимо получить и вывести на экран строку,
         которая состоит из всех символов исходной строки, начиная с позиции startIndex (включительно)
         до позиции endIndex (не включительно). Если startIndex  «не попадает в строку» или больше endIndex выводим “error”.
         Если endIndex не «попадает в строку»,  выводим, начиная со startIndex до конца строки.
         Ограничение: в данной задаче нельзя пользоваться стандартными методам String кроме charAt() и length().

        “Java is a very popular language”,  startIndex=5  endIndex=13  -> “is a ver”
        “Java is a very popular language”,  startIndex=5  endIndex=-13  -> "error"
        “Java is a very popular language”,  startIndex=5  endIndex=136  -> “is a very popular language”
         */

        System.out.println(substring("Java is a very popular language", 5, 13));  // is a ver
        System.out.println(substring("Java is a very popular language", 5, -13)); // error
        System.out.println(substring("Java is a very popular language", 5, 136)); // is a very popular language
        System.out.println(substring("f", 0, 0));                                 // f
        System.out.println(substring("", 0, 0));                                  // error


    }

    public static String substring(String str, int startIndex, int endIndex) {
        int len = str.length();
        if (startIndex < 0 || startIndex >= len || startIndex > endIndex) {
            return "error";
        }
        if (endIndex < 0 || endIndex > len) {
            endIndex = len;
        }

//        String res = "" + str.charAt(startIndex);
//        for (int i = startIndex + 1; i < endIndex; i++) {
//            res += str.charAt(i);
//        }

        String res = "";
        do {
            res += str.charAt(startIndex++);
        } while (startIndex < endIndex);

        return res;
    }
}
