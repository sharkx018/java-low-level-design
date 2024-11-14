package Problems.restaurantManagementSystem;

public class Staff {
    private String id;
    private String name;
    private String role;
    private String contactNumber;

    public Staff(String id, String name, String role, String contactNumber){
        this.id = id;
        this.name = name;
        this.role = role;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getContactNumber() {
        return contactNumber;
    }

}

