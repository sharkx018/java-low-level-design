package Problems.hotelManangementSystem;

public class Guest {
    private String id;
    private String name;
    private String email;
    private String phone;
    
    public Guest(String id, String name, String email, String phone){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }


}
