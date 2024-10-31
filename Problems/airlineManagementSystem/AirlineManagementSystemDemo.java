package Problems.airlineManagementSystem;

import Problems.airlineManagementSystem.Seat.Seat;
import Problems.airlineManagementSystem.Seat.SeatType;
import Problems.airlineManagementSystem.booking.Booking;
import Problems.airlineManagementSystem.flight.Flight;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AirlineManagementSystemDemo {
    public static void main(String[] args) {

        AirlineManagementSystem airlineManagementSystem = new AirlineManagementSystem();

        Passenger passenger = new Passenger("1", "Mukul", "aryanv018@gmail.com", "8318183455");

        LocalDateTime departureTime1 = LocalDateTime.now().plusDays(1);
        LocalDateTime arrivalTime1 = departureTime1.plusHours(2);
        Flight flight1 = new Flight("F001", "New York", "London", departureTime1, arrivalTime1);


        LocalDateTime departureTime2 = LocalDateTime.now().plusDays(3);
        LocalDateTime arrivalTime2 = departureTime2.plusHours(2);
        Flight flight2 = new Flight("F002", "Paris", "Tokyo", departureTime2, arrivalTime2);

        airlineManagementSystem.addFlights(flight1);
        airlineManagementSystem.addFlights(flight2);

        Aircraft aircraft1 = new Aircraft("A001", "Boeing 747", 300);
        Aircraft aircraft2 = new Aircraft("A002", "Airbus A380", 400);

        airlineManagementSystem.addAircraft(aircraft1);
        airlineManagementSystem.addAircraft(aircraft2);

        // Search Flights
        List<Flight> searchedFlights = airlineManagementSystem.searchFlights("New York", "London", LocalDate.now().plusDays(1));
        System.out.println("Search Results");

        for(Flight flight: searchedFlights){
            System.out.println("Flight: " + flight.getFlightNumber() + " - " +flight.getSource() + " to " + flight.getDestination() );
        }

        Seat seat = new Seat("25A", SeatType.ECONOMY);

        // book the flight
        Booking booking = airlineManagementSystem.createBooking(flight1, passenger, seat, 233);
        if(booking != null){
            System.out.println("Booking Success!. BookingNumber: "+ booking.getBookingNumber());
        }else{
            System.out.println("Booking Failed!");
        }

        airlineManagementSystem.cancelBooking(booking.getBookingNumber());
        System.out.println("Booking Cancelled");





    }

}