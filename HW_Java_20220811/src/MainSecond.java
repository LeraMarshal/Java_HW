public class MainSecond {
    public static void main(String[] args) {
        /*
        Second level: Создать новый проект и написать программу рассчитывающую,
        на сколько увеличится площадь пиццы, если ее диаметр увеличить на N сантиметров.
        Подсказка: площадь круга можно вычислить по формуле 3,14RR.
        Например: Исходная пицца диаметр 10 см (т.е. R1=10/2=5).
        Диаметр новой пиццы 16 см (т.е. R1=16/2=8). Ответ: 122.46
         */

        double d1 = 10.0;
        double N = 6.0;
        double PI = 3.14;
//        double PI = Math.PI;

        double d2 = d1 + N;
        double r1 = d1 / 2;
        double r2 = d2 / 2;
        double S1 = PI * r1*r1;  //double S1 = Math.PI * Math.pow(r1,2); ----значеник пи * возведение в степень
        double S2 = PI * r2*r2;

        System.out.println(S2 - S1);  // 122.46
    }
}
