package DesignPattern.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription());
        System.out.println("Cost: " + coffee.getCost());

        Coffee milkCoffee = new Milk(coffee);
        System.out.println(milkCoffee.getDescription());
        System.out.println("Cost: " + milkCoffee.getCost());

        Coffee bestCoffee = new Sugar(milkCoffee);
        System.out.println(bestCoffee.getDescription());
        System.out.println("Cost: " + bestCoffee.getCost());

    }
}