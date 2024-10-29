package DesignPattern.composite;

public class CompositeDemo {
    public static void main(String[] args) {

        Developer dev1 = new Developer("mukul",  1500000.0);
        Developer dev2 = new Developer("yunus", 1200000.0);

        Designer designer1 = new Designer("Chandan", 500000.0);
        Designer designer2 = new Designer("Rajesh", 800000.0);

        Manager engManager = new Manager("Haris", 5000000.0);

        engManager.addEmployee(dev1);
        engManager.addEmployee(dev2);
        engManager.addEmployee(designer1);
        engManager.addEmployee(designer2);

        Manager generalManager = new Manager("Aditya", 8000000.0);
        generalManager.addEmployee(engManager);

        System.out.println("Company Structure:");
        generalManager.showDetails();

        System.out.println("Total Salary budget: $" + generalManager.getSalary());


    }
}
