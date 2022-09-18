public class Main {
    public static void main(String[] args) {
        System.out.println(replace("Masha", 'M', 'S'));
    }

    /*
    Написать метод String replace(String str, char oldChar, char newChar),
    который в переданной строке str меняет все символы  oldChar на символы newChar.
    Например: replace(«саша», ‘c’, ‘м’) -> «маша»
     */
    private static String replace(String str, char oldChar, char newChar) {
        String res = "";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
//            if (c == oldChar) {
//                res += newChar;
//            } else {
//                res += c;
//            }
            res+=(c == oldChar) ? newChar : c ;
        }
        return res;
    }
}