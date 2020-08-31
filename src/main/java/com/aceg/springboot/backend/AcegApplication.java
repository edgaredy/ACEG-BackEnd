package com.aceg.springboot.backend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AcegApplication {

	private static final Logger LOGGER = LogManager.getLogger(AcegApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(AcegApplication.class, args);
		
        LOGGER.debug("Debug Message!");
        LOGGER.info("Info Message!");
        LOGGER.warn("Warn Message!");
        LOGGER.error("Error Message!");
        LOGGER.fatal("Fatal Message!");
	}

}
