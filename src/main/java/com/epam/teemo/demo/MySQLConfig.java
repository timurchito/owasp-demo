package com.epam.teemo.demo;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.epam.teemo.entity")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class MySQLConfig
{
	@Value("${app.datasource.driverClassName}")
	String driverClassName;
	@Value("${app.datasource.url}")
	String url;
	@Value("${app.datasource.username}")
	String username;
	@Value("${app.datasource.password}")
	String password;

	@Bean(name = "dataSource")
	public DataSource getDataSource()
	{
		return DataSourceBuilder.create().username(username).password(password).url(url).driverClassName(
				driverClassName).build();
	}

	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.scanPackages("com.epam.teemo.entity");
		return sessionBuilder.buildSessionFactory();
	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		return new HibernateTransactionManager(sessionFactory);
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource)
	{
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		return initializer;
	}
}