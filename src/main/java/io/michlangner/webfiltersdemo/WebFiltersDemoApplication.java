package io.michlangner.webfiltersdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
public class WebFiltersDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFiltersDemoApplication.class, args);
    }

}
