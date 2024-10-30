package DesignPattern.decorator;

public class SimpleCoffee extends Coffee {

    @Override
    public double getCost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}