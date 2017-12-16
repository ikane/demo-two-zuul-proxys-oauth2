package com.example.demo;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableOAuth2Sso
public class Oauth2Configuration  extends WebSecurityConfigurerAdapter {
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http
				.cors().and()
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/info", "/health").permitAll()
				.anyRequest().authenticated()
				;
	}	
	
	@Bean
	public CorsFilter corsFilter() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    final CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	   
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}
}
