package de.marshal.tasks.employeesort;

public class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private int age;
    private int salary;

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee e) {
        return this.id - e.id;
    }

    public int compareBySalary(Employee e) {
        return this.salary - e.salary;
    }

    public int compareByAge(Employee e) {
        return this.age - e.age;
    }

    public int compareByName(Employee e) {
        return this.name.compareTo(e.name);
    }

    public int compareByAgeAndThenName(Employee e) {
        int ageDiff = compareByAge(e);

        if (ageDiff != 0) {
            return ageDiff;
        }

        return compareByName(e);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
