package Problems.restaurantManagementSystem;

public class MenuItem {
    private String id;
    private String name;
    private String description;
    private boolean isAvailable;
    private double price;

    MenuItem(String id, String name, String description, boolean isAvailable, double price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getId() {
        return id;
    }
}
