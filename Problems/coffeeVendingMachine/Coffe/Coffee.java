package Problems.coffeeVendingMachine.Coffe;

import Problems.coffeeVendingMachine.Ingredient;

import java.util.List;
import java.util.Map;

public class Coffee{

    protected String name;
    protected Map<String, Ingredient> recipe;
    protected double price;

    public Coffee(String name, Map<String, Ingredient> recipe, double price){
        this.name = name;
        this.recipe = recipe;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public Map<String, Ingredient> getRecipe(){
        return recipe;
    }

    public double getPrice(){
        return price;
    }
}