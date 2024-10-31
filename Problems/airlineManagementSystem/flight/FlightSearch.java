package Problems.airlineManagementSystem.flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearch {

    private final List<Flight> flights;

    public FlightSearch(List<Flight> flightList){
        flights = flightList;
    }

    public List<Flight> searchFlights(String source, String destination, LocalDate dateTime){
        return flights.stream().filter(flight -> flight.getSource().equalsIgnoreCase(source) &&
                                       flight.getDestination().equalsIgnoreCase(destination) &&
                                       flight.getDepartureTime().toLocalDate().equals(dateTime))
                .collect(Collectors.toList());
    }


}