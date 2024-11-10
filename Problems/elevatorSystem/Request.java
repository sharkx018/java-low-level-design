package Problems.elevatorSystem;

public class Request {
    private int sourceFloor;
    private int destinationFloor;

    Request(int sourceFloor, int destinationFloor){
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }
}