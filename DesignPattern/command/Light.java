package DesignPattern.command;

public class Light {
    private boolean isOn = false;
    private String location;

    public Light(String location){
        this.location = location;
    }

    public void turnOn(){
        this.isOn = true;
        System.out.println(location + " light is now ON");
    }

    public void turnOff(){
        this.isOn = false;
        System.out.println(location + " light is now OFF");
    }

}