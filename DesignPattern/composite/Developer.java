package DesignPattern.composite;

public class Developer implements Employee{

    private String name;
    private Double salary;

    public Developer(String name, Double salary){
        this.name = name;
        this.salary = salary;
    }


    @Override
    public void showDetails() {
        System.out.println("Developer: " + name + ", Salary: " + salary);
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
