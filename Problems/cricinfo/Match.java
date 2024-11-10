package Problems.cricinfo;

import java.time.LocalDateTime;
import java.util.List;

public class Match {
    private String id;
    private String title;
    private String venue;
    private LocalDateTime startDateTime;
    private List<Team> teamList;
    private MatchStatus matchStatus;
    private Scorecard scorecard;


    public Match(String id, String title, String venue, LocalDateTime startDateTime, List<Team> teamList){
        this.id = id;
        this.title = title;
        this.venue = venue;
        this.startDateTime = startDateTime;
        this.teamList = teamList;
        this.matchStatus = MatchStatus.SCHEDULED;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setStatus(MatchStatus matchStatus){
        this.matchStatus = matchStatus;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

}