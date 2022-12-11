import java.util.*;

public class Main {
    /*
    1. Write a Java method to count the number of words in a string
    Example: "as soon as possible" should return "as: 2, soon: 1, possible: 1"

    2.Write a Java method to check if two strings are anagrams of each other or not
    */
    public static void main(String[] args) {
        getWordsWithCount(" as soon as possible ");

        System.out.println(checkStringsAnagram("qwerty", "qwerty"));
        System.out.println(checkStringsAnagram("qwerty", "ytrewq"));
        System.out.println(checkStringsAnagram("qwertyZ", "qwertyz"));
    }

    public static void getWordsWithCount(String sentence) {
//        String[] words = splitBySpace(sentence);
        String[] words = sentence.trim().split(" ");
        Map<String, Integer> map = new LinkedHashMap<>();

        for (String word : words) {
            map.compute(word, (key, currentVal) -> (currentVal == null) ? 1 : currentVal + 1);

//            Integer currentVal = map.get(word);
//            if (currentVal == null) {
//                map.put(word, 1);
//            } else {
//                map.put(word, currentVal + 1);
//            }
        }
        System.out.println(map);
    }

    public static boolean checkStringsAnagram(String str1, String str2) {
        if (str1.length() != str2.length()){
            return false;
        }

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (c1 != c2) {
                map.compute(c1, (key, currentVal) -> (currentVal == null) ? 1 : currentVal + 1);
                map.compute(c2, (key, currentVal) -> (currentVal == null) ? -1 : currentVal - 1);
            }
        }

        for (Integer value : map.values()) {
            if (value != 0){
                return false;
            }
        }

        return true;
    }

//    private static String[] splitBySpace(String sentence) {
//        List<String> words = new ArrayList<>();
//
//        StringBuilder currentWord = new StringBuilder();
//        int length = sentence.length();
//
//        for (int i = 0; i < length; i++) {
//            char c = sentence.charAt(i);
//
//            if (c == ' ' && !currentWord.isEmpty()) {
//                words.add(currentWord.toString());
//                currentWord.setLength(0);
//            } else if (c != ' ') {
//                currentWord.append(c);
//            }
//        }
//
//        if (!currentWord.isEmpty()) {
//            words.add(currentWord.toString());
//        }
//
//        return words.toArray(new String[0]);
//    }
}
