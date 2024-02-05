package com.example.HomeWork8.configuration;

import com.example.HomeWork8.aspects.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Configuration
@ComponentScan(basePackages = "com.example")
@EnableAspectJAutoProxy
public class ProgectConfiguration {

    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }

    @Bean
    public Logger noteLogger() throws IOException {
        Logger logger = Logger.getLogger(LoggingAspect.class.getName());
//        ConsoleHandler handler = new ConsoleHandler();
        FileHandler handler = new FileHandler("log.txt");
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
        return logger;
    }
}