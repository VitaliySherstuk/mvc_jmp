package com.epam.vsharstuk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

@Configuration
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext context) {
        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(ServletConfig.class);
        webCtx.setServletContext(context);
        ServletRegistration.Dynamic servlet = context.addServlet("dispatcher", new DispatcherServlet(webCtx));
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(null, 15000000, 15000000, 0);
        servlet.setMultipartConfig(multipartConfigElement);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

        context.addFilter("name", CharacterEncodingFilter.class)
                .addMappingForUrlPatterns(null, false, "/*");
        context
                .addFilter("springSecurityFilterChain", new DelegatingFilterProxy())
                .addMappingForUrlPatterns(null, true, "/*");
    }


}
