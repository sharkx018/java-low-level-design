package Problems.hotelManangementSystem;

public class Room {
    private String id;
    private RoomStatus status;
    private RoomType type;
    private double price;



    public Room(String id, RoomStatus status, RoomType roomType, double price){
        this.id = id;
        this.status = status;
        this.type = roomType;
        this.price = price;
    }

    public void book(){
        if(status == RoomStatus.AVAILABLE){
            this.status = RoomStatus.BOOKED;
        }else{
            throw new IllegalStateException("Room is not available for booking");
        }
    }

    public void checkIn(){
        if(status == RoomStatus.BOOKED){
            status = RoomStatus.OCCUPIED;
        }else{
            throw new IllegalStateException("Room is not booked.");
        }
    }

    public void checkout(){
        if(status == RoomStatus.OCCUPIED){
            status = RoomStatus.AVAILABLE;
        }else{
            throw new IllegalStateException("Room is not occupied!");
        }
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public RoomType getType() {
        return type;
    }


}
