package Problems.loggingFramework.logAppend;

import Problems.loggingFramework.LogMessage;

public class ConsoleAppender implements LogAppend{
    @Override
    public void append(LogMessage message) {
        System.out.println("Console Appender: " + message);
    }
}
