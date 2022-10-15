package de.marshal.taskj20221015;

public class Employee{
    private int salary;
    private int hours;

    public Employee(int salary, int hours){
        this.salary = salary;
        this.hours = hours;
    }

    public void addSalary(){
        if (salary < 500){
            salary += 10;
        }
    }

    public void addWork(){
        if (hours > 6){
            salary += 5;
        }
    }

    @Override
    public String toString() {
        return String.format("Employee(salary=%d, hours=%d)", salary, hours);
    }
}
