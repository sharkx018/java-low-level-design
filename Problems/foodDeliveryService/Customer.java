package Problems.foodDeliveryService;

import Problems.foodDeliveryService.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private List<Order> orders;

    public Customer(String id, String name, String email, String phone, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.orders = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public void addOrders(Order order){
        this.orders.add(order);
    }
}