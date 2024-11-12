package Problems.linkedIn;

import java.sql.Timestamp;

public class Connection {
    private User user;
    private Timestamp connectionDate;

    Connection(User user, Timestamp timestamp){
        this.user = user;
        this.connectionDate = timestamp;
    }

    public User getUser() {
        return user;
    }

    public Timestamp getConnectionDate() {
        return connectionDate;
    }
}
