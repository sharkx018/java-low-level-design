package Problems.loggingFramework.logAppend;

import Problems.loggingFramework.LogMessage;

public class FileAppender implements LogAppend{
    @Override
    public void append(LogMessage message) {
        System.out.println("File Appender:" + message);
    }
}
