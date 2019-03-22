package com.belatrix.strategy;

import com.belatrix.domain.LogLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class LogStrategyFile implements LogStrategy {

    private Logger logger = Logger.getLogger("LogStrategyConsole");

    @Override
    public void logMessage(String message, LogLevel logLevel) {

        try {
            File logDir = new File("./logs/");
            if (!(logDir.exists())) {
                logDir.mkdir();
            }

            Level level = getLogLevel(logLevel);

            FileHandler fh = new FileHandler("logs/server_log_" + LocalDate.now().toString() + ".log");
            fh.setFormatter(new SimpleFormatter());
            fh.setLevel(level);
            logger.addHandler(fh);
            logger.log(level, message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Level getLogLevel(LogLevel logLevel) {
        switch (logLevel) {
            case ERROR:
                return Level.SEVERE;
            case WARNING:
                return Level.WARNING;
            case INFO:
                return Level.INFO;
            default:
                return null;
        }

    }
}
