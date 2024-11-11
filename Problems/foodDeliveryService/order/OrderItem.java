package Problems.foodDeliveryService.order;

import Problems.foodDeliveryService.MenuItem;

public class OrderItem {
    private MenuItem menuItem;
    private int quantity;
    private double price;

    public OrderItem(MenuItem menuItem, int quantity, double price){
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }
}