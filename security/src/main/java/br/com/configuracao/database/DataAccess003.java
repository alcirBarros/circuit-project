//package br.com.configuracao.database;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan(basePackages = {"br.com"})
//public class DataAccess003 {
//
//    @Bean
//    public DefaultPersistenceUnitManager defaultPersistenceUnitManager() {
//        DefaultPersistenceUnitManager defaultPersistenceUnitManager = new DefaultPersistenceUnitManager();
//        defaultPersistenceUnitManager.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
//        defaultPersistenceUnitManager.setDefaultPersistenceUnitName("PERSISTENCE-UNIT");
//        return defaultPersistenceUnitManager;
//    }
//
//    @Bean(name = "entityManagerFactory1")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory1(DefaultPersistenceUnitManager defaultPersistenceUnitManager) {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setPersistenceUnitName("PERSISTENCE-UNIT-2");
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        return em;
//    }
//
//    @Bean(name = "transactionManager1")
//    public PlatformTransactionManager transactionManager1(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
//        String persistenceUnitName = jpaTransactionManager.getPersistenceUnitName();
//        return jpaTransactionManager;
//    }
//    
//}
