package com.example.relations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RelationsApplication {

	public static void main(String[] args) {
		try {
			// Tentando encontrar a classe que pertence ao Spring Boot 2.x (a intrusa)
			Class<?> intruder = Class.forName("org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration");
			System.out.println("!!! CULPADO ENCONTRADO !!!");
			System.out.println("O JAR intruso está aqui: " + intruder.getProtectionDomain().getCodeSource().getLocation());
		} catch (ClassNotFoundException e) {
			System.out.println("A classe antiga não foi encontrada via reflexão. O conflito pode estar no cache de recursos da IDE.");
		}
		SpringApplication.run(RelationsApplication.class, args);
	}

}
