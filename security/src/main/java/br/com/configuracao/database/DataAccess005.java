//package br.com.configuracao.database;
//
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan(basePackages = {"br.com"})
//public class DataAccess005 {
//
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/java-servlet-faces");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        return dataSource;
//    }
//
//    @Bean(name = "readingEntityManagerFactory")
//    public EntityManagerFactory readingEntityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setPersistenceUnitName("PERSISTENCE-UNIT");
//        em.setDataSource(dataSource());
//        em.setPackagesToScan("br.com");
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        em.afterPropertiesSet();
//        return em.getObject();
//    }
//
//    @Bean(name = "readingExceptionTranslator")
//    public HibernateExceptionTranslator readingHibernateExceptionTranslator() {
//        return new HibernateExceptionTranslator();
//    }
//
//    @Bean(name = "readingTransactionManager")
//    public JpaTransactionManager readingTransactionManager() {
//        return new JpaTransactionManager();
//    }
//
//}
