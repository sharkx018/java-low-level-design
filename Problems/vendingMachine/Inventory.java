package Problems.vendingMachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private Map<Product, Integer> inventory;

    public Inventory(){
        inventory = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product, int quantity){
        this.inventory.put(product, quantity);
    }

    public void removeProduct(Product product){
        this.inventory.remove(product);
    }

    public void updateQuantity(Product product, int quantity){
        this.inventory.put(product, quantity);
    }

    public int getQuantity(Product product){
        return inventory.getOrDefault(product, 0);
    }

    public boolean isAvailable(Product product){
        return inventory.containsKey(product);
    }
}
