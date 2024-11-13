package Problems.movieTicketBookingSystem.booking;

import Problems.movieTicketBookingSystem.Show;
import Problems.movieTicketBookingSystem.User;
import Problems.movieTicketBookingSystem.seat.Seat;

import java.util.List;

public class Booking {
    private String id;
    private User user;
    private Show show;
    private List<Seat> seats;
    private BookingStatus bookingStatus;
    private double totalPrice;


    public Booking(String id, User user, Show show, List<Seat> seats, double totalPrice, BookingStatus  status) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.totalPrice = totalPrice;
        this.bookingStatus = status;
    }

    public void setStatus(BookingStatus status){
        this.bookingStatus = status;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }


    public List<Seat> getSeats() {
        return seats;
    }

    public Show getShow() {
        return show;
    }


}


