package com.applicationapi;

import com.applicationapi.controllers.AuthController;
import com.applicationapi.controllers.BookController;
import com.applicationapi.controllers.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
		, scanBasePackages = {"controller", "services", "repositories", "model"})
@ComponentScan(basePackages = {"com.applicationapi.*", "com.applicationservices.*","com.applicationpersistence.*"}, basePackageClasses = {UserController.class, AuthController.class, BookController.class})
@EntityScan("com.applicationpersistence.*")

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
