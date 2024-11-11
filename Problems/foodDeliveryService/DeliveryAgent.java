package Problems.foodDeliveryService;

public class DeliveryAgent {

    private String id;
    private String name;
    private String phone;
    private boolean isAvailable;

    public DeliveryAgent(String id, String name, String phone, Boolean isAvailable){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean flag){
        this.isAvailable = flag;
    }
}