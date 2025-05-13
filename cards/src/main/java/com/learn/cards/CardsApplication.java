package com.learn.cards;

import com.learn.cards.dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.ranjeet.cards.controller") })
@EnableJpaRepositories("com.ranjeet.cards.repository")
@EntityScan("com.ranjeet.cards.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(CardsContactInfoDto.class)
@OpenAPIDefinition(
		info =@Info(
				title = "Card MicroService",
				description = "Card Microservice using SpringBoot",
				version = "v1",
				contact = @Contact(
						name = "Ranjeet Jena",
						url = "https://github.com/RANJEETJ06",
						email = "ranjeetjena06@gmail.com"
				)
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}
}
