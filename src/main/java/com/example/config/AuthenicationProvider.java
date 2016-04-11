package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
public class AuthenicationProvider {
	@Bean(name="datasource")
	public DriverManagerDataSource datasource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("org.h2.Driver");
		driverManagerDataSource.setUrl("jdbc:h2:mem:AZ;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
		driverManagerDataSource.setUsername("sa");
		driverManagerDataSource.setPassword("");
		return driverManagerDataSource;
	}

	@Bean(name="userDetailsService")
	public UserDetailsService userDetailsService() {
		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
		jdbcImpl.setDataSource(datasource());
		jdbcImpl.setUsersByUsernameQuery("select username,password, enabled from App_User where username=?");
		jdbcImpl.setAuthoritiesByUsernameQuery("select username,role_Name, enabled from App_User where username=?");
		return jdbcImpl;
	}
}