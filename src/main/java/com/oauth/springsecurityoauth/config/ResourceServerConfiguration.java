package com.oauth.springsecurityoauth.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableResourceServer
@RestController
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

	@Override
	 public void configure (HttpSecurity http) throws Exception {
		 http
		 	.authorizeRequests()
		 	.antMatchers ("/private").access("hasRole('USER')")
			.antMatchers ("/admin").access("hasRole('ADMIN')")
		 	.antMatchers("/oauth/token", "/oauth/authorize**", "/publishes").permitAll();  		 
	 }
	
	
	   @GetMapping("/publishes")
	   public String publico () {
	    return "Public Page";
	   }
	   @GetMapping ("/private")
	   public String Private() {
	          return "Private Page";
	   }
	   @GetMapping ("/admin")
	   public String admin () {
	     return "Administrator Page";
	   }
}
