package Problems.carRentalSystem;


import Problems.carRentalSystem.payment.PaymentProcessor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private String reservationId;
    private Car car;
    private Customer customer;
    private LocalDate startTime;
    private LocalDate endTime;
    private Double totalPrice;
    private ReservationStatus status;

    public Reservation(String reservationId, Car car, Customer customer, LocalDate startTime, LocalDate endTime){
        this.reservationId = reservationId;
        this.car = car;
        this.customer = customer;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = ReservationStatus.PENDING;
        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTotalPrice(){
        long dateRented = ChronoUnit.DAYS.between(startTime, endTime) + 1;
        return car.getRentalPricePerDay()*dateRented;
    }

    public String getReservationId(){
        return this.reservationId;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public LocalDate getStartTime() {
        return startTime;
    }
}