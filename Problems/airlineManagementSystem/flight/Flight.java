package Problems.airlineManagementSystem.flight;

import Problems.airlineManagementSystem.Seat.Seat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight{
    private final String flightNumber;
    private final String source;
    private final String destination;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    private final List<Seat> availableSeats;

    public Flight(String flightNumber, String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime){
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = new ArrayList<>();
    }

    public String getFlightNumber(){
        return this.flightNumber;
    }

    public String getSource(){
        return this.source;
    }

    public String getDestination(){
        return destination;
    }

    public LocalDateTime getArrivalTime(){
        return arrivalTime;
    }

    public LocalDateTime getDepartureTime(){
        return departureTime;
    }

    public List<Seat> getAvailableSeats(){
        return availableSeats;
    }
}