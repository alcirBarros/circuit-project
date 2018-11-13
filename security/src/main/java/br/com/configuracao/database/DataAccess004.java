package br.com.configuracao.database;

import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@ComponentScan(basePackages = {"br.com"})

@EnableJpaRepositories(
        entityManagerFactoryRef = "mysqlEntityManagerFactory", // Specifies which @Bean will provide the EntityManager
        transactionManagerRef = "mysqlTransactionManager", // Specifies which @Bean will the provide JpaTransactionManager
        basePackages = "br.com") // Teaches Spring where to seek for repositories for this database
public class DataAccess004 {

    @Autowired
    private Environment env;

    @Autowired
    @Qualifier("dataBase01")
    private DataSource dataSource;

    @PostConstruct
    private void init() {
        System.out.println(dataSource);
    }

    @Bean(name = "dataBase01")
    public DriverManagerDataSource dataBase01() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/educafacil_setebarras");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public DefaultPersistenceUnitManager defaultPersistenceUnitManager(@Qualifier("dataBase01") DataSource dataSource) {
        DefaultPersistenceUnitManager defaultPersistenceUnitManager = new DefaultPersistenceUnitManager();
        defaultPersistenceUnitManager.setDefaultPersistenceUnitName("PERSISTENCE-UNIT");
        defaultPersistenceUnitManager.setDefaultDataSource(dataSource);
        return defaultPersistenceUnitManager;
    }

    @Bean
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        return vendorAdapter;
    }

    @Primary
    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1(DefaultPersistenceUnitManager persistenceUnitManager, @Qualifier("dataBase01") DataSource dataSource, HibernateJpaVendorAdapter hibernateJpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceUnitName("PERSISTENCE-UNIT");
        factory.setPersistenceUnitManager(persistenceUnitManager);
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(hibernateJpaVendorAdapter);

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.format_sql", "true");
        jpaProperties.put("hibernate.default_schema", "educafacil_setebarras");
        factory.setJpaProperties(jpaProperties);
        return factory;
    }

    @Bean
    public JpaTransactionManager geJpaTransactionManager(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean.getObject());
        return transactionManager;
    }

    @Primary
    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(@Qualifier("mysqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
