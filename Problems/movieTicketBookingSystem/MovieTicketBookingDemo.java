package Problems.movieTicketBookingSystem;

import Problems.libraryManagementSystem.Book;
import Problems.movieTicketBookingSystem.booking.Booking;
import Problems.movieTicketBookingSystem.seat.Seat;
import Problems.movieTicketBookingSystem.seat.SeatStatus;
import Problems.movieTicketBookingSystem.seat.SeatType;

import java.time.LocalDateTime;
import java.util.*;

public class MovieTicketBookingDemo {

    public static void main(String[] args) {

        MovieTicketBookingSystem movieTicketBookingSystem = MovieTicketBookingSystem.getInstance();

        // add movie
        Movie movie1 = new Movie("M001", "Movie 1", "Desc 1", 120);
        Movie movie2 = new Movie("M001", "Movie 1", "Desc 1", 120);
        movieTicketBookingSystem.addMovies(movie1);
        movieTicketBookingSystem.addMovies(movie2);

        // add theatre
        Theatre t1= new Theatre("T1", "theatre 1", "kanpur", new ArrayList<>());
        Theatre t2= new Theatre("T2", "theatre 2", "agra", new ArrayList<>());
        movieTicketBookingSystem.addTheatre(t1);
        movieTicketBookingSystem.addTheatre(t2);


        // add shows
        Show show1 = new Show("S1", movie1, t1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(120), generateSeats(10, 10));
        Show show2 = new Show("S2", movie2, t2, LocalDateTime.now(), LocalDateTime.now().plusMinutes(120), generateSeats(8, 8));
        movieTicketBookingSystem.addShow(show1);
        movieTicketBookingSystem.addShow(show2);


        //create User
        User user = new User("U1", "mukul", "mukul@gmail.com");

        // create booking
        Seat s1 = show1.getSeatMap().get("1-3");
        Seat s2 = show1.getSeatMap().get("3-4");
        Booking booking = movieTicketBookingSystem.bookTicket(user, show1, Arrays.asList(s1, s2));
        if(booking != null){
            System.out.println("Booking created! , id: " + booking.getId());
            movieTicketBookingSystem.confirmBooking(booking.getId());
        }else{
            System.out.println("Booking failed!");
        }

        // cancel booking
        movieTicketBookingSystem.cancelBooking(booking.getId());
        System.out.println("Booking cancelled: " + booking.getId());

    }

    private static Map<String, Seat> generateSeats(int row, int col){

        Map<String , Seat> seatMap= new HashMap<>();

        for(int i=1; i<= row; i++){
            for(int j=1 ; j<=col; j++){
                String seatId = i + "-" + j;
                SeatType seatType = (i<=2) ? SeatType.PREMIUM : SeatType.NORMAL;
                double price = (seatType == SeatType.PREMIUM) ? 150 : 100;
                Seat seat = new Seat(seatId, i, j,seatType, SeatStatus.AVAILABLE, price);

                seatMap.put(seatId, seat);
            }
        }

        return seatMap;
    }
}
