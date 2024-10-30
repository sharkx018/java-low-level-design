package DesignPattern.decorator;

public class Milk extends CoffeeDecorator{

    private Coffee baseCoffee;

    Milk(Coffee coffee){
        this.baseCoffee = coffee;
    }

    @Override
    public double getCost() {
        return this.baseCoffee.getCost() + 5;
    }

    @Override
    public String getDescription() {
        return this.baseCoffee.getDescription() + ", with milk";
    }
}
