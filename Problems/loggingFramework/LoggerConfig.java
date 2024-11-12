package Problems.loggingFramework;

import Problems.loggingFramework.logAppend.LogAppend;

public class LoggerConfig {
    private LogLevel logLevel;
    private LogAppend logAppend;

    LoggerConfig(LogLevel logLevel, LogAppend append){
        this.logLevel = logLevel;
        this.logAppend = append;
    }

    public LogAppend getLogAppend() {
        return logAppend;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogAppend(LogAppend logAppend) {
        this.logAppend = logAppend;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
