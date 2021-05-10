package com.springboot.rest.restwithspringbootdatajpa.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ConditionalOnProperty(prefix = "swagger", value="enabled", havingValue = "true")
@EnableSwagger2
public class SwaggerConfig {
}
