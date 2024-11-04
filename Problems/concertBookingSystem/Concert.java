package Problems.concertBookingSystem;

import java.time.LocalDateTime;
import java.util.List;

public class Concert {

    private String id;
    private String artist;
    private String venue;
    private LocalDateTime dateTime;
    private City city;
    private List<Seat> seatList;

    public Concert(String id, String artist, City city, String venue, LocalDateTime dateTime, List<Seat> seats){
        this.id = id;
        this.artist = artist;
        this.venue = venue;
        this.city = city;
        this.dateTime = dateTime;
        this.seatList = seats;
    }

    public String getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getVenue() {
        return venue;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public City getCity() {
        return city;
    }
}