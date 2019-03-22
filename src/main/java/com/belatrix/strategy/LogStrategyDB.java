package com.belatrix.strategy;

import com.belatrix.domain.LogLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LogStrategyDB implements LogStrategy {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void logMessage(String message, LogLevel logLevel) {

        message = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " " + message;

        jdbcTemplate.update("INSERT INTO Log(message, type) VALUES(?,?)", message, logLevel.getValue());
    }
}
