//package br.com.configuracao.database;
//
//import javax.persistence.spi.PersistenceUnitInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
//import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
//import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan(basePackages = {"br.com"})
//public class DataAccess004 {
//
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public DriverManagerDataSource dataSource() throws Exception {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/java-servlet-faces");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        return dataSource;
//    }
//
//    @Bean
//    public DefaultPersistenceUnitManager defaultPersistenceUnitManager() {
//        DefaultPersistenceUnitManager defaultPersistenceUnitManager = new DefaultPersistenceUnitManager();
//        defaultPersistenceUnitManager.setDefaultPersistenceUnitName("PERSISTENCE-UNIT");
//        return defaultPersistenceUnitManager;
//    }
//
//    @Bean
//    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        return vendorAdapter;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory1(DefaultPersistenceUnitManager persistenceUnitManager, DriverManagerDataSource driverManagerDataSource, HibernateJpaVendorAdapter hibernateJpaVendorAdapter) {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setPersistenceUnitName("PERSISTENCE-UNIT-2");
//        em.setPersistenceUnitManager(persistenceUnitManager);
//        em.setDataSource(driverManagerDataSource);
//        em.setJpaVendorAdapter(hibernateJpaVendorAdapter);
//        return em;
//    }
//
//    @Bean
//    public JpaTransactionManager geJpaTransactionManager(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean.getObject());
//        return transactionManager;
//    }
//}
