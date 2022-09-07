public class Main1 {
    public static void main(String[] args) {
        /*
            Second level: С использованием цикла while написать метод,
            печатающий результат  умножения данного числа n  на все целые числа от 0 до n..
            Пример: на входе n=3  на выходе 0,3,6,9
         */

        int n = 3;
        int i = 0;

        while (i <= n) {
            System.out.println(n*i);
            i++;
        }

    }
}
