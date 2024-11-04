package Problems.concertBookingSystem;

import Problems.concertBookingSystem.payment.CreditCardPayment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConcertBookingSystemDemo {
    public static void main(String[] args) {

        ConcertBookingSystem concertBookingSystem = ConcertBookingSystem.getInstance();

        concertBookingSystem.setPaymentProcessor(new CreditCardPayment());

        City city1 = new City("Kanpur", "23453");
        City city2 = new City("Agra", "23454");

        List<Seat> seats = generateSeats(100);
        Concert concert1 = new Concert("C001", "AK", city1, "Palace1", LocalDateTime.now().plusDays(30), seats);
        concertBookingSystem.addConcert(concert1);



        List<Seat> seats2 = generateSeats(50);
        Concert concert2 = new Concert("C002", "MK", city2, "Palace2", LocalDateTime.now().plusDays(30), seats2);
        concertBookingSystem.addConcert(concert2);

        User user1 =  new User("mukul", "mukul@gmail.com", "98989898");
        User user2 =  new User("aryan", "aryan@gmail.com", "98989898");

        List<Concert> searchedConcerts = concertBookingSystem.searchConcerts("agra", "mk", "palace2", LocalDateTime.now().plusDays(30));
        System.out.println("Search Results");

        for(Concert concert: searchedConcerts){
            System.out.println("Concert: " + concert.getArtist() + " at venue " + concert.getVenue());
        }

        // select seats and bookSeats for concert
        List<Seat> selectedSeats1 = selectSeats(concert1, 3);
        Booking booking1 = concertBookingSystem.bookConcertTickets(concert1, user1, selectedSeats1, 1000);


        // cancel booking
        concertBookingSystem.cancelBooking(booking1.getId());


        // again select seats and bookSeats for concert
        List<Seat> selectedSeats2 = selectSeats(concert1, 3);
        Booking booking2 = concertBookingSystem.bookConcertTickets(concert1, user2, selectedSeats1, 1000);

    }

     public static List<Seat> generateSeats(int numOfSeats){
            List<Seat> seats = new ArrayList<>();

            for(int i=1; i<= numOfSeats; i++){
                SeatType seatType =  i<=10 ? SeatType.VIP : i<=30 ? SeatType.PREMIUM: SeatType.REGULAR;
                double seatPrice =  seatType == SeatType.VIP ? 500 : seatType == SeatType.PREMIUM ?  300 : 150;
                seats.add(new Seat("S-"+i, seatType, seatPrice));
            }

            return seats;

     }

     public static  List<Seat> selectSeats(Concert concert, int numOfSeats){
        List<Seat> seats = new ArrayList<>();
        List<Seat>availableSeats = concert.getSeatList()
                .stream()
                .filter(seat-> seat.getSeatStatus() == SeatStatus.AVAILABLE)
                .limit(numOfSeats)
                .toList();

        seats.addAll(availableSeats);
        return seats;

     }

}