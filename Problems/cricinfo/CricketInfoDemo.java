package Problems.cricinfo;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CricketInfoDemo {
    public static void main(String[] args) {
        CricketInfo cricketInfo = new CricketInfo();

        // create players
        Player p1 = new Player(1, "x-p1", "batsman");
        Player p2 = new Player(2, "x-p2", "bowler");
        Player p3 = new Player(3, "x-p3", "all-rounder");

        // create team
        Team t1 = new Team("T1", "team-1", Arrays.asList(p1, p2, p3));

        Player p4 = new Player(1, "y-p1", "batsman");
        Player p5 = new Player(2, "y-p2", "bowler");
        Player p6 = new Player(3, "y-p3", "all-rounder");

        Team t2 = new Team("T2", "team-1", Arrays.asList(p4, p5, p6));

        // create match
        Match match =  new Match("M001", "Match1", "Venue-1", LocalDateTime.now(), Arrays.asList(t1, t2));


        cricketInfo.addMatch(match);

        Scorecard scorecard = cricketInfo.createScorecard(match);
        System.out.println("Scorecard is now generated: " + scorecard.getId());
        String scorecardId = scorecard.getId();

        cricketInfo.updateScore(scorecardId, t1.getId(), 103);
        cricketInfo.updateScore(scorecardId, t2.getId(), 76);

        cricketInfo.updateMatchStatus(match, MatchStatus.IN_PROGRESS);


        // Create the Innings
        Innings innings1 =  new Innings("I1", t2.getId(), t1.getId());

        // create balls
        Ball b1 = new Ball(1, "x-p1", "p-p1", "The bal was hit by 6");
        Ball b2 = new Ball(1, "x-p1", "p-p1", "Wicket!");

        // create overs
        Over over = new Over(1);
        over.addBalls(b1);
        over.addBalls(b2);

        // complete Innings
        innings1.addOvers(over);

        Innings innings2 =  new Innings("I2", t1.getId(), t2.getId());

        cricketInfo.addInnings(scorecardId, innings1);
        cricketInfo.addInnings(scorecardId, innings2);

        Scorecard updatedScorecard = cricketInfo.getScorecard(scorecardId);

        // Display the scorecard
        System.out.println("Scorecard ID:" + updatedScorecard.getId());
        System.out.println();

        System.out.println("Match: "+ updatedScorecard.getMatch().getTitle());
        System.out.println("Displaying team scores:-");
        for(Map.Entry<String , Integer> teamScoreEntrySet :updatedScorecard.getTeamScore().entrySet()){
            System.out.println("Team: "+teamScoreEntrySet.getKey() + " scored: " + teamScoreEntrySet.getValue());
        }
        System.out.println();


        for(Innings inning: updatedScorecard.getInnings()){
            System.out.println("Inning id: " + inning.getId());
            System.out.println("  Batting Team: " + inning.getBattingTeamId());
            System.out.println("  Bowling Team: " + inning.getBowlingTeamId());

            for(Over over1: inning.getOvers()){
                System.out.println("  Over: "+ over1.getOverNumber());

                for(Ball ball: over1.getBalls()){
                    System.out.println("    Ball Number: " + ball.getBallNumber());
                    System.out.println("      Batsmen: " + ball.getBatsman());
                    System.out.println("      Bowler: " + ball.getBowler());
                    System.out.println("      Result: " + ball.getResult());
                }
            }
        }

        cricketInfo.updateMatchStatus(match, MatchStatus.COMPLETED);

    }
}