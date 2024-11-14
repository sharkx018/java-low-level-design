package Problems.parkingLot;

import Problems.parkingLot.parkingType.Vehicle;
import Problems.parkingLot.parkingType.VehicleType;

import java.util.Vector;

public class ParkingSpot {
    private String spotNumber;
    private VehicleType vehicleType;
    private Vehicle parkedVehicle;


    public ParkingSpot(String spotNumber, VehicleType vehicleType){
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable(){
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        if(isAvailable() && vehicleType == vehicle.getVehicleType()){
            parkedVehicle = vehicle;
        }else{
            throw new IllegalStateException("Invalid Vehicle type or spot already occupied.");
        }
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void unParkVehicle(){
        parkedVehicle = null;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
