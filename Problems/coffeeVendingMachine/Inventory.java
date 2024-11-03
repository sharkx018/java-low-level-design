package Problems.coffeeVendingMachine;


import Problems.coffeeVendingMachine.Coffe.Coffee;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private Map<String, Ingredient> stock;

    Inventory(){
        stock = new ConcurrentHashMap<>();
    }

    public void addInventory(String name, Ingredient ingredient){
        stock.put(name, ingredient);
    }


    public boolean hasEnoughInventory(Coffee coffee){
        for(Map.Entry<String, Ingredient> entry : coffee.getRecipe().entrySet()){
            String ingredientName = entry.getKey();
            int count = entry.getValue().getQuantity();

            int inventoryCount = this.stock.get(ingredientName).getQuantity();
            if(inventoryCount < count){
                return false;
            }

        }

        return true;
    }

    public void updateInventoryForCoffee(Coffee coffee){

        for(Map.Entry<String, Ingredient> entry : coffee.getRecipe().entrySet()){

            String ingredientName = entry.getKey();
            int requiredCount = entry.getValue().getQuantity();

            int inventoryCount = this.stock.get(ingredientName).getQuantity();

            if(inventoryCount < requiredCount){
                throw new InvalidOperationException("Inventory not sufficient" );
            }

            this.stock.put(ingredientName, new Ingredient(ingredientName,inventoryCount-requiredCount ));
            if(inventoryCount - requiredCount <3){
                System.out.println("WARNING: Inventory count is low for " + inventoryCount);
            }

        }


    }

}