package config;/*  gaajiCode
    99
    07/09/2024
    */

import jakarta.persistence.EntityManagerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "repo")
@EnableTransactionManagement
@PropertySource("classpath:hibernates.properties")

public class JPAConfig {

    @Autowired
    Environment env;

    public JPAConfig() {
        System.out.println("JPA");
    }

    @Bean
    public DataSource dataSource() throws NamingException {
        DriverManagerDataSource dmds = new DriverManagerDataSource();
        dmds.setDriverClassName(env.getRequiredProperty("my.app.driverclassname"));
        dmds.setUsername(env.getRequiredProperty("my.app.username"));
        dmds.setUrl(env.getRequiredProperty("my.app.url"));
        dmds.setPassword(env.getRequiredProperty("my.app.password"));
        return dmds;

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(env.getRequiredProperty("entity.pakage.name"));
        factory.setDataSource(dataSource());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
