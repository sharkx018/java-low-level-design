package DesignPattern.composite;

public class Designer implements Employee{
    private String name;
    private Double salary;

    public Designer(String name, Double salary){
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void showDetails() {
        System.out.println("Designer: " + name + ", Salary: " + salary);
    }

    @Override
    public double getSalary() {
        return salary;
    }
}