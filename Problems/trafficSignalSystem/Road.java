package Problems.trafficSignalSystem;

public class Road {
    private String id;
    private String name;
    private TrafficLight trafficLight;

    Road(String id, String name, TrafficLight trafficLight){
        this.id = id;
        this.name = name;
        this.trafficLight = trafficLight;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }
}
