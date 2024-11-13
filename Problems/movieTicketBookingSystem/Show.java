package Problems.movieTicketBookingSystem;

import Problems.movieTicketBookingSystem.seat.Seat;

import java.time.LocalDateTime;
import java.util.Map;

public class Show {
    private String id;
    private Movie movie;
    private Theatre theatre;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Map<String, Seat> seatMap;

    public Show(String id, Movie movie, Theatre theatre, LocalDateTime startDateTime, LocalDateTime endDateTime, Map<String, Seat> seats){
        this.id = id;
        this.movie = movie;
        this.theatre = theatre;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.seatMap = seats;
    }


    public String getId() {
        return id;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public Map<String, Seat> getSeatMap() {
        return seatMap;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

}
