package Problems.carRentalSystem;

public class Car {
    private final String model;
    private final String make;
    private final String year;
    private final String licensePlate;
    private final double rentalPricePerDay;

    public Car(String make, String model, String year, String licensePlate, double rentalPricePerDay){
        this.model = model;
        this.make = make;
        this.year = year;
        this.licensePlate = licensePlate;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public String getYear() {
        return year;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

}