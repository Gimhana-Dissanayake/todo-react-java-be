package com.example.todoreactjavabe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan("com.example.*")
@SpringBootApplication
@EnableMongoRepositories("com.example.repository")
public class TodoReactJavaBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoReactJavaBeApplication.class, args);
	}

}
