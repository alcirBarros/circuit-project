package br.com;

import com.mysql.jdbc.Driver;
import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"br.com"})
@PropertySource({"classpath:database.properties"})
public class DataAccessConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() throws Exception {
        Driver driver = new com.mysql.jdbc.Driver();        
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriver(driver);
        dataSource.setDriverClassName(driver.getClass().getName());
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource) throws SQLException {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setGenerateDdl(false);
        vendorAdapter.setShowSql(Boolean.TRUE);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPackagesToScan("br.com");
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(dataSource);

        Properties jpaProperties = new Properties();        
        jpaProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        jpaProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        jpaProperties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        jpaProperties.put("hibernate.default_schema", env.getProperty("hibernate.default_schema"));
        jpaProperties.put("hibernate.use_sql_comments", env.getProperty("hibernate.use_sql_comments"));
        jpaProperties.put("hibernate.connection.isolation", env.getProperty("hibernate.connection.isolation"));
        jpaProperties.put("hibernate.connection.autoReconnect", env.getProperty("hibernate.connection.autoReconnect"));
        jpaProperties.put("hibernate.connection.autoReconnectForPools", env.getProperty("hibernate.connection.autoReconnectForPools"));
        jpaProperties.put("org.hibernate.envers.audit_table_suffix", "_aud"); 
        jpaProperties.put("org.hibernate.envers.default_schema", "hibernate_db_aud"); 
        factory.setJpaProperties(jpaProperties);
        return factory;
    }

    @Bean(name = "entityManager")
    public EntityManager entityManager(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
        EntityManagerFactory object = localContainerEntityManagerFactoryBean.getObject();
        return object.createEntityManager();
    }

    @Bean
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
