package Problems.parkingLot;

import Problems.parkingLot.parkingType.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private List<Level> levels;

    private ParkingLot(){
        levels = new ArrayList<>();
    }

    public static ParkingLot getInstance(){
        if(instance == null){
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level){
        this.levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(Level level: levels){
            if(level.parkVehicle(vehicle)){
                System.out.println("Vehicle parked at floor: " + level.getFloor());
                return true;
            }
        }

        System.out.println("Unable to park vehicle, spot not available ");
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle){
        for(Level level: levels){
            if(level.unParkVehicle(vehicle)){
                System.out.println("Vehicle unParked");
                return true;
            }
        }
        System.out.println("Unable to un-park vehicle, something went wrong");
        return false;
    }


    public void displayAvailability(){
        for(Level level: levels){
            level.displayAvailability();
        }
    }


}
