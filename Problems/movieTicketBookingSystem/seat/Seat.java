package Problems.movieTicketBookingSystem.seat;

public class Seat {
    private String id;
    private int row;
    private int col;
    private SeatStatus status;
    private SeatType type;
    private double price;

    public Seat(String id, int row, int col, SeatType type, SeatStatus status, double price){
        this.id = id;
        this.row = row;
        this.col = col;
        this.type = type;
        this.status = status;
        this.price = price;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public SeatType getType() {
        return type;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
