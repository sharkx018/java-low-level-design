package Problems.trafficSignalSystem;

public class TrafficControllerDemo {
    public static void main(String[] args) {

        TrafficController trafficController = TrafficController.getInstance();

        TrafficLight t1 = new TrafficLight("t1", 6000, 3000, 9000);
        TrafficLight t2 = new TrafficLight("t2", 6000, 3000, 9000);
        TrafficLight t3 = new TrafficLight("t3", 6000, 3000, 9000);
        TrafficLight t4 = new TrafficLight("t4", 6000, 3000, 9000);

        Road r1 = new Road("r1", "Main Gate", t1);
        Road r2 = new Road("r2", "Broadway", t2);
        Road r3 = new Road("r3", "City Center", t3);
        Road r4 = new Road("r4", "Golf Course", t4);

        trafficController.addRoad(r1);
        trafficController.addRoad(r2);
        trafficController.addRoad(r3);
        trafficController.addRoad(r4);

        trafficController.startTrafficControl();

        trafficController.handleEmergency("r2");
    }
}
