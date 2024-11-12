package Problems.loggingFramework;

import Problems.loggingFramework.logAppend.ConsoleAppender;

public class Logger {
    private static final Logger instance = new Logger();
    private LoggerConfig loggerConfig;

    private Logger(){
        this.loggerConfig = new LoggerConfig(LogLevel.INFO, new ConsoleAppender());
    }

    public static Logger getInstance(){
        return instance;
    }

    public void setLogConfig(LoggerConfig loggerConfig) {
        this.loggerConfig = loggerConfig;
    }

    private void log(LogLevel level, String message){
        if(level.ordinal() >= this.loggerConfig.getLogLevel().ordinal()){
            LogMessage logMessage = new LogMessage(level, message);
            loggerConfig.getLogAppend().append(logMessage);
        }

    }


    public void logDebug(String message){
        log(LogLevel.DEBUG, message);
    }

    public void logInfo(String message){
        log(LogLevel.INFO, message);
    }

    public void logWarn(String message){
        log(LogLevel.WARNING, message);
    }


    public void logError(String message){
        log(LogLevel.ERROR, message);
    }

    public void logFatal(String message){
        log(LogLevel.FATAL, message);
    }



}
