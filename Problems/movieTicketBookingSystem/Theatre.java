package Problems.movieTicketBookingSystem;

import java.util.List;

public class Theatre {
    private String id;
    private String name;
    private String location;
    private List<Show> showList;

    public Theatre(String id, String name, String location, List<Show> showList){
        this.id = id;
        this.name = name;
        this.location = location;
        this.showList = showList;
    }
}
