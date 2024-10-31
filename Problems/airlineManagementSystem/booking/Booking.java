package Problems.airlineManagementSystem.booking;

import Problems.airlineManagementSystem.Passenger;
import Problems.airlineManagementSystem.Seat.Seat;
import Problems.airlineManagementSystem.flight.Flight;

public class Booking {
    private final String bookingNumber;
    private final Flight flight;
    private final Passenger passenger;
    private final Seat seat;
    private final double price;
    private BookingStatus bookingStatus;

    Booking(String bookingNumber, Flight flight, Passenger passenger, Seat seat, double price){
        this.bookingNumber = bookingNumber;
        this.flight = flight;
        this.passenger = passenger;
        this.seat = seat;
        this.price = price;
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public String getBookingNumber(){
        return this.bookingNumber;
    }

    public void cancel(){
        this.bookingStatus = BookingStatus.CANCELLED;
    }




}