package Problems.concertBookingSystem;

import java.util.List;

public class Booking {
    private String id;
    private User user;
    private Concert concert;
    private List <Seat> seats;
    private double totalPrice;
    private BookingStatus bookingStatus;

    public Booking(String id, User user, Concert concert, List<Seat> seats){
        this.id = id;
        this.user = user;
        this.concert = concert;
        this.seats = seats;
        this.totalPrice = calculateTotalPrice(seats);
        this.bookingStatus = BookingStatus.PENDING;
    }

    private double calculateTotalPrice(List<Seat> seats){
        double price = 0;
        for(Seat seat : seats){
            price += seat.getPrice();
        }

        return price;
    }

    public void confirmBooking(){
        this.bookingStatus = BookingStatus.CONFIRMED;
        // send the email to the user;
    }

    public void cancelBooking(){
        if(this.bookingStatus == BookingStatus.CONFIRMED){
            this.bookingStatus = BookingStatus.CANCELLED;
            for(Seat seat: seats){
                seat.release();
            }
            System.out.println("Booking cancelled");
        }
    }

    public String getId() {
        return id;
    }

    public Concert getConcert() {
        return concert;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public User getUser() {
        return user;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

}
