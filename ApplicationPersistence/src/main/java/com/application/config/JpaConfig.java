package com.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.session.jdbc.config.annotation.SpringSessionDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.application.repositories")
@SpringSessionDataSource
public class JpaConfig {

}
