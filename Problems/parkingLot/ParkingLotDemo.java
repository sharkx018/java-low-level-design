package Problems.parkingLot;

import Problems.parkingLot.parkingType.Car;
import Problems.parkingLot.parkingType.Motorcycle;
import Problems.parkingLot.parkingType.Truck;
import Problems.parkingLot.parkingType.Vehicle;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        Level l1 = new Level(1, 20);
        Level l2 = new Level(2, 30);

        parkingLot.addLevel(l1);
        parkingLot.addLevel(l2);

        Vehicle car1 = new Car("x-234-sdf");
        Vehicle motorBike = new Motorcycle("f-234-sdf");
        Vehicle truck = new Truck("g-234-sdf");

        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(motorBike);
        parkingLot.parkVehicle(truck);


        parkingLot.displayAvailability();

        parkingLot.unParkVehicle(motorBike);

        parkingLot.displayAvailability();

    }
}
