package Problems.rideSharingService;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RideService {
    private static RideService instance;
    private Map<String, Passenger> passengers;
    private Map<String, Driver> drivers;
    private Map<String, Ride> rides;
    private Queue <Ride> requestedRides;

    private RideService(){
        passengers = new ConcurrentHashMap<>();
        drivers = new ConcurrentHashMap<>();
        rides = new ConcurrentHashMap<>();
        requestedRides = new ConcurrentLinkedQueue<>();
    }

    public synchronized static RideService getInstance(){
        if(instance == null){
            instance = new RideService();
        }
        return instance;
    }

    public void addPassenger(Passenger passenger){
        this.passengers.put(passenger.getId(), passenger);
    }

    public void addDriver(Driver d){
        this.drivers.put(d.getId(), d);
    }

    // request ride and notify all drivers
    public void requestRide(Passenger passenger, Location source, Location destination){
        Ride ride = new Ride(generateRideId(), passenger, null, RideStatus.REQUESTED, source, destination, 0.0);
        this.requestedRides.offer(ride);
        notifyDrivers(ride);
    }

    // accept the ride by driver
    public void acceptRide(Driver driver, Ride ride){
        if(ride.getRideStatus() == RideStatus.REQUESTED){
            if(driver.isAvailable() == true){
                driver.setAvailable(false);
                ride.setRideStatus(RideStatus.ACCEPTED);
                ride.setDriver(driver);
                notifyPassenger(ride);
            }
        }
    }


    // start the ride by driver
    public void startRide(Ride ride){
        if(ride.getRideStatus() == RideStatus.ACCEPTED){
            ride.setRideStatus(RideStatus.IN_PROGRESS);
            notifyPassenger(ride);
        }
    }


    // complete the ride
    public void completedRide(Ride ride){
        if(ride.getRideStatus() == RideStatus.IN_PROGRESS){

            ride.setRideStatus(RideStatus.COMPLETED);
            ride.getDriver().setAvailable(true);

            double fare = calculateFare(ride);
            ride.setFare(fare);
            processPayment(ride, fare);

            notifyPassenger(ride);
            notifyDriver(ride);
        }
    }


    // cancel the ride
    public void cancelRide(Ride ride){
        if(ride.getRideStatus() == RideStatus.REQUESTED || ride.getRideStatus() == RideStatus.ACCEPTED){
            ride.setRideStatus(RideStatus.CANCELLED);
            notifyDriver(ride);
            notifyPassenger(ride);

        }
    }

    // notify all drivers
    private void notifyDrivers(Ride ride){
        for(Driver driver : drivers.values()){
            if(driver.isAvailable()){
                if(calculateDistance(driver.getLocation(), ride.getSource()) <= 5){
                    System.out.println("Notifying driver: "+ driver.getName()+  " about the ride: "+ ride.getId());
                }
            }

        }
    }

    // notify the driver
    public void notifyDriver(Ride ride){
        switch (ride.getRideStatus()){
            case COMPLETED :
                System.out.println("Ride completed, Fare: $ " + ride.getFare());

                break;
            case CANCELLED:
                System.out.println("Ride got cancelled by passenger");

                break;
        }
    }

    // notify the passenger
    public void notifyPassenger(Ride ride){
        Passenger passenger = ride.getPassenger();
        String message = "";
        switch (ride.getRideStatus()){
            case ACCEPTED :
                message = "Your ride has been accepted by driver: "+ ride.getDriver().getName();
                break;
            case IN_PROGRESS:
                message = "Your ride has been started";
                break;
            case COMPLETED:
                message =  "Your ride has been completed. Fare: $ " +  ride.getFare();
                break;
            case CANCELLED:
                message = "Your ride has been cancelled";
                break;
        }
        System.out.println("Notifying Passenger :" + passenger.getName() + ", message: - "+message );
    }

    // generate ride id
    public String generateRideId(){
        return UUID.randomUUID().toString();
    }

    // get all rides

    public Map<String, Ride> getRides() {
        return rides;
    }

    // get all requested rides


    public Queue<Ride> getRequestedRides() {
        return requestedRides;
    }

    // calculate the distance from Location source to Location destination
    private double calculateDistance(Location source, Location destination){
        return Math.random() * 20 +1;
    }

    // calculateFare
    public double calculateFare(Ride ride){
        double baseFare = 2;
        double chargePerKm = 1.5;
        double chargePerMin = 0.25;

        double distance = calculateDistance(ride.getSource(), ride.getDestination());
        double duration = calculateDistance(ride.getSource(), ride.getDestination());

        double fare =  baseFare + distance * chargePerKm + duration * chargePerMin;
        return Math.round(fare*100.0)/100.0;
    }

    private void processPayment(Ride ride, double fare){

    }

    // calculate duration
    private double calculateDuration(Location source, Location destination){
        double distance = calculateDistance(source, destination);

        // average speed of 30km/hr
        return (distance / 30) * 60; // calculate in minutes;
    }


}
