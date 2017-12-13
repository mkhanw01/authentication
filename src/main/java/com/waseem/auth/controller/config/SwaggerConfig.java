package com.waseem.auth.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 * Created by khan on 12/13/17.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
        .paths(PathSelectors.any()).build()
        .genericModelSubstitutes(DeferredResult.class, ResponseEntity.class)
        .globalOperationParameters(Arrays.asList(
            new ParameterBuilder().name("storeId").parameterType("header")
                .modelRef(new ModelRef("string")).required(true).defaultValue("10101")
                .description("client's store id").build(),
            new ParameterBuilder().name("username").parameterType("header")
                .modelRef(new ModelRef("string")).required(false).defaultValue("USERNAME")
                .description("client's username").build()));
  }
}
