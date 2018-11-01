package com.epam.teemo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = { "com.epam.teemo" })
@EnableAutoConfiguration(exclude = { org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class,
		org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class })
public class DemoApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(DemoApplication.class, args);
	}
}
