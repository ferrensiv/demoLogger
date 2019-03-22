package com.belatrix;

import com.belatrix.web.LoggerService;
import com.belatrix.strategy.LogStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    LoggerService loggerService;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... arg0) throws Exception {

       //  loggerService.logMessage(LogOutput.DATABASE,"prueba 2!!!!!");

    }
}
