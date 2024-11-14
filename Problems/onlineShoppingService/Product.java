package Problems.onlineShoppingService;

public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product(String id, String name, String description, double price, int quantity){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public synchronized void updateQuantity(int quantity){
        this.quantity += quantity;
    }

    public boolean isAvailable(int quantity){
        return this.quantity >= quantity;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

}
