package co.jp.tagbangers.config;

import javassist.NotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public SimpleMappingExceptionResolver exceptionResolver() {
        Properties properties = new Properties();
        properties.setProperty(NotFoundException.class.getName(), "error/404");
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        resolver.setExceptionMappings(properties);

        return resolver;
    }
}
