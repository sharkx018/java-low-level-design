package Problems.movieTicketBookingSystem;

import Problems.hotelManangementSystem.Reservation;
import Problems.movieTicketBookingSystem.booking.Booking;
import Problems.movieTicketBookingSystem.booking.BookingStatus;
import Problems.movieTicketBookingSystem.seat.Seat;
import Problems.movieTicketBookingSystem.seat.SeatStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MovieTicketBookingSystem {

    private static MovieTicketBookingSystem instance;
    private List<Movie> movies;
    private List<Theatre> theatres;
    private Map<String, Show> showMap;
    private Map<String, Booking> bookingMap;

    private MovieTicketBookingSystem(){
        movies = new ArrayList<>();
        theatres = new ArrayList<>();
        showMap = new ConcurrentHashMap<>();
        bookingMap = new ConcurrentHashMap<>();
    }


    public synchronized static MovieTicketBookingSystem getInstance(){
        if(instance == null){
            instance = new MovieTicketBookingSystem();
        }

        return instance;
    }

    public void addMovies(Movie movie){
        this.movies.add(movie);
    }

    public void addTheatre(Theatre theatre){
        this.theatres.add(theatre);
    }

    public void addShow(Show show){
        this.showMap.put(show.getId(), show);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public Show getShow(String showId) {
        return showMap.get(showId);
    }

    public synchronized Booking bookTicket(User user, Show show, List<Seat> selectedSeats){
        if(areSeatsAvailable(show, selectedSeats)){
            markSeatAsStatus(show, selectedSeats, SeatStatus.BOOKED);
            double totalAmount = calculateTotalPrice(selectedSeats);
            Booking booking = new Booking(generateBookingID(), user, show, selectedSeats, totalAmount, BookingStatus.PENDING);
            bookingMap.put(booking.getId(), booking);
            return booking;
        }

        return  null;

    }

    private boolean areSeatsAvailable(Show show, List<Seat> selectedSeats){
        for(Seat selectedSeat: selectedSeats){
            Seat showSeat = show.getSeatMap().get(selectedSeat.getId());
            if(showSeat == null || showSeat.getStatus() != SeatStatus.AVAILABLE){
                return false;
            }
        }

        return true;

    }

    private void markSeatAsStatus(Show show, List<Seat> selectedSeats, SeatStatus status){
        for(Seat selectedSeat: selectedSeats){
            Seat showSeat = show.getSeatMap().get(selectedSeat.getId());
            showSeat.setStatus(status);
        }
    }


    private double calculateTotalPrice(List<Seat> selectedSeats){
        return selectedSeats.stream().mapToDouble(Seat::getPrice).sum();
    }

    public void confirmBooking(String bookingId){
        Booking booking = this.bookingMap.get(bookingId);
        if(booking!=null && booking.getBookingStatus() == BookingStatus.PENDING){
            booking.setStatus(BookingStatus.CONFIRMED);
        }
    }

    public void cancelBooking(String bookingId){
        Booking booking = this.bookingMap.get(bookingId);
        if(booking != null && booking.getBookingStatus() != BookingStatus.CANCELLED){
            booking.setStatus(BookingStatus.CANCELLED);
            markSeatAsStatus(booking.getShow(), booking.getSeats(), SeatStatus.AVAILABLE);
        }
    }

    private String generateBookingID(){
        return "BKG-" + UUID.randomUUID().toString();
    }


}
