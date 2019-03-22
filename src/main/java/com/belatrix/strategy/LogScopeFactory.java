package com.belatrix.strategy;

import com.belatrix.domain.LogLevel;
import com.belatrix.domain.LogOutput;
import com.belatrix.domain.LogScope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;


@Component
public class LogScopeFactory {

    private Map<LogScope, List<LogLevel>> scopes = new EnumMap<>(LogScope.class);


    public LogScopeFactory(){
        initLogScopes();
    }


    public List<LogLevel> getScope(LogScope logScope) {
        if (logScope == null || !scopes.containsKey(logScope)) {
            throw new IllegalArgumentException("Invalid scope " + logScope);
        }
        return scopes.get(logScope);
    }

    private void initLogScopes() {
        List<LogLevel> error= new ArrayList<>();
        error.add(LogLevel.ERROR);

        List<LogLevel> errorWarning= new ArrayList<>();
        errorWarning.add(LogLevel.ERROR);
        errorWarning.add(LogLevel.WARNING);

        List<LogLevel> allLevels= new ArrayList<>();
        allLevels.addAll(errorWarning);
        errorWarning.add(LogLevel.INFO);

        scopes.put(LogScope.ERROR, error);
        scopes.put(LogScope.ERROR_WARNING, errorWarning);
        scopes.put(LogScope.ALL, allLevels);
    }

}
