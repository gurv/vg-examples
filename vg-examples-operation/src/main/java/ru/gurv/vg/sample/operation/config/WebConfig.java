package ru.gurv.vg.sample.operation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    //TODO не работает, надо разобраться, так описано в документации (https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-cors)
/*
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        // Swagger
        registry.addMapping("/v2/api-docs");
    }
*/

    //TODO перейти на addCorsMappings
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        // Swagger
        //TODO для Swagger-а достаточно "/v2/api-docs", а здесь все для вызова API из swagger-ui
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
