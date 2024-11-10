package Problems.elevatorSystem;

public class ElevatorDemo {
    public static void main(String[] args) {

        ElevatorController elevatorController = new ElevatorController(3, 2);

        elevatorController.requestElevator(5, 10);
        elevatorController.requestElevator(3, 7);
        elevatorController.requestElevator(8, 2);
        elevatorController.requestElevator(1, 9);

    }


}