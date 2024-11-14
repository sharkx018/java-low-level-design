package Problems.onlineAuctionSystem;

import java.util.List;

public class AuctionSystemDemo {
    public static void main(String[] args) {
        AuctionSystem auctionSystem = AuctionSystem.getInstance();

        // create users
        User user1 = new User("U001", "aryan@gmail.com", "mukul");
        User user2 = new User("U002", "arnav@gmail.com", "arnav");
        auctionSystem.registerUser(user1);
        auctionSystem.registerUser(user2);



        // create action-;listing
        AuctionListing auctionListing1 = new AuctionListing("A001", "Item 1", "Description", 100.0, 6000, user1);
        AuctionListing auctionListing2 = new AuctionListing("A002", "Item 2", "Description ", 50.0, 120000, user2);
        auctionSystem.addAuctionListing(auctionListing1);
        auctionSystem.addAuctionListing(auctionListing2);


        // search
        List<AuctionListing> searchedAuctionListings = auctionSystem.searchAuctionListing("Item");
        System.out.println("Searched Auction Listing:");
        for(AuctionListing auctionListing: searchedAuctionListings){
            System.out.println("Auction: " + auctionListing.getItemName());
        }

        // place bid
        Bid bid1 = new Bid("b1", user2, 150);
        Bid bid2 = new Bid("b2", user1, 200);
        auctionSystem.placeBid(auctionListing1.getId(), bid1);
        auctionSystem.placeBid(auctionListing1.getId(), bid2);

    }
}
