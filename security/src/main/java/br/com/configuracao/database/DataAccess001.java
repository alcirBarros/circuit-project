//package br.com.configuracao.database;
//
//import javax.persistence.EntityManagerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan(basePackages = {"br.com"})
//public class DataAccess001 {
//
//    @Bean
//    public LocalEntityManagerFactoryBean geEntityManagerFactoryBean() {
//        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
//        factoryBean.setPersistenceUnitName("PERSISTENCE-UNIT");
//        return factoryBean;
//    }
//
//    @Bean
//    public JpaTransactionManager geJpaTransactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
//        return transactionManager;
//    }
//}
