package com.controlpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ControlpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlpointApplication.class, args);
	}

}
