package com.belatrix.web;

import com.belatrix.domain.LogLevel;
import com.belatrix.domain.LogOutput;
import com.belatrix.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    LoggerService loggerService;


    @RequestMapping(value = "/person")
    public
    @ResponseBody
    Person getPersonById(@RequestParam Integer id) {

        if (id < 0) {
            loggerService.logMessage(LogOutput.DATABASE, "id less than zero", LogLevel.WARNING);
            return new Person();
        }
        String query = "SELECT first_name, last_name, age" +
                " from person where person.id = " + id;


        return jdbcTemplate.queryForObject(query, (resultSet, i) -> {
            return new Person(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
        });

    }


}
