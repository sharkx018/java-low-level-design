package Problems.parkingLot;

import Problems.parkingLot.parkingType.Vehicle;
import Problems.parkingLot.parkingType.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int floor;
    private List<ParkingSpot> spots;

    public Level(int floor, int numSpots){
        this.floor = floor;
        this.spots = new ArrayList<>(numSpots);

        double spotForBikes = 0.50;
        double spotForCars = 0.40;

        // assign the ratio
        int numBikes = (int)(numSpots * spotForBikes);
        int numCars = (int)(numSpots * spotForCars);

        for(int i = 1; i <=numBikes; i++){
            spots.add(new ParkingSpot("P-" + i,  VehicleType.Motorcycle));
        }

        for(int i = 1; i <= numCars; i++){
            spots.add(new ParkingSpot("P-" + i,  VehicleType.Car));
        }

        for(int i = numBikes + numCars + 1; i <= numSpots; i++){
            spots.add(new ParkingSpot("P-" + i,  VehicleType.Truck));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot spot: spots){
            if(spot.isAvailable() && spot.getVehicleType() == vehicle.getVehicleType()){
                spot.parkVehicle(vehicle);
                return true;
            }
        }

        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle){
        for(ParkingSpot spot: spots){
            if(spot.isAvailable() == false && spot.getParkedVehicle().equals(vehicle)){
                spot.unParkVehicle();
                return true;
            }
        }
        return false;
    }

    public int getFloor() {
        return floor;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void displayAvailability(){
        System.out.println("Floor " + floor + ", Availability: ");
        for(ParkingSpot spot : spots){
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available for " : " Parked by ") + spot.getVehicleType());
        }
    }
}
