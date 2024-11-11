package Problems.foodDeliveryService;

public class MenuItem {
    private String id;
    private String name;
    private String description;
    private double price;
    private boolean isAvailable;

    public MenuItem(String id, String name, String description, double price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}