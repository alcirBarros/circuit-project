package br.com;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebApplicationInitializerSpring implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.scan(WebApplicationInitializerSpring.class.getPackage().getName());
        servletContext.addListener(new ContextLoaderListener(applicationContext));
        servletContext.addListener(new RequestContextListener());
    }
}
