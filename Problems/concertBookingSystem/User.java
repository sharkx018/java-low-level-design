package Problems.concertBookingSystem;

import java.util.List;

public class User {
    private String username;
    private String email;
    private String phone;
    private List<Booking> bookings;

    User(String username, String email, String phone){
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }
}
