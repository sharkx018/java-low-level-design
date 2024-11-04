package Problems.coffeeVendingMachine;


import Problems.coffeeVendingMachine.Coffe.Coffee;
import Problems.coffeeVendingMachine.payment.PaymentProcessor;
import Problems.coffeeVendingMachine.payment.UpiPayment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {
    private static CoffeeMachine instance;
    private List<Coffee> coffeeMenu;
    private Inventory inventory;
    private PaymentProcessor paymentProcessor;

    private CoffeeMachine(){
        initIngredient();
        initCoffeeList();
        initPaymentProcessor();
    }

    public static CoffeeMachine getInstance(){
        if(instance == null){
            instance = new CoffeeMachine();
        }

        return instance;
    }

    private void initPaymentProcessor(){
        this.paymentProcessor = new UpiPayment();
    }


    private void initIngredient(){

        inventory = new Inventory();
        inventory.addInventory("water", new Ingredient("water", 2));
        inventory.addInventory("milk", new Ingredient("milk", 10));
        inventory.addInventory("coffee", new Ingredient("coffee", 10));
        inventory.addInventory("sugar", new Ingredient("sugar", 10));
        inventory.addInventory("cream", new Ingredient("cream", 10));

    }

    private void initCoffeeList(){
        coffeeMenu = new ArrayList<>();

        Map<String, Ingredient> latteRecipe = new HashMap<>();
        latteRecipe.put("water", new Ingredient("water", 1));
        latteRecipe.put("coffee", new Ingredient("coffee", 1));
        latteRecipe.put("sugar", new Ingredient("sugar", 1));
        coffeeMenu.add(new Coffee("Latte", latteRecipe, 3));


        Map<String, Ingredient> cappuccinoRecipe = new HashMap<>();
        cappuccinoRecipe.put("water", new Ingredient("water", 2));;
        cappuccinoRecipe.put("coffee", new Ingredient("coffee", 2));;
        cappuccinoRecipe.put("sugar", new Ingredient("sugar", 2));;
        coffeeMenu.add(new Coffee("Cappuccino", latteRecipe, 5));


        Map<String, Ingredient> espressoRecipe = new HashMap<>();
        espressoRecipe.put("sugar", new Ingredient("water", 2));;
        espressoRecipe.put("coffee", new Ingredient("coffee", 2));;
        espressoRecipe.put("sugar", new Ingredient("sugar", 1));;
        coffeeMenu.add(new Coffee("Espresso", latteRecipe, 2));
    }




    public void showCoffeeList(){
        System.out.println("Coffee Menu:");
        for(Coffee coffee: coffeeMenu){
            System.out.println(coffee.getName() + " - $" + coffee.getPrice());
        }
    }


    private Coffee getCoffee(String coffeeName){
        for(Coffee coffee: coffeeMenu){
            if(coffee.getName().equalsIgnoreCase(coffeeName)){
                return coffee;
            }
        }

        return null;
    }

    public void dispenseCoffee(String coffeeName, double price){



        Coffee coffee = getCoffee(coffeeName);

        System.out.println("Preparing you coffee: "+ coffeeName + ", price: " + coffee.getPrice());

        if(coffee == null){
            throw new InvalidOperationException("Coffee not found, please try again!");
        }

        if(price < coffee.getPrice()){
            throw new InvalidOperationException("Not Enough Balance, please try again!");
        }

        if(inventory.hasEnoughInventory(coffee)){

            if(paymentProcessor.processPayment(price)){

                System.out.println("Payment done");

                this.inventory.updateInventoryForCoffee(coffee);

                System.out.println("Please collect your coffee: " + coffeeName);
            }else{
                throw new InvalidOperationException("Payment Failed, please try again later!");
            }


        }else{
            throw new InvalidOperationException("Not Enough Inventory, please try again later!");
        }


    }


}