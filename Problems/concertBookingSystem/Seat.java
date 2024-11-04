package Problems.concertBookingSystem;

public class Seat {
    private String seatNumber;
    private SeatType seatType;
    private double price;
    private SeatStatus seatStatus;

    public Seat(String seatNumber, SeatType seatType, double price){
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = SeatStatus.AVAILABLE;
        this.price = price;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void release() {
        seatStatus = SeatStatus.AVAILABLE;
    }

    public void reverse() {
        seatStatus = SeatStatus.RESERVED;
    }

    public synchronized void book() {
        if(seatStatus == SeatStatus.AVAILABLE){
            seatStatus = SeatStatus.BOOKED;
        }else{
            throw new SeatNotAvailableException("Seat is already booked!");
        }
    }

}