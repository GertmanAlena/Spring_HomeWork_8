package com.example.HomeWork8;

import com.example.HomeWork8.configuration.ProgectConfiguration;
import com.example.HomeWork8.service.TasksService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class HomeWork5Application {

	public static void main(String[] args) {
		SpringApplication.run(HomeWork5Application.class, args);
		var c = new AnnotationConfigApplicationContext(ProgectConfiguration.class);
		var service = c.getBean(TasksService.class);
	}

}
