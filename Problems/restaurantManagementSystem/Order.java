package Problems.restaurantManagementSystem;

import java.sql.Timestamp;
import java.util.List;

public class Order {
    private String id;
    private List <MenuItem> menuItems;
    private OrderStatus status;
    private double totalPrice;
    Timestamp timestamp;

    Order(String id, List<MenuItem> menuItems, OrderStatus status, double totalPrice, Timestamp timestamp){
        this.id = id;
        this.menuItems = menuItems;
        this.status = status;
        this.totalPrice = totalPrice;
        this.timestamp = timestamp;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
