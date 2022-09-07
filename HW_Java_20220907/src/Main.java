public class Main {
    public static void main(String[] args) {
        /*
            First level: С использованием цикла while написать метод, печатающий куб числа от 0 до данного чисда n.
            Пример: на входе n=3  на выходе 0,1,8,27
         */

        int n = 3;
        int i = 0;

        while (i <= n) {
            System.out.println(i*i*i);
            i++;
        }

    }
}