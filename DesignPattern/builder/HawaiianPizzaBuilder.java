package DesignPattern.builder;

public class HawaiianPizzaBuilder implements PizzaBuilder {

    Pizza pizza;

    public HawaiianPizzaBuilder(){
        this.pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        pizza.setDough("cross");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("sauce");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("ham and pineapple");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}