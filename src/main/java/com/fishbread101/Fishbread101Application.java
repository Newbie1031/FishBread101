package com.fishbread101;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Fishbread101Application {

	public static void main(String[] args) {
		SpringApplication.run(Fishbread101Application.class, args);
	}

}
