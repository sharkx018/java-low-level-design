package Problems.rideSharingService;

public class Passenger {
    private String id;
    private String name;
    private String contact;
    private Location location;

    public Passenger(String id, String name, String contact, Location location){
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getContact() {
        return contact;
    }


}
