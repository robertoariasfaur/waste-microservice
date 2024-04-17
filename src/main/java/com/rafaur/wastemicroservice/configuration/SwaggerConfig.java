//package com.rafaur.wastemicroservice.configuration;
//
//import com.google.common.base.Predicate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import static com.google.common.base.Predicates.or;
//import static springfox.documentation.builders.PathSelectors.regex;
//
////@Configuration
////@EnableSwagger2
//public class SwaggerConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("Prueba Tecnica-API REST")
//                .apiInfo(usersApiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(paths())
//                .build()
//                .useDefaultResponseMessages(false);
//    }
//
//    private ApiInfo usersApiInfo() {
//        return new ApiInfoBuilder()
//                .title("Prueba Tecnica de Servicios Rest ")
//                .version("1.0")
//                .license("Apache License Version 2.0")
//                .build();
//    }
//
//    private Predicate<String> paths() {
//
//        return or(
//                regex("/entity.*"),
//                regex("/some.*"),
//                regex("/contacts.*"),
//                regex("/pet.*"),
//                regex("/springsRestController.*"),
//                regex("/test.*"));
//    }
//
//}