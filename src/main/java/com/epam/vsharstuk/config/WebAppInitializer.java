package com.epam.vsharstuk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

@Configuration
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        ConfigurableWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("WEB-INF/spring-web-servlet.xml");
        ServletRegistration.Dynamic dispather = container.addServlet("spring-web",
                new DispatcherServlet(appContext));
        /*MultipartConfigElement multipartConfigElement = new MultipartConfigElement(null, 15000000, 15000000, 0);
        dispather.setMultipartConfig(multipartConfigElement);*/
        dispather.setLoadOnStartup(1);
        dispather.addMapping("/");


    }
}
