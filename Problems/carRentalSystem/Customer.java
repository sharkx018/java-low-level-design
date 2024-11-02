package Problems.carRentalSystem;

public class Customer {

    private final String username;
    private final String email;
    private final String phone;
    private final String drivingLicense;

    public Customer(String drivingLicense, String username, String phone, String email){
        this.drivingLicense = drivingLicense;
        this.username = username;
        this.phone = phone;
        this.email = email;
    }

}