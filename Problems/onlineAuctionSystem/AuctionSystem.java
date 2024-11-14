package Problems.onlineAuctionSystem;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AuctionSystem {

    private static AuctionSystem instance;
    private Map<String, User> userMap;
    private Map<String, AuctionListing> auctionListingMap;



    private AuctionSystem(){
        userMap = new ConcurrentHashMap<>();
        auctionListingMap = new ConcurrentHashMap<>();
    }

    public static synchronized  AuctionSystem getInstance(){
        if (instance == null){
            instance = new AuctionSystem();
        }

        return instance;
    }


    public void registerUser(User user){
        this.userMap.put(user.getId(), user);
    }

    public User getUser(String userId){
        return  this.userMap.get(userId);
    }

    public void addAuctionListing(AuctionListing auctionListing){
        this.auctionListingMap.put(auctionListing.getId(), auctionListing);
        startAuctionTimer(auctionListing);
    }

    public List<AuctionListing> searchAuctionListing(String keyword){
        List<AuctionListing> auctionListings = new ArrayList<>();
        for(AuctionListing auctionListing: auctionListingMap.values()){
            if(auctionListing.getItemName().contains(keyword) || auctionListing.getDescription().contains(keyword)){
                auctionListings.add(auctionListing);
            }
        }

        return auctionListings;
    }

    public void placeBid(String auctionId, Bid bid){
        AuctionListing auctionListing = this.auctionListingMap.get(auctionId);
        if(auctionListing != null){
            auctionListing.placeBid(bid);
        }
    }

    public void startAuctionTimer(AuctionListing auctionListing){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                auctionListing.closeBid();
            }
        }, auctionListing.getDuration());

    }

}
