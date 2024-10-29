package DesignPattern.builder;

public class Waiter {
    PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb){
        this.pizzaBuilder = pb;
    }

    public void constructPizza(){
        this.pizzaBuilder.buildDough();
        this.pizzaBuilder.buildSauce();
        this.pizzaBuilder.buildTopping();
    }

    public Pizza getPizza(){
        return this.pizzaBuilder.getPizza();
    }



}