package Problems.rideSharingService;

public class Driver {
    private String id;
    private String name;
    private String contactNumber;
    private String licensePlate;
    private Location location;
    private boolean isAvailable;

    public Driver(String id, String name, String contactNumber, String licensePlate, Location location, boolean isAvailable){
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.licensePlate = licensePlate;
        this.location = location;
        this.isAvailable = isAvailable;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Location getLocation() {
        return location;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
