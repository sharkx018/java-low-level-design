package Problems.onlineShoppingService;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private List<Order> orders;

    public User(String id, String name, String email, String password){
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.orders = new ArrayList<>();
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
