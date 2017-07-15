package skeleton.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.*;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/service/Soap/*"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {ApplicationConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {SoapContextConfig.class};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);


        return new Filter[] {characterEncodingFilter};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("defaultHtmlEscape", "true");
        registration.setInitParameter("spring.profiles.active", "default");
    }

    @Override
    protected FrameworkServlet createDispatcherServlet(WebApplicationContext webContext){
        MessageDispatcherServlet soapServlet = new MessageDispatcherServlet(webContext);
        soapServlet.setTransformWsdlLocations(true);
        return soapServlet;
    }
}