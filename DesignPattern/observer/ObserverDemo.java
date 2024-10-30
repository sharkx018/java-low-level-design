package DesignPattern.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        TemperatureDisplay mobileDisplay = new TemperatureDisplay("Mobile Display");
        TemperatureDisplay laptopDisplay = new TemperatureDisplay("Laptop Display");

        weatherStation.attach(mobileDisplay);
        weatherStation.attach(laptopDisplay);

        weatherStation.setTemperature(111);

        weatherStation.setTemperature(232);
        
        weatherStation.detach(mobileDisplay);

        weatherStation.setTemperature(454);
    }

}