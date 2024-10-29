package DesignPattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee{

    private String name;
    private Double salary;

    private List<Employee> subordinates = new ArrayList<>();

    Manager(String name, Double salary){
        this.name = name;
        this.salary = salary;
    }


    public void addEmployee(Employee employee){
        subordinates.add(employee);
    }

    public void removeEmployee(Employee employee){
        subordinates.remove(employee);

    }


    @Override
    public void showDetails() {
        System.out.println("Manager: " + name + ", Salary: " + salary);
        for(Employee employee: subordinates){
            employee.showDetails();
        }
    }

    @Override
    public double getSalary() {
        double totalSalary = salary;
        for(Employee employee: subordinates){
            totalSalary += employee.getSalary();
        }

        return totalSalary;
    }
}
