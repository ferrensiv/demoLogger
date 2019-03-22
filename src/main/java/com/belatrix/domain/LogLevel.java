package com.belatrix.domain;

public enum LogLevel{
    INFO(0),
    ERROR(1),
    WARNING(2);


    private final int value;

    LogLevel(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}