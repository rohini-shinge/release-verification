package com.mock.project.feign;

import com.mock.project.feign.config.ConfluenceAuthentication;
import feign.auth.BasicAuthRequestInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

/**
 * Configuration class for the Confluence Feign client.
 * <p>
 * This class sets up the Feign client with basic authentication using the username and API token.
 * </p>
 */
@RequiredArgsConstructor
@Slf4j
public class ConfluenceFeignConfig {
    /**
     * This class is used to configure the Feign client for Confluence.
     * It sets up basic authentication using the username and API token.
     * The username and API token are retrieved from the application properties.
     */
    private final ConfluenceAuthentication confluenceAuthentication;

    /**
     * This method creates a BasicAuthRequestInterceptor bean for basic authentication.
     * It uses the username and API token from the ConfluenceAuthentication class.
     *
     * @return A BasicAuthRequestInterceptor configured with the username and API token.
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(confluenceAuthentication.getUsername(),
                confluenceAuthentication.getApiToken());

    }

}
