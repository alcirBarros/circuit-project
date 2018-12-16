package br.com.web;

import br.com.web.configuracao.security.SecurityWebConfig;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
public class SpringBootTomcatApplication extends SpringBootServletInitializer {

    private static final Logger logger = Logger.getLogger(SpringBootTomcatApplication.class);

    @Override
    protected WebApplicationContext run(SpringApplication application) {
        return super.run(application); //To change body of generated methods, choose Tools | Templates.
    }
    
    

//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        logger.info("********************** Application Startup **********************");
//    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        logger.info("********************** Application booted **********************");
        return application.sources(DemoApplication.class, SecurityWebConfig.class);
    }

}
