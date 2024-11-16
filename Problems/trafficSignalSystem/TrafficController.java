package Problems.trafficSignalSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TrafficController {
    private static TrafficController instance;
    private Map<String, Road> roads;

    private TrafficController(){
        this.roads = new ConcurrentHashMap<>();
    }

    public static synchronized TrafficController getInstance() {
        if(instance == null){
            instance = new TrafficController();
        }
        return instance;
    }

    public void addRoad(Road road){
        this.roads.put(road.getId(), road);
    }

    public void startTrafficControl(){
        for(Road road: roads.values()){
            TrafficLight trafficLight = road.getTrafficLight();

            new Thread(()->{
                while (true){

                    try{
                        Thread.sleep(trafficLight.getRedLightDuration());
                        trafficLight.setCurrentSignalType(SignalType.GREEN);

                        Thread.sleep(trafficLight.getGreenLightDuration());
                        trafficLight.setCurrentSignalType(SignalType.YELLOW);

                        Thread.sleep(trafficLight.getYellowLightDuration());
                        trafficLight.setCurrentSignalType(SignalType.RED);

                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }


                }
            }).start();
        }
    }

    public void handleEmergency(String roadId){

        Road road = roads.get(roadId);
        if(road!=null){
            TrafficLight trafficLight = road.getTrafficLight();
            trafficLight.setCurrentSignalType(SignalType.GREEN);
        }

    }



}
