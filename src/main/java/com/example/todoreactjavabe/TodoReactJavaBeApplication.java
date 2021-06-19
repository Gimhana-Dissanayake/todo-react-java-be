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

		// BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		// for (int i = 1; i <= 10; i++) {
		// 	String encodedString = encoder.encode("zoom50");
		// 	System.out.println(encodedString);
		// }

		SpringApplication.run(TodoReactJavaBeApplication.class, args);
	}

}
