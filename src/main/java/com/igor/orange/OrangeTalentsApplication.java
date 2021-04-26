package com.igor.orange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EntityScan
public class OrangeTalentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrangeTalentsApplication.class, args);
	}

}
