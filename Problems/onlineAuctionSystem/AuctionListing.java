package Problems.onlineAuctionSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AuctionListing {

    private String id;
    private String itemName;
    private String description;
    private double startingPrice;
    private long duration;
    private User seller;
    private AuctionStatus auctionStatus;
    private User currentHighestBidder;
    private double currentHighestBid;
    private List<Bid> bids;

    public AuctionListing(String id, String itemName, String description, double startingPrice, long duration, User seller){
        this.id = id;
        this.itemName = itemName;
        this.description =description;
        this.startingPrice = startingPrice;
        this.duration = duration;
        this.seller = seller;
        this.auctionStatus = AuctionStatus.ACTIVE;
        this.currentHighestBid  = startingPrice;
        this.currentHighestBidder = null;
        this.bids = new CopyOnWriteArrayList<>();
    }

    public void placeBid(Bid bid){
        if(currentHighestBid < bid.getAmount()){
            currentHighestBid = bid.getAmount();
            currentHighestBidder = bid.getBidder();
            bids.add(bid);
            notifyObservers();
        }
    }

    public void closeBid(){
        if(this.auctionStatus == AuctionStatus.ACTIVE){
            this.auctionStatus = AuctionStatus.CLOSED;
            notifyObservers();
            System.out.println("Auction closed: Highest bidding amount" + this.currentHighestBid);
        }
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public AuctionStatus getAuctionStatus() {
        return auctionStatus;
    }

    public double getCurrentHighestBid() {
        return currentHighestBid;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public long getDuration() {
        return duration;
    }

    public String getItemName() {
        return itemName;
    }

    public User getCurrentHighestBidder() {
        return currentHighestBidder;
    }

    public User getSeller() {
        return seller;
    }

    public void notifyObservers(){
        System.out.println("[TODO] Implement the notification:");

    }

}
