package se.grouprich.projectmanagement.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories("se.grouprich.projectmanagement.repository")
@EnableTransactionManagement
public class AppConfig
{
	@Bean
	public DataSource dataSource()
	{
		HikariConfig config = new HikariConfig();		
		config.setDriverClassName("com.mysql.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/ProjectManagement_Database");
		config.setUsername("root");
		config.setPassword("root");

		return new HikariDataSource(config);
	}	

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory factory)
	{
		return new JpaTransactionManager(factory);
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter()
	{
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setGenerateDdl(true);
		//adapter.setShowSql(true); // lagt till den här temporart för att kunna se Sql-log

		return adapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(jpaVendorAdapter());
		factory.setPackagesToScan("se.grouprich.projectmanagement.model");

		return factory;
	}
}