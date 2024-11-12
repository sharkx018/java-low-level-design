package Problems.linkedIn;

import java.sql.Time;
import java.sql.Timestamp;

public class Notification {
    private String id;
    private User user;
    private NotificationType notificationType;
    private String content;
    private Timestamp timestamp;

    Notification(String id, User user, NotificationType notificationType, String content, Timestamp timestamp){
        this.id = id;
        this.user = user;
        this.notificationType = notificationType;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }


}
