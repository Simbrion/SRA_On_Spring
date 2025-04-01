package com.sra.config;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages = "com/sra")
public class Config {

    //UI messages colours
    public static final String YELLOW_COLOUR ="\u001B[33m";
    public static final String GREEN_COLOUR ="\u001B[32m";
    public static final String RESET_COLOUR = "\u001B[0m";
    public static final String RED_COLOUR = "\u001B[31m";

    //UI messages texts
    public static final String WRONG_INPUT_MESSAGE = (RED_COLOUR + "Unacceptable input! Please try again." + RESET_COLOUR);
    public static final String NO_SPACE_WITH_NAME = (RED_COLOUR + "There is no space with such name." + RESET_COLOUR);
    public static final String EXIT_MESSAGE = (GREEN_COLOUR + "You have exited the application. See you next time!" + RESET_COLOUR);
    public static final String NO_EXISTING_SPACES = (YELLOW_COLOUR + "There are no existing spaces." + RESET_COLOUR);
    public static final String NO_EXISTING_RESERVATIONS = (YELLOW_COLOUR + "There are no existing reservations." + RESET_COLOUR);
    public static final String NO_EXISTING_CUSTOMERS = (YELLOW_COLOUR + "There are no existing customers." + RESET_COLOUR);
    public static final String WRONG_INPUT_EXCEPTION = (RED_COLOUR + "SYSTEM: Input Exception caught!" + RESET_COLOUR);
    public static final String EMPTY_INPUT = (RED_COLOUR + "Such input is not allowed. Please use letters and/or digits." + RESET_COLOUR);
    public static final String NO_CUSTOMER_WITH_NAME = (RED_COLOUR + "There is no customer with such name." + RESET_COLOUR);

    //Database connection properties
    String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    String databaseUrl = "jdbc:mysql://localhost:3306/sra_db";
    String user = "root";
    String password = "SimbrionRoot321!";


    @Bean
    public DataSource emfDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("jakarta.persistence.jdbc.driver", jdbcDriver);
        properties.put("jakarta.persistence.jdbc.url", databaseUrl);
        properties.put("jakarta.persistence.jdbc.user", user);
        properties.put("jakarta.persistence.jdbc.password", password);
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        return vendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean(DataSource emfDataSource, @Qualifier("getHibernateProperties") Properties hibernateProperties, JpaVendorAdapter adapter) {
            LocalContainerEntityManagerFactoryBean emfFactoryBean = new LocalContainerEntityManagerFactoryBean();
            emfFactoryBean.setDataSource(emfDataSource);
            emfFactoryBean.setPackagesToScan("com.sra");
            emfFactoryBean.setJpaVendorAdapter(adapter);
            emfFactoryBean.setJpaProperties(hibernateProperties);
            return emfFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

}

