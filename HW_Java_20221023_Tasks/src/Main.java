public class Main {
    public static void main(String[] args) {
        /*
        First level: Создать класс Employee со следующими переменными:
        private int id;
        private String firstName;
        private String lastName;
        private int age;
        private String gender;
        private String position;
        Класс должен содержать конструктор, геттеры, сеттеры ,метод toString
        а также метод  public String getFullName().

        Создать и вывести на экран несколько обьектов этого класса
         */

        Employee e1 = new Employee(1, "f1", "l1", 1, "M", "pos1");
        Employee e2 = new Employee(2, "f2", "l2", 2, "M", "pos2");
        Employee e3 = new Employee(3, "f3", "l3", 3, "M", "pos3");

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3.getFullName());
    }
}
