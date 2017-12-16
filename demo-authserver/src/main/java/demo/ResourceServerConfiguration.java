/**
 * Project    : mms-oauth2-server
 * Company    : VeriFone
 * ----------------------------------------------------------------------------------------
 * File name  : ResourceServerConfiguration.java
 * @author    : T_IbrahimaK1
 * ---------------------------------------------------------------------------------------- 
 * SVN info   : $Id$
 * ----------------------------------------------------------------------------------------
 * Copyright VeriFone - 2016.
 * No disclosure to a third party without prior written consent of VeriFone
 */
package demo;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;


@EnableResourceServer
@SessionAttributes("authorizationRequest")
@RestController
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter /**/{
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ResourceServerConfiguration.class);
		
	@Override
    public void configure(HttpSecurity http) throws Exception {
         // @formatter:off
		http
			.authorizeRequests()
				.antMatchers("/info", "/health").permitAll()
				.antMatchers("/bower_components/**", "/assets/**", "/fonts/**", "/img/**", "/js/**", "/css/**", "/dist/**", "/i18n/**").permitAll()
				.antMatchers("/oauth/**", "/user").permitAll()
				.anyRequest().authenticated();
         // @formatter:on
    }
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public Principal getLoggedUser(Principal user) {
		return user;
	}
}
