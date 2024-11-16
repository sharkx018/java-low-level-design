package Problems.stackoverflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;

public class Answer implements Commentable, Votable {

    private int id;
    private String content;
    private User author;
    private Question question;
    private List<Comment> comments;
    private List<Vote> votes;
    private boolean isAccepted;
    private Date creationDate;

    public Answer(User author, Question question, String content){
        this.id = generateId();
        this.content = content;
        this.author = author;
        this.question = question;
        comments = new ArrayList<>();
        votes = new ArrayList<>();
        isAccepted = false;
        creationDate = new Date();
    }


    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void vote(User user, int value) {
        if(value != -1 && value != 1){
            throw new IllegalArgumentException("Vote value must be either -1 or 1.");
        }

        votes.removeIf(vote -> vote.getUser().equals(user));
        votes.add(new Vote(user, value));
        author.updateReputation(value*10);

    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }


    private int generateId(){
        return (int)(System.currentTimeMillis()%Integer.MAX_VALUE);
    }

    public void markAsAccepted(){
        if(isAccepted){
            throw new IllegalArgumentException("The answer is already accepted");
        }

        isAccepted = true;
        author.updateReputation(15);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isAccepted() {
        return isAccepted;
    }
}
