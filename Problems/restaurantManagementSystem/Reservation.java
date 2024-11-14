package Problems.restaurantManagementSystem;

import java.sql.Timestamp;

public class Reservation {
    private String id;
    private String customerName;
    private String customerNumber;
    private int partySize;
    private Timestamp reservationTime;

    public Reservation(String id, String customerName, String customerNumber, int partySize, Timestamp reservationTime){
        this.id = id;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.partySize = partySize;
        this.reservationTime = reservationTime;
    }

}
