package Problems.hotelManangementSystem;

import Problems.hotelManangementSystem.payment.PaymentProcessor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HotelManagementSystem {
    private static HotelManagementSystem instance;
    private Map<String , Room> roomMap;
    private Map<String, Guest> guestMap;
    private Map<String, Reservation> reservationMap;

    private HotelManagementSystem(){
        roomMap = new ConcurrentHashMap<>();
        guestMap = new ConcurrentHashMap<>();
        reservationMap = new ConcurrentHashMap<>();
    }

    public synchronized static HotelManagementSystem getInstance(){
        if(instance == null){
            instance = new HotelManagementSystem();
        }

        return instance;
    }

    // add Rooms
    public void addRoom(Room room){
        this.roomMap.put(room.getId(), room);
    }

    // add Guest
    public void addGuest(Guest guest){
        this.guestMap.put(guest.getId(), guest);
    }

    // get Rooms
    public Room getRoom(String roomId) {
        return roomMap.get(roomId);
    }

    // book
    public synchronized Reservation bookRoom(Guest guest, Room room, LocalDateTime checkin, LocalDateTime checkout){
        if(room.getStatus() == RoomStatus.AVAILABLE){
            room.book();
            Reservation reservation = new Reservation(generateReservationId(), guest ,room, checkin, checkout);
            this.reservationMap.put(reservation.getId(), reservation);
            return reservation;
        }

        return  null;
    }

    // check in
    public synchronized void checkIn(String reservationId){
        Reservation reservation = reservationMap.get(reservationId);

        if(reservation != null && reservation.getReservationStatus() == ReservationStatus.CONFIRMED){
            reservation.getRoom().checkIn();
        }else{
            throw new IllegalStateException("Reservation invalid or Reservation not confirmed!");
        }

    }


    // check out
    public synchronized void checkOut(String reservationId, PaymentProcessor paymentProcessor){
        Reservation reservation = reservationMap.get(reservationId);
        if(reservation != null && reservation.getReservationStatus() == ReservationStatus.CONFIRMED){
            long days = ChronoUnit.DAYS.between(reservation.getCheckin(), reservation.getCheckout());
            double amount = reservation.getRoom().getPrice() * days;
            if(paymentProcessor.processPayment(amount)){
                Room room = reservation.getRoom();
                room.checkout();
                reservationMap.remove(reservationId);

                System.out.println("Checkout Final Summary:");
                System.out.println("Room Id: " + room.getId());
                System.out.println("Room Type: " + room.getType());
                System.out.println("Room Price: " + room.getPrice());
                System.out.println("Total Days: " + days);
                System.out.println("Total Price: " + amount);
                System.out.println();

            }else{
                throw new IllegalStateException("Payment failed!");
            }

        }else{
            throw new IllegalStateException("Invalid reservation or reservation not confirmed");
        }
    }

    // cancel
    public synchronized void cancel(String reservationId){
        Reservation reservation = reservationMap.get(reservationId);
        if(reservation != null){
            reservation.cancel();
            reservationMap.remove(reservationId);
            System.out.println("Reservation cancelled, ReservationId:" + reservationId);
        }
    }


    // generate reservation id
    private String generateReservationId(){
        return UUID.randomUUID().toString();
    }

}
