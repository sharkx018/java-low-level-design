package Problems.foodDeliveryService;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String id;
    private String name;
    private String address;
    private List<MenuItem> menuItems;

    Restaurant(String id, String name, String address, List<MenuItem> menuItemList){
        this.id = id;
        this.name = name;
        this.address = address;
        this.menuItems = menuItemList;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getAddress() {
        return address;
    }
}
