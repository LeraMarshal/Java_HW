public class Main {
    public static void main(String[] args) {
        /*
            Дана строка, состоящая из нескольких слов, разделенных пробелами,
            необходимо сформировать и вывести на экран строку, содержащую первое и последнее слова исходной строки.
            Примечание: слова разделены одним пробелом, строка не содержит знаков препинания.
            Ограничение: в данной задаче нельзя пользоваться стандартными методам String кроме charAt() и length().
                Например:
                “Java is a very popular language” ->  “Java language”
         */

        String str = "   Java is a very popular language   ";   // Java language
//        String str = "Java is a very popular language";       // Java language
//        String str = "Java";                                  // Java Java
//        String str = "J";                                     // J J
//        String str = "";                                      // Выводит пробел

        String res = "";        // Здесь будет результат
        int len = str.length();
        int l = 0;              // Левый указатель
        int r = len - 1;        // Правый указатель

        // Сдвигаем l вправо до первой буквы
        while (l < len && str.charAt(l) == ' ') {
            l++;
        }

        // Сдвигаем l вправо до первого пробела, добавляя в res
        while (l < len) {
            char c = str.charAt(l);
            if (c == ' ') {
                break;
            }
            res += c;
            l++;
        }

        // Добавляем пробел в res
        res += ' ';

        // Сдвигаем r влево до первой буквы
        while (r >= 0 && str.charAt(r) == ' ') {
            r--;
        }

        // Сдвигаем r влево до пробела
        while (r >= 0 && str.charAt(r) != ' ') {
            r--;
        }

        // r стоит перед началом последнего слова, так что сдвигаем его вправо
        r++;

        // Сдвигаем r вправо до первого пробела, добавляя в res
        while (r < len) {
            char c = str.charAt(r);
            if (c == ' ') {
                break;
            }
            res += c;
            r++;
        }

        System.out.println(res);
//        System.out.printf("[%s]", res);
    }
}