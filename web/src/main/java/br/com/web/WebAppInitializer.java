package br.com.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;

public class WebAppInitializer implements WebApplicationInitializer {

    private static final Logger logger = Logger.getLogger(WebAppInitializer.class);

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        logger.info("onStartup called");
    }

}
