package Problems.socialNetworkingService;

import java.sql.Timestamp;
import java.util.List;

public class Post {
    private String id;
    private String userId;
    private String content;
    private List<String> imageLinks;
    private List<String> videoLinks;
    private List<String> likes;
    private List<Comment> comments;
    private Timestamp timestamp;

    public Post(String id, String userId, String content, List<String> imageLinks, List<String> videoLinks, List<String> likes, List<Comment> comments, Timestamp timestamp){
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.imageLinks = imageLinks;
        this.videoLinks = videoLinks;
        this.likes = likes;
        this.comments = comments;
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public String getId() {
        return id;
    }

    public List<String> getImageLinks() {
        return imageLinks;
    }

    public List<String> getLikes() {
        return likes;
    }

    public List<String> getVideoLinks() {
        return videoLinks;
    }
}
