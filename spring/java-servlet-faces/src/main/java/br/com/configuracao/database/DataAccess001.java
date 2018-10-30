package br.com.configuracao.database;

//import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.Database;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScans(value = {
    @ComponentScan("br.com")})
public class DataAccess001 {



//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/java-servlet-faces");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        return dataSource;
//    }
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        adapter.setGenerateDdl(false);
//        adapter.setShowSql(false);
//
//        return adapter;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setPersistenceUnitName("PERSISTENCE-UNIT");
//        factory.setDataSource(dataSource);
//        factory.setJpaVendorAdapter(jpaVendorAdapter);
////        factory.setPackagesToScan("br.com");
//        return factory;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
//
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean.getObject());
//        return transactionManager;
//
//    }
//    
//    @Bean
//    public HibernateJpaVendorAdapter transactionManager() {
//        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
//        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
//        hibernateJpaVendorAdapter.setShowSql(true);
//        return hibernateJpaVendorAdapter;
//    }
}
