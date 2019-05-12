package com.nemk.educator;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@EnableConfigurationProperties(StorageProperties.class)
public class NemkEducatorApplication {

//    http://aralmighty.com/uploading-files-spring-boot

//    http://websystique.com/springmvc/spring-mvc-4-fileupload-download-hibernate-example/

    public static void main(String[] args) {
        SpringApplication.run(NemkEducatorApplication.class, args);
    }


    @Bean
    public CorsConfigurationSource corsFilter(){

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration configuration = new CorsConfiguration();
        List headers = new ArrayList<>();
        headers.add("*");
        List orgins = new ArrayList<>();
        headers.add("*");

        List<String> allowedMethods = new ArrayList();
        allowedMethods.add("OPTIONS");
        allowedMethods.add("POST");
        allowedMethods.add("GET");
        allowedMethods.add("PUT");
        allowedMethods.add("DELETE");

        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(headers);
        configuration.setAllowedOrigins(orgins);
        configuration.setAllowedMethods(allowedMethods);
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
