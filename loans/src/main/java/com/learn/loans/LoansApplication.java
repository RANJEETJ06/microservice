package com.learn.loans;

import com.learn.loans.dto.LoansInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info =@Info(
                title = "Account MicroService",
                description = "Account Microservice using SpringBoot",
                version = "v1",
                contact = @Contact(
                        name = "Ranjeet Jena",
                        url = "https://github.com/RANJEETJ06",
                        email = "ranjeetjena06@gmail.com"
                )
        )

)
@EnableConfigurationProperties(LoansInfoDto.class)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}
}
