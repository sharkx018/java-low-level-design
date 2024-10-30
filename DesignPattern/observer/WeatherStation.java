package DesignPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{

    private List <Observer> observerList;
    private float temperature;

    public WeatherStation(){
        observerList = new ArrayList<>();
    }

    public void setTemperature(float temperature){
        this.temperature = temperature;
        this.notifyObservers();
    }


    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: this.observerList){
            observer.update(this.temperature);
        }
    }
}