package Problems.loggingFramework;

import java.sql.Timestamp;

public class LogMessage {
    private LogLevel level;
    private String message;
    private Timestamp timestamp;

    public LogMessage(LogLevel level, String message){
        this.level = level;
        this.message = message;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}
