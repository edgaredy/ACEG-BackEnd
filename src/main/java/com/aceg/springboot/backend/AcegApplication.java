package com.aceg.springboot.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Esta es la clase principal que inicia la aplicacion de Spring Boot. En ella
 * se puede agregar el escaneo de distintos paquetes para que sean cargados en
 * el contexto de Spring
 * 
 * @author - edgar.rangel
 * @version - 1.0
 * @since - 25/08/2020
 */
@SpringBootApplication
public class AcegApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(AcegApplication.class);

	/**
	 * Metodo main para inicializar la aplicacion Spring Boot
	 * 
	 * @param args Argumentos opcionales de envio al programa
	 */
	public static void main(String[] args) {

		SpringApplication.run(AcegApplication.class, args);

		LOGGER.debug("Debug Message!");
		LOGGER.info("Info Message!");
		LOGGER.warn("Warn Message!");
		LOGGER.error("Error Message!");
	}

	/**
	 * Metodo para permitir que el bean RestTemplate este disponible en el contexto
	 * de Spring
	 * 
	 * @return El bean de RestTemplate disponible en contexto
	 */
	@Bean
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}

}
