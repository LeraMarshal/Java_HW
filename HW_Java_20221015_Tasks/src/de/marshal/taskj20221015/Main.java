package de.marshal.taskj20221015;

public class Main {
    public static void main(String[] args) {
        /*
            Создать класс "Employee", имеющий:
                - конструктор, который принимает переменные salary, number of employee's working hours в качестве параметров

                - следующие методы:
                    addSalary(), который добавляет 10 евро к зврплате сотрудника если она меньше 500
                    addWork(), добавляющий 5 евро к зарплате сотрудника есликоличество часов больше 6.

            Создать несколько сотрудников и применить к ним методы
         */

        Employee e1 = new Employee(300,5);
        Employee e2 = new Employee(600,8);

        e1.addSalary();
        e2.addSalary();
        e1.addWork();
        e2.addWork();

        System.out.println(e1);
        System.out.println(e2);

        /*
            Создать метод, вычисляющий индекс массы тела (BMI) и печатающий результат:

            Метод использует вес в кг и рост в м.
            Он должен выводить соответствеющее сообщение.
            Метод должен быть в классе Body и выводить следующее сообщение:

            "Underweight" если BMI меньше 18.5
            "Normal" если BMI >= 18.5
            "Overweight" если  25<= BMI<30
            "Obese" если BMI >= 30

            формуля для расчета BMI = weight / height^2;

            Вес и рост передаются через конструктор.
         */

        Body body = new Body(55, 1.66);
        body.printBMI();
    }
}
