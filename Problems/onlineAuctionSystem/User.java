package Problems.onlineAuctionSystem;

public class User {
    private String id;
    private String email;
    private String username;

    User(String id, String email, String username) {
        this.id = id;
        this.email = email;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
