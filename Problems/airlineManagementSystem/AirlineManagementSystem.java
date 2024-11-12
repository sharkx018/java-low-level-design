package Problems.airlineManagementSystem;

import Problems.airlineManagementSystem.Seat.Seat;
import Problems.airlineManagementSystem.booking.Booking;
import Problems.airlineManagementSystem.booking.BookingManager;
import Problems.airlineManagementSystem.flight.Flight;
import Problems.airlineManagementSystem.flight.FlightSearch;
import Problems.airlineManagementSystem.payment.Payment;
import Problems.airlineManagementSystem.payment.PaymentProcessor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AirlineManagementSystem {
    private final List<Flight> flights;
    private final List<Aircraft> aircrafts;
    private final BookingManager bookingManager;
    private final FlightSearch flightSearch;
    private final PaymentProcessor paymentProcessor;

    AirlineManagementSystem(){
        flights = new ArrayList<>();
        aircrafts = new ArrayList<>();
        flightSearch = new FlightSearch(flights);
        bookingManager = BookingManager.getInstance();
        paymentProcessor = PaymentProcessor.getInstance();
    }

    public void addFlights(Flight flight){
        this.flights.add(flight);
    }

    public void addAircraft(Aircraft aircraft){
        this.aircrafts.add(aircraft);
    }

    public List<Flight> searchFlights(String source, String destination, LocalDate date){
        return this.flightSearch.searchFlights(source, destination, date);
    }

    public Booking createBooking(Flight flight, Passenger passenger, Seat seat, double price){
        return bookingManager.createBooking(flight, passenger, seat, price);
    }

    public void cancelBooking(String bookingNumber){
        bookingManager.cancelBooking(bookingNumber);
    }

    public void processPayment(Payment payment){
        paymentProcessor.processPayment(payment);
    }





}