package Problems.concertBookingSystem;

import Problems.concertBookingSystem.payment.PaymentProcessor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ConcertBookingSystem {
    private static ConcertBookingSystem instance;
    private PaymentProcessor paymentProcessor;
    private Map<String, Booking> bookingList;
    private Map<String, Concert> concertList;
    private Object lock = new Object();

    private ConcertBookingSystem(){
        bookingList = new ConcurrentHashMap<>();
        concertList = new ConcurrentHashMap<>();
    }

    public static ConcertBookingSystem getInstance(){
        if(instance == null){
            instance = new ConcertBookingSystem();
        }

        return instance;
    }
    public void addConcert(Concert concert){
        this.concertList.put(concert.getId(), concert);
    }

    // set payment-processor
    public void setPaymentProcessor(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }


    public List<Concert> searchConcerts(String city, String artist, String venue, LocalDateTime dateTime){
        List<Concert> searchedConcerts = new ArrayList<>();

        for(Map.Entry<String, Concert> entry: concertList.entrySet()){
            String concertId = entry.getKey();
            Concert concert = entry.getValue();

            if(
                concert.getCity().getName().equalsIgnoreCase(city) &&
                concert.getArtist().equalsIgnoreCase(artist) &&
                concert.getVenue().equalsIgnoreCase(venue) &&
                concert.getDateTime().isBefore(dateTime)
            ){
                searchedConcerts.add(concert);
            }

        }

        return searchedConcerts;


    }

    public Booking bookConcertTickets(Concert concert, User user, List<Seat> seats, double pricePaid){

        synchronized (lock){
            for(Seat seat: seats){
                if(seat.getSeatStatus() != SeatStatus.AVAILABLE){
                    throw  new SeatNotAvailableException("Seat no. : " +seat.getSeatNumber() + " not available");
                }
            }

            for(Seat seat: seats){
                seat.book();
            }

            String bookingId = generateBookingId();
            Booking booking = new Booking(bookingId, user, concert, seats);
            bookingList.put(bookingId, booking);

            // process Payment
            this.paymentProcessor.processPayment(pricePaid);

            // confirm booking;
            booking.confirmBooking();

            System.out.println("BookingId: "+bookingId + " - " + seats.size() + " seats booked!");
            return booking;
        }


    }

    public void cancelBooking(String bookingId){
        Booking booking = bookingList.get(bookingId);
        if(booking!= null){
            booking.cancelBooking();
            bookingList.remove(bookingId);
        }
    }

    private String generateBookingId(){
        return "BKG_"+ UUID.randomUUID();
    }

}