public class Main {
    public static void main(String[] args) {
        /*
         Представьте, что вы пишите банковскую программу. Вам нужно реализовать метод, который вместо
         заданной строки с номером счета (например ”DE5128279087265”) возвращает строку вида ”DE51*********65”
         (количество звездочек соответствует количеству засекреченных цифр). Реализуйте 2 варианта метода:
           1) с использованием только циклов, length() и charAt()
           2) используя любые необходимые методы класса String
         */

        System.out.println(mask1("DE5128279087265"));   // DE51*********65
        System.out.println(mask1("DE5165"));            // DE5165
        System.out.println(mask1("DE516"));             // DE516
        System.out.println(mask1("DE51"));              // DE51
        System.out.println(mask1("DE"));                // DE
        System.out.println(mask1(""));                  // empty string

        System.out.println("---");

        System.out.println(mask2("DE5128279087265"));   // DE51*********65
        System.out.println(mask2("DE5165"));            // DE5165
        System.out.println(mask2("DE516"));             // DE516
        System.out.println(mask2("DE51"));              // DE51
        System.out.println(mask2("DE"));                // DE
        System.out.println(mask2(""));                  // empty string
    }

    private static String mask1(String str) {
        String res = "";

        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (i < 4 || i >= len - 2) {
                res += str.charAt(i);
            } else {
                res += '*';
            }
        }

        return res;
    }

    private static String mask2(String str) {
        int len = str.length();

        if (len == 0) {
            return "";
        }

        String res = str.substring(0, Math.min(4, len));
        if (len > 6) {
            res += "*".repeat(len - 6);
            res += str.substring(len - 2);
        } else if (len > 4) {
            res += str.substring(4);
        }

        return res;
    }
}