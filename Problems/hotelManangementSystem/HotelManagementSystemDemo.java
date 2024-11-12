package Problems.hotelManangementSystem;

import Problems.hotelManangementSystem.payment.CreditCardPayment;

import java.time.LocalDateTime;

public class HotelManagementSystemDemo {
    public static void main(String[] args) {

        HotelManagementSystem hotelManagementSystem = HotelManagementSystem.getInstance();

        // add Guest
        Guest guest1 = new Guest("G001", "Ram", "ram@gmail.com", "99999999");
        Guest guest2 = new Guest("G002", "Shyam", "shyam@gmail.com", "8999999");
        hotelManagementSystem.addGuest(guest1);
        hotelManagementSystem.addGuest(guest2);

        // add Room
        Room room1 = new Room("R001", RoomStatus.AVAILABLE, RoomType.SINGLE, 10);
        Room room2 = new Room("R002", RoomStatus.AVAILABLE, RoomType.DOUBLE, 20);
        Room room3 = new Room("R003", RoomStatus.AVAILABLE, RoomType.DELUXE, 40);
        Room room4 = new Room("R004", RoomStatus.AVAILABLE, RoomType.SUITE, 50);
        hotelManagementSystem.addRoom(room1);
        hotelManagementSystem.addRoom(room2);
        hotelManagementSystem.addRoom(room3);
        hotelManagementSystem.addRoom(room4);

        // make booking
        Reservation reservation =  hotelManagementSystem.bookRoom(guest1, room2, LocalDateTime.now(), LocalDateTime.now().plusDays(3));
        if(reservation != null){
            System.out.println("Reservation created: " + reservation.getId());
        }else{
            System.out.println("Room not available for booking");
        }

        // check in
        hotelManagementSystem.checkIn(reservation.getId());
        System.out.println("Checked in: " + reservation.getId());


        // checkout
        hotelManagementSystem.checkOut(reservation.getId(), new CreditCardPayment());
        System.out.println("Checked out: "+ reservation.getId());


        // cancel
        hotelManagementSystem.cancel(reservation.getId());
        System.out.println("Reservation cancelled: "+ reservation.getId());


    }
}
