package com.satrabench.getfriends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class GetfriendsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetfriendsApplication.class, args);
	}

}
