package Problems.hotelManangementSystem;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Reservation {
    private String id;
    private Guest guest;
    private Room room;
    private ReservationStatus reservationStatus;
    private LocalDateTime checkin;
    private LocalDateTime checkout;

    Reservation(String id, Guest guest, Room room, LocalDateTime checkin, LocalDateTime checkout){
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.reservationStatus = ReservationStatus.CONFIRMED;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public void cancel(){
        if(reservationStatus == ReservationStatus.CONFIRMED){
            this.reservationStatus = ReservationStatus.CANCELLED;
            this.room.checkout();
        }else{
            throw new IllegalStateException("Reservation is not confirmed");
        }

    }

    public String getId() {
        return id;
    }

    public Guest getGuest() {
        return guest;
    }

    public LocalDateTime getCheckin() {
        return checkin;
    }

    public LocalDateTime getCheckout() {
        return checkout;
    }

    public Room getRoom() {
        return room;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }
}
