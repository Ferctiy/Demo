package com.project.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2
 *
 * @author feroctiy(lipenggang @ touscm.com)
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket (DocumentationType.SWAGGER_2)
                .apiInfo (apiInfo ())
                .select ()
                .apis (RequestHandlerSelectors.basePackage ("com.project.web"))
                .paths (PathSelectors.any ())
                .build ();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder ()
                .title ("接口api")
                .description ("学习使用swagger2")
                .termsOfServiceUrl ("http://localhost:8080/swagger-ui.html")
                .version ("1.0")
                .build ();
    }
}
