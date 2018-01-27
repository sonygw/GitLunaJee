package com.formation.context;

import java.util.Properties;



import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value = {"classpath:db.properties"})
@EnableTransactionManagement
@ComponentScan(basePackages = "com.formation")

public class ConteneurSpring {

	@Autowired
	private Environment env;

	/**
	 * Creation d'une datasource 
	 * @return datasoruce
	 */
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
		dataSource.setUrl(env.getRequiredProperty("db.url"));
		dataSource.setUsername(env.getRequiredProperty("db.username"));
		dataSource.setPassword(env.getRequiredProperty("db.password"));
		return dataSource;
	}
	


	/**
	 * Configuration de Hibernate 5 par approche Java
	 * @return factoryBean
	 */
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
				
		
		Properties properties = new Properties();
		properties.put(AvailableSettings.DIALECT, env.getRequiredProperty("hibernate.dialect"));
		properties.put(AvailableSettings.HBM2DDL_AUTO, env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, env.getRequiredProperty("hibernate.current_session_context_class"));
		properties.put(AvailableSettings.SHOW_SQL,env.getRequiredProperty("hibernate.show_sql"));
		properties.put(AvailableSettings.FORMAT_SQL, env.getRequiredProperty("format_sql"));
		properties.put(AvailableSettings.STATEMENT_BATCH_SIZE, env.getRequiredProperty("hibernate.batch.size"));
		
		
		
		factoryBean.setHibernateProperties(properties);
		factoryBean.setPackagesToScan("com.formation");
		return factoryBean;
	}
			
	/**
	 * Configuration de la SessionFactory de Hibernate
	 * @return transactionManager de la sessionFactory
	 */
	@Bean	
		public HibernateTransactionManager getTransactionManager() {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager();
			transactionManager.setSessionFactory(getSessionFactory().getObject());
			return transactionManager;
		}
		
	}

