package Problems.loggingFramework.logAppend;

import Problems.loggingFramework.LogMessage;

public class DatabaseAppender implements LogAppend{

    @Override
    public void append(LogMessage message) {
        System.out.println("Database Appender: " + message);
    }
}
