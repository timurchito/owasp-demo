package com.epam.teemo.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class DemoWebSecurityConfiguration extends WebSecurityConfigurerAdapter
{

	@Override
	public void configure(WebSecurity webSecurity)
	{
		webSecurity.ignoring().antMatchers("/**");
	}

}
