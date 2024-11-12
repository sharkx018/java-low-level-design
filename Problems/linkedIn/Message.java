package Problems.linkedIn;

import java.sql.Timestamp;

public class Message{
    private String id;
    private String content;
    private User sender;
    private User receiver;
    private Timestamp timestamp;

    Message(String id, String content, User sender, User receiver, Timestamp timestamp){
        this.id = id;
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = timestamp;
    }
}