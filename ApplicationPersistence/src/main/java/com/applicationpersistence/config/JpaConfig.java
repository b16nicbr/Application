package com.applicationpersistence.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.session.jdbc.config.annotation.SpringSessionDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.applicationpersistence.repositories.*")
@SpringSessionDataSource
public class JpaConfig {

}
