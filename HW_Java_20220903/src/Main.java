public class Main {
    public static void main(String[] args) {
        // Дано целое число num. Необходимо написать программу, которая выводит на экран таблицу умножения num  до 10.
        // Например, если num=3 то вывод должен быть таким:
        //           	3*1=3
        //           	3*2=6
        //           	3*3=9
        //           	-----
        //          	3*9=27
        //           	3*10=30

        int num = 3;
        int i = 0;
        while (i++ < 10){
            System.out.printf("%d*%d=%d\n", num, i, num*i);
        }
    }
}