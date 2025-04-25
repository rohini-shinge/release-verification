package com.mock.project.feign.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
public class ConfluenceAuthentication {

    @Value("${confluence.username}")
    private String username;

    @Value("${confluence.apiToken}")
    private String apiToken;

}
