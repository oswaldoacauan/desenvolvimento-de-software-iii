package com.egov.contract.config;

import io.swagger.jaxrs.config.BeanConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by marcus on 14/11/2016.
 */
@Configuration
public class SwaggerConfig {
        @Bean
        public BeanConfig beanConfig() {
            BeanConfig beanConfig = new BeanConfig();
            beanConfig.setVersion("1.0.0");
            beanConfig.setSchemes(new String[]{"http"});
            beanConfig.setHost("localhost:9000");
            beanConfig.setResourcePackage("com.egov.contract.endpoints");
            beanConfig.setScan(true);
            return beanConfig;
        }
}
