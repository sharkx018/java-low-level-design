package Problems.socialNetworkingService;

import java.sql.Time;
import java.sql.Timestamp;

public class Comment {
    private String id;
    private String userId;
    private String postId;
    private String content;
    private Timestamp timestamp;

    public Comment(String id, String userId, String postId, String content, Timestamp timestamp){
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    public String getPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }


}
