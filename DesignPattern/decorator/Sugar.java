package DesignPattern.decorator;

public class Sugar extends CoffeeDecorator{

    private Coffee baseCoffee;

    public Sugar(Coffee coffee) {
        this.baseCoffee = coffee;
    }

    @Override
    public double getCost() {
        return this.baseCoffee.getCost() + 2;
    }

    @Override
    public String getDescription() {
        return this.baseCoffee.getDescription() + ", with sugar";
    }
}