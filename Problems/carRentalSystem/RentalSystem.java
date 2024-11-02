package Problems.carRentalSystem;

import Problems.carRentalSystem.payment.CreditCardPayment;
import Problems.carRentalSystem.payment.PaymentProcessor;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RentalSystem {
    private static RentalSystem instance;
    private PaymentProcessor processor;
    private final Map<String ,Car> carList;
    private final Map<String, Reservation> reservationList;
    private final PaymentProcessor paymentProcessor;



    private RentalSystem(){
        carList = new ConcurrentHashMap<>();
        reservationList = new ConcurrentHashMap<>();
        paymentProcessor = new CreditCardPayment();
    }

    public static synchronized RentalSystem getInstance(){
        if(instance == null){
            instance = new RentalSystem();
        }
        return instance;
    }

    public void addCars(Car car){
        this.carList.put(car.getLicensePlate(), car);
    }

    public void removeCar(String licensePlate){
        this.carList.remove(licensePlate);
    }

    // search
    public List<Car> searchCars(String make, String model, LocalDate startTime, LocalDate endDate){
        List<Car> availableCars = new ArrayList<>();
        for(Car car: carList.values()){
            if(car.getMake().equalsIgnoreCase(make)  && car.getModel().equalsIgnoreCase(model)){
                if(isCarAvailableInTimeRange(car, startTime, endDate)){
                    availableCars.add(car);
                }
            }

        }

        return availableCars;

    }

    private boolean isCarAvailableInTimeRange(Car car, LocalDate bookingStart, LocalDate bookingEnd){

        for(Reservation reservation: reservationList.values()){
            if(reservation.getCar().equals(car)){
                if( !(bookingEnd.isBefore(reservation.getStartTime()) || bookingStart.isAfter(reservation.getEndTime())) ){
                    return false;
                }
            }
        }

        return true;
    }


    // make reservation
    public synchronized Reservation makeReservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate){
        if(isCarAvailableInTimeRange(car, startDate, endDate)){
            String reservationId = generateReservationId();
            Reservation reservation = new Reservation(reservationId, car, customer, startDate, endDate);
            reservationList.put(reservationId, reservation);
            return reservation;
        }

        return  null;
    }

    // cancel reservation
    public synchronized void cancelReservation(String reservationId){
        this.reservationList.remove(reservationId);
    }

    public boolean processPayment(Reservation reservation){
        return this.paymentProcessor.processPayment(reservation.getTotalPrice());
    }

    private String generateReservationId(){
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

    }




}