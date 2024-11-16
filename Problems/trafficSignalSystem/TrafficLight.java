package Problems.trafficSignalSystem;

public class TrafficLight {
    private String id;
    private SignalType currentSignalType;
    private int greenLightDuration;
    private int yellowLightDuration;
    private int redLightDuration;

    TrafficLight(String id, int redLightDuration, int yellowLightDuration, int greenLightDuration){
        this.id = id;
        this.redLightDuration = redLightDuration;
        this.yellowLightDuration = yellowLightDuration;
        this.greenLightDuration = greenLightDuration;
        this.currentSignalType = SignalType.RED;
    }

    public String getId() {
        return id;
    }

    public int getGreenLightDuration() {
        return greenLightDuration;
    }

    public int getRedLightDuration() {
        return redLightDuration;
    }

    public int getYellowLightDuration() {
        return yellowLightDuration;
    }

    public SignalType getCurrentSignalType() {
        return currentSignalType;
    }

    public void setCurrentSignalType(SignalType currentSignalType) {
        this.currentSignalType = currentSignalType;
        // notify
        notifyObservers();
    }

    public void setGreenLightDuration(int greenLightDuration) {
        this.greenLightDuration = greenLightDuration;
    }

    public void setRedLightDuration(int redLightDuration) {
        this.redLightDuration = redLightDuration;
    }

    public void setYellowLightDuration(int yellowLightDuration) {
        this.yellowLightDuration = yellowLightDuration;
    }

    private void notifyObservers(){
        System.out.println("Signal Type Changed: " + this.currentSignalType);
    }


}
