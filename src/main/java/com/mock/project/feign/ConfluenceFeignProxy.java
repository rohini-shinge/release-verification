package com.mock.project.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign client interface for interacting with Confluence API.
 * <p>
 * This interface defines the methods to fetch content from Confluence.
 * </p>
 */
@FeignClient(name = "confluenceFeignProxy", url = "${confluence.url}", configuration = ConfluenceFeignConfig.class)
public interface ConfluenceFeignProxy {
    /**
     * Fetches the content of a Confluence page.
     *
     * @return The content of the Confluence page.
     */
    @GetMapping
    ResponseEntity<String> getPageContent();
}
