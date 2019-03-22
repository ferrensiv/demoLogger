package com.belatrix;

import com.belatrix.domain.Log;
import com.belatrix.domain.LogLevel;
import com.belatrix.domain.LogOutput;
import com.belatrix.web.LoggerService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    LoggerService loggerService;


    @Test
    public void logWarningDataBase() {
        jdbcTemplate.execute("DELETE FROM Log");
        loggerService.logMessage(LogOutput.DATABASE, "test DB WARNING", LogLevel.WARNING);
        String query = "SELECT message, type" +
                " from Log";

        Log log=  jdbcTemplate.queryForObject(query, (resultSet, i) -> {
            return new Log(resultSet.getString(1), resultSet.getInt(2));
        });

        Assert.assertTrue(log.getMessage().contains("test DB WARNING"));
        Assert.assertTrue(log.getType().intValue()==LogLevel.WARNING.getValue());
    }

    @Test
    public void logInfoDataBase() {
        jdbcTemplate.execute("DELETE FROM Log");
        loggerService.logMessage(LogOutput.DATABASE, "test DB INFO", LogLevel.INFO);
        String query = "SELECT message, type" +
                " from Log";

        Log log=  jdbcTemplate.queryForObject(query, (resultSet, i) -> {
            return new Log(resultSet.getString(1), resultSet.getInt(2));
        });

        Assert.assertTrue(log.getMessage().contains("test DB INFO"));
        Assert.assertTrue(log.getType().intValue()==LogLevel.INFO.getValue());
    }

    @Test
    public void logErrorDataBase() {
        jdbcTemplate.execute("DELETE FROM Log");
        loggerService.logMessage(LogOutput.DATABASE, "test DB ERROR", LogLevel.ERROR);
        String query = "SELECT message, type" +
                " from Log";

        Log log=  jdbcTemplate.queryForObject(query, (resultSet, i) -> {
            return new Log(resultSet.getString(1), resultSet.getInt(2));
        });

        Assert.assertTrue(log.getMessage().contains("test DB ERROR"));
        Assert.assertTrue(log.getType().intValue()==LogLevel.ERROR.getValue());
    }

}
