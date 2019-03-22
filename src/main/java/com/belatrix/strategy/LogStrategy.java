package com.belatrix.strategy;

import com.belatrix.domain.LogLevel;

public interface LogStrategy {

    void logMessage(String  message, LogLevel logLevel);
}
