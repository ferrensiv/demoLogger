package com.belatrix.strategy;

import com.belatrix.domain.LogOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;


@Component
public class LogStrategyFactory {


    private Map<LogOutput, LogStrategy> strategies = new EnumMap<>(LogOutput.class);

    private final LogStrategyDB logStrategyDB;

    @Autowired
    public LogStrategyFactory(LogStrategyDB logStrategyDB){
        this.logStrategyDB = logStrategyDB;
        initStrategies();
    }


    public LogStrategy getStrategy(LogOutput logOutput) {
        if (logOutput == null || !strategies.containsKey(logOutput)) {
            throw new IllegalArgumentException("Invalid " + logOutput);
        }
        return strategies.get(logOutput);
    }

    private void initStrategies() {
        strategies.put(LogOutput.CONSOLE, new LogStrategyConsole());
        strategies.put(LogOutput.DATABASE, logStrategyDB);
        strategies.put(LogOutput.FILE, new LogStrategyFile());
    }

}
