package DesignPattern.builder;

public class SpicyPizzaBuilder implements PizzaBuilder{
    Pizza pizza;

    public SpicyPizzaBuilder(){
        this.pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        pizza.setDough("pan backed!");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("hot");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("pepperoni and jalapeno");
    }


    @Override
    public Pizza getPizza() {
        return pizza;
    }
}