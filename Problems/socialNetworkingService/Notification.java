package Problems.socialNetworkingService;

import java.sql.Time;
import java.sql.Timestamp;

public class Notification {
    private String id;
    private String userId;
    private NotificationType notificationType;
    private String content;
    private Timestamp timestamp;

    public Notification(String id, String userId, NotificationType notificationType, String content, Timestamp timestamp){
        this.id = id;
        this.userId = userId;
        this.notificationType = notificationType;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }


}
