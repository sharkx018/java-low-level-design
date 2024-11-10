package Problems.elevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

    private List<Elevator> elevators;

    ElevatorController(int numElevator, int capacity){
        elevators = new ArrayList<>();

        for(int i=0; i<numElevator; i++){
            Elevator elevator = new Elevator(i + 1, capacity);
            this.elevators.add(elevator);
            new Thread(elevator::run).start();
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor){
        Elevator elevator = findOptimalElevator(sourceFloor, destinationFloor);
        elevator.addRequest(new Request(sourceFloor, destinationFloor));
    }
    
    private Elevator findOptimalElevator(int sourceFloor, int destinationFloor){
        
        int bestMaxDistance = Integer.MAX_VALUE;
        Elevator optimalElevator = null;
        
        for(Elevator elevator: elevators){

            if(elevator.canTakeRequest() == false){
                continue;
            }

            int maxDis = Math.abs(elevator.getCurrentFloor() - sourceFloor);
            if(maxDis < bestMaxDistance){
                bestMaxDistance = maxDis;
                optimalElevator = elevator;
            }
        }
        
        return optimalElevator;
        
    }

}