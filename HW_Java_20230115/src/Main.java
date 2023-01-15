import java.util.*;

public class Main {
    public static void main(String[] args) {
         /*
        Из заданного массива слов заполнить ArrayList( 1000 ) случайными словами.
        Подсчитать сколько каждое слово встречается раз в ArrayList
        Вывести слово, которое повторяется чаще всего.
        Если таких слов несколько - вывести наименьшее из них.

        * make refactor of code to use of lambda function from previous lesson
         */

        String str = """
                Не говори мне о толпе безумной
                Она иной раз вдохновение спугнёт
                Избавь меня от этой давки шумной
                Влекущей мощно в свой водоворот
                Нет тишины ищу я многодумный
                Лишь там поэту радость расцветёт
                Там только там божественною властью
                Любовь и дружба нас приводит к счастью
                """;

        Random random = new Random();

        String[] words = str.split("[\s\n\t\r]+");

        List<String> randomWords = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            randomWords.add(words[random.nextInt(0, words.length)].trim().toLowerCase());
        }

        Map<String, Integer> counts = new TreeMap<>();
        randomWords.forEach(word -> counts.merge(word, 1, Integer::sum));

        int[] maxValue = {0};
        String[] maxValueWord = {""};

        counts.forEach((key, value) -> {
            if (value > maxValue[0]){
                maxValue[0] = value;
                maxValueWord[0] = key;
            }
        });

        System.out.println(maxValueWord[0]);
    }
}
