package com.first.test.microservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;

@Configuration
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfiguration {

    @Bean
    public Docket exportServiceApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(
                        "com.first.test.microservice.controller"))
                .paths(PathSelectors.any()).build().pathMapping("/")
                .protocols(new HashSet<>(Collections.singletonList("http")))
                .directModelSubstitute(LocalDate.class, String.class)
                .directModelSubstitute(Locale.class, String.class)
                .useDefaultResponseMessages(false);
    }

}
