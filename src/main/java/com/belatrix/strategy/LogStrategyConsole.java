package com.belatrix.strategy;

import com.belatrix.domain.LogLevel;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class LogStrategyConsole implements LogStrategy {

    private Logger logger = Logger.getLogger("LogStrategyConsole");
    @Override
    public void logMessage(String message, LogLevel logLevel) {

        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);
        switch(logLevel) {
            case ERROR:
                logger.severe(message);
                break;
            case WARNING:
                logger.warning(message);
            case INFO:
                logger.info(message);
                break;
            default:
                // code block
        }


        //logger.severe();

    }
}
