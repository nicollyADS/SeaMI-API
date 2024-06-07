package br.com.mapped.SeaMI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SeaMiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeaMiApplication.class, args);
	}

}
