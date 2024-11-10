package Problems.elevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private int id;
    private int capacity;
    private int currentFloor;
    private Direction currentDirection;
    private List<Request> requests;

    Elevator(int id, int capacity){
        this.id = id;
        this.capacity = capacity;
        this.currentFloor = 1;
        this.currentDirection = Direction.UP;
        this.requests = new ArrayList<>();
    }

    public synchronized void addRequest(Request request){
        if(this.requests.size() < capacity){
            this.requests.add(request);
            System.out.println("Elevator " + id + " added request: " + request);
            notifyAll();
        }
    }


    private synchronized Request getNextRequest(){

        while(requests.isEmpty()){
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return requests.remove(0);
    }

    private synchronized void processRequests(){
        while(true){

            while(!requests.isEmpty()){
                Request request = getNextRequest();
                processRequest(request);
            }

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }


    private void processRequest(Request request){

        int startFloor = currentFloor;
        int endFloor = request.getDestinationFloor();

        if(startFloor < endFloor){
            this.currentDirection = Direction.UP;

            for(int i=startFloor; i<= endFloor; i++){
                this.currentFloor = i;
                System.out.println("Elevator "+ id + " reached " + this.currentFloor);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }else if(startFloor > endFloor){
            this.currentDirection = Direction.DOWN;

            for(int i=startFloor; i>= endFloor; i--){
                this.currentFloor = i;
                System.out.println("Elevator "+ id + " reached " + this.currentFloor);

                try {
                    Thread.sleep(1000);
                }catch (InterruptedException error){
                    System.out.println(error);
                }
            }

        }

    }

    public boolean canTakeRequest() {
        return this.requests.size() < capacity;
    }

    public void run(){
        processRequests();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}