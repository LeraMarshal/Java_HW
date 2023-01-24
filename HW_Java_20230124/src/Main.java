import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("E1", "Marketing", "P1", 500L),
                new Employee("E2", "IT", "P2", 1000L),
                new Employee("E3", "Marketing", "P3", 1500L),
                new Employee("E4", "HR", "P1", 2000L),
                new Employee("E5", "HR", "P2", 2500L),
                new Employee("E6", "IT", "P3", 3000L)
        );

        // Group by position
        System.out.println(
                employees.stream().collect(Collectors.groupingBy(Employee::getPosition))
        );
        System.out.println();

        // Average salary
        System.out.println(
                employees.stream()
                        .mapToLong(Employee::getSalary)
                        .average()
                        .orElseThrow()
        );
        System.out.println();

        // Salary greater than 1000
        System.out.println(
                employees.stream()
                        .filter(e -> e.getSalary() > 1000L)
                        .collect(Collectors.toList())
        );
        System.out.println();

        // Increase marketing salaries
        System.out.println(
                employees.stream()
                        .filter(e -> "Marketing".equals(e.getDepartment()))
                        .peek(e -> e.setSalary(Math.round(e.getSalary() * 1.15)))
                        .collect(Collectors.toList())
        );
        System.out.println();

        // Lowest salary employee
        System.out.println(
                employees.stream()
                        .min(Comparator.comparingLong(Employee::getSalary))
                        .orElseThrow()
        );
        System.out.println();

        // Highest salary by department
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment))
                        .values().stream()
                        .map(list -> list.stream().max(Comparator.comparingLong(Employee::getSalary)).orElseThrow())
                        .collect(Collectors.toList())
        );

    }

    private static class Employee {
        private String name;
        private String department;
        private String position;
        private long salary;

        public Employee(String name, String department, String position, long salary) {
            this.name = name;
            this.department = department;
            this.position = position;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public long getSalary() {
            return salary;
        }

        public void setSalary(long salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", position='" + position + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
