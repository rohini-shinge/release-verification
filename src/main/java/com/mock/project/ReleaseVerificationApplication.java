package com.mock.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;


/**
 * Main application class for the Release Verification application.
 * <p>
 * This class serves as the entry point for the Spring Boot application.
 * </p>
 */
@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class ReleaseVerificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReleaseVerificationApplication.class, args);
    }

}
