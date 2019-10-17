package com.spb.StrangersPlayBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket documentation() {
        return new Docket(SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/.*"))
                .build()
                .pathMapping("/")
                .apiInfo(metadata());
    }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration(null);
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Strangers Play Backend")
                .description("asd")
                .version("1.0")
                .contact(new Contact("qwertyTeam", "url", "email"))
                .build();
    }

}
