package com.belatrix.domain;

import java.util.HashMap;
import java.util.Map;

public enum LogScope {
    ERROR(0),
    ERROR_WARNING(1),
    ALL(2);

    private final int value;
    private static Map<Integer, LogScope> map = new HashMap<>();

    static {
        for (LogScope logScope : LogScope.values()) {
            map.put(logScope.value, logScope);
        }
    }


    LogScope(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }

    public static LogScope valueOf(int scope) {
        return map.get(scope);
    }

}