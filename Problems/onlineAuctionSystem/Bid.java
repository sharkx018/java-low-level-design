package Problems.onlineAuctionSystem;

import java.sql.Timestamp;

public class Bid {
    private String id;
    private User bidder;
    private double amount;
    private Timestamp timestamp;

    public Bid(String id, User bidder, double amount){
        this.id = id;
        this.bidder = bidder;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public User getBidder() {
        return bidder;
    }

}
