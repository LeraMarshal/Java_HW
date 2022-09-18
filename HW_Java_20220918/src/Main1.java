public class Main1 {
    public static void main(String[] args) {
        /*
          Реализовать метод String replace(String str, String oldStr, String newStr),
          который  в данной строке str меняет все подстроки oldStr на подстроки newStr
          Например:
          ("Hello world!", "world", "all") - "Hello all!"
          ("Hello world!", "l", "L") - "HeLLo worLd!"
          ("Hello world!", "qwe", "L") - "Hello world!"
          ("Hello world!", "ll", "") - "Heo world!"
          Ограничения: в данной задаче нельзя использовать стандартные методы String, кроме length(), charAt() и equals()
         */

        String str = "Hello world!";

        System.out.println(replace(str, "world", "all"));       // Hello all!
        System.out.println(str.replace("world", "all"));    // Hello all!

        System.out.println(replace(str, "l", "L"));             // HeLLo worLd!
        System.out.println(str.replace("l", "L"));          // HeLLo worLd!

        System.out.println(replace(str, "qwe", "L"));           // Hello world!
        System.out.println(str.replace("qwe", "L"));        // Hello world!

        System.out.println(replace(str, "ll", ""));             // Heo world!
        System.out.println(str.replace("ll", ""));          // Heo world!

        System.out.println(replace(str,"", "1"));               // 1H1e1l1l1o1 1w1o1r1l1d1!1
        System.out.println(str.replace("", "1"));           // 1H1e1l1l1o1 1w1o1r1l1d1!1
    }

    private static String replace(String str, String oldStr, String newStr) {
        String res = "";

        int strLen = str.length();
        int oldStrLen = oldStr.length();

        if (oldStrLen == 0) {
            for (int i = 0; i <= strLen; i++) {
                res += newStr;
                if (i < strLen) {
                    res += str.charAt(i);
                }
            }
        } else {
            for (int i = 0; i < strLen; i++) {
                boolean found = true;

                for (int j = 0; j < oldStrLen; j++) {
                    if (i + j >= strLen || str.charAt(i + j) != oldStr.charAt(j)) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    res += newStr;
                    i += oldStrLen - 1;
                } else {
                    res += str.charAt(i);
                }
            }
        }

        return res;
    }
}
