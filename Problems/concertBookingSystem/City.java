package Problems.concertBookingSystem;

public class City {
    private String name;
    private String pincode;

    City(String name, String pincode){
        this.name = name;
        this.pincode = pincode;
    }

    public String getName() {
        return name;
    }

    public String getPincode() {
        return pincode;
    }
}