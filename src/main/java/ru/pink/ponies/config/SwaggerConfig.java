package ru.pink.ponies.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public Docket swagger() {
        Contact contact = new Contact("Call-center-shop", "https://your-url.ru", "vanadiiii42@gmail.com");
        ApiInfo apiInfo = new ApiInfo(
                "Call center shop mock",
                "just shop",
                "1.0.0",
                null,
                contact,
                null,
                null,
                Collections.singletonList(new StringVendorExtension("name", "value"))
        );
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.pink.ponies.web"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo);
    }
}