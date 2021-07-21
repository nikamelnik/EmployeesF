package EmployeesF;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John Dory", 30);
        Employee tim = new Employee("Tim Buchalka", 54);
        Employee nika = new Employee("Nika Melnik", 29);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Snow Red", 19);
        Employee blue = new Employee("Snow Blue", 48);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(nika);
        employees.add(snow);
        employees.add(red);
        employees.add(blue);

        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "\nEmployees 30 and under", employee -> employee.getAge() <= 30);
        printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() <25;
            }
        });

        IntPredicate intp = i -> i>15;
        System.out.println(intp.test(10));

        int a= 20;
        System.out.println(intp.test(a+6));
    }


    private static void printEmployeesByAge(List<Employee> employees, String ageText,
                                            Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("==================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }

    }
}
