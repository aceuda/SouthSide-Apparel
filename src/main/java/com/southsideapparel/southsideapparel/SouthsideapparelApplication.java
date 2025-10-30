package com.southsideapparel.southsideapparel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.southsideapparel.southsideapparel.model")
@EnableJpaRepositories(basePackages = "com.southsideapparel.southsideapparel.repository")
public class SouthsideapparelApplication {
	public static void main(String[] args) {
		SpringApplication.run(SouthsideapparelApplication.class, args);
	}
}