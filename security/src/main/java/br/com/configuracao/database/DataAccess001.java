//package br.com.configuracao.database;
//
//import javax.annotation.PostConstruct;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan(basePackages = {"br.com"})
//public class DataAccess001 {
//
//
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
