package Problems.stackoverflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;

public class Question implements Votable, Commentable {

    private int id;
    private User author;
    private String title;
    private String content;
    private Date creationDate;
    private List<Vote> votes;
    private List<Tag> tags;
    private List<Answer> answers;
    private List<Comment> comments;

    public Question(User author, String content, String title, List<String> tagNames){
        this.id = generateId();
        this.author = author;
        this.title = title;
        this.content = content;
        this.creationDate = new Date();
        this.tags = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        for(String tagName: tagNames){
            tags.add(new Tag(tagName));
        }

    }

    public void addAnswer(Answer answer){
        if(!answers.contains(answer)){
            this.answers.add(answer);
        }
    }

    @Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
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
        author.updateReputation(value * 5);
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    private int generateId(){
        return (int)(System.currentTimeMillis()%Integer.MAX_VALUE);
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public int getId() {
        return id;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getTitle() {
        return title;
    }

    public List<Tag> getTags() {
        return tags;
    }
}
