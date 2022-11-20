package de.marshal.tasks.employeesort;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
    Есть класс Employee  с полями  id, name, age, salary.
    // Сделать его comparable по id
    // сделать дополнительные возможности сортировки по: salary, age, name,
    // ageAndThenName если возраст одинаковый то по имени

    Создать лист таких сотрудников и вывести его на
    экран отсортированный всеми способами
    Collections.sort
     */

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(4, "E4", 23, 2300),
                new Employee(1, "E1", 20, 2000),
                new Employee(3, "E3", 20, 2200),
                new Employee(2, "E2", 21, 2100)
        ));

        // id
        employees.sort(Employee::compareTo);
        System.out.println(employees);

        // salary
        employees.sort(Employee::compareBySalary);
        System.out.println(employees);

        // age
        employees.sort(Employee::compareByAge);
        System.out.println(employees);

        // name
        employees.sort(Employee::compareByName);
        System.out.println(employees);

        // ageAndThenName
        employees.sort(Employee::compareByAgeAndThenName);
        System.out.println(employees);
    }
}
