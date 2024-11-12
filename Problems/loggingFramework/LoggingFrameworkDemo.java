package Problems.loggingFramework;

import Problems.loggingFramework.logAppend.DatabaseAppender;

public class LoggingFrameworkDemo {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.logDebug("This is the debug message");
        logger.logError("This is the error message");
        logger.logFatal("This is the fatal message");

        System.out.println();

        logger.setLogConfig(new LoggerConfig(LogLevel.DEBUG, new DatabaseAppender()));

        logger.logDebug("This is the debug message");
        logger.logError("This is the error message");
        logger.logFatal("This is the fatal message");

        System.out.println();
    }

}
