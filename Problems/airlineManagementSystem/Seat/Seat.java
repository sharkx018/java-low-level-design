package Problems.airlineManagementSystem.Seat;

public class Seat {
    private String seatNumber;
    private SeatType seatType;
    private SeatStatus seatStatus;

    public Seat(String seatNumber, SeatType seatType){
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }
}