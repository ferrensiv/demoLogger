package com.belatrix.web;


import com.belatrix.domain.LogLevel;
import com.belatrix.domain.LogOutput;
import com.belatrix.domain.LogScope;
import com.belatrix.strategy.LogScopeFactory;
import com.belatrix.strategy.LogStrategyFactory;
import com.belatrix.strategy.LogStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoggerService {


    private final LogStrategyFactory logStrategyFactory;
    private final LogScopeFactory logScopeFactory;

    @Value("${log.scope}")
    private String logScope;

    @Autowired
    public LoggerService(LogStrategyFactory logStrategyFactory, LogScopeFactory logScopeFactory) {
        this.logStrategyFactory = logStrategyFactory;
        this.logScopeFactory = logScopeFactory;

    }


    public void logMessage(LogOutput logOutput, String message, LogLevel logLevel) {

        List<LogLevel> logLevels = logScopeFactory.getScope(LogScope.valueOf(Integer.valueOf(logScope)));

        if (logLevels.contains(logLevel)) {
            LogStrategy strategy = logStrategyFactory.getStrategy(logOutput);
            strategy.logMessage(message, logLevel);
        }

    }
}
