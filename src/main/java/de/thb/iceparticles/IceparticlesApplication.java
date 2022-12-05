package de.thb.iceparticles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class IceparticlesApplication {

	public static void main(String[] args) {
		SpringApplication.run(IceparticlesApplication.class, args);
	}

}
