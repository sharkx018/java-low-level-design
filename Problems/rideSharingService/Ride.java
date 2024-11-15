package Problems.rideSharingService;

public class Ride {

    private String id;
    private Passenger passenger;
    private Driver driver;
    private RideStatus rideStatus;
    private Location source;
    private Location destination;
    private double fare;

    public Ride(String id, Passenger passenger, Driver driver, RideStatus rideStatus, Location source, Location destination, double fare){
        this.id = id;
        this.passenger = passenger;
        this.driver = driver;
        this.rideStatus = rideStatus;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
    }

    public String getId() {
        return id;
    }

    public double getFare() {
        return fare;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getDestination() {
        return destination;
    }

    public Location getSource() {
        return source;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
