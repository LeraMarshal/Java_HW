package figures;

public class Main {
    /*
    создать классы,
    содержащие методы для подсчета площади и периметра rectangle and circle,
    используя интерфейсы. Создать несколько обьектов этих типов и вывести
    на экран их площадь и периметр
     */

    public static void main(String[] args) {
        Figure[] figures = new Figure[]{
                new Circle(10),
                new Rectangle(10, 10),
        };

        for (Figure figure : figures) {
            System.out.printf("%s area is %.2f\n", figure, figure.getArea());
            System.out.printf("%s perimeter is %.2f\n", figure, figure.getPerimeter());
        }
    }
}
