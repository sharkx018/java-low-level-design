package Problems.rideSharingService;

public class RideServiceDemo {
    public static void main(String[] args) {
        RideService rideService = RideService.getInstance();

        Passenger passenger1 = new Passenger("P001", "John", "9878675645", new Location(37.8989, -122.34));
        Passenger passenger2 = new Passenger("P002", "James", "2342342334", new Location(37.3249, -144.34));

        rideService.addPassenger(passenger1);
        rideService.addPassenger(passenger2);


        Driver driver1 = new Driver("D001", "Gajodhar Babu", "34242342", "UP-710808", new Location(23.4,-12.44), true);
        Driver driver2 = new Driver("D002", "Munna Lal", "34242342", "UP-8789", new Location(234.4,-42.44), true);
        Driver driver3 = new Driver("D003", "Kullu Soni", "34242342", "UP-8988", new Location(24.4,-14.44), true);

        rideService.addDriver(driver1);
        rideService.addDriver(driver2);
        rideService.addDriver(driver3);

        // request ride
        rideService.requestRide(passenger1, passenger2.getLocation(), new Location(23.45, -13.44));

        // accept ride
        Ride ride1 = rideService.getRequestedRides().poll();
        rideService.acceptRide(driver1, ride1);

        // start the ride
        rideService.startRide(ride1);

        // complete the ride
        rideService.completedRide(ride1);

        // CANCELLATION FLOW

        // passenger2 request ride
        rideService.requestRide(passenger2, passenger2.getLocation(), new Location(34.3, -44.555));

        // driver2 accept the ride
        Ride ride2 =rideService.getRequestedRides().poll();
        rideService.acceptRide(driver2, ride2);

        // passenger2 cancel the ride
        rideService.cancelRide(ride2);

    }
}
