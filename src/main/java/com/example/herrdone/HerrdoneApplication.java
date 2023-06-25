package com.example.herrdone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableJpaAuditing
@SpringBootApplication
public class HerrdoneApplication {

	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = null;
		System.out.println(passwordEncoder.encode("123123"));
		SpringApplication.run(HerrdoneApplication.class, args);
	}

}