package com.mock.project.controller;

import com.mock.project.service.ConfluenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling requests related to Confluence page content.
 * <p>
 * This controller provides an endpoint to export release details to an Excel file.
 * </p>
 */
@RestController
@RequestMapping("/api/releaseInfo")
@RequiredArgsConstructor
public class ConfluenceController {

    /**
     * The Confluence service used to interact with Confluence API.
     */
    private final ConfluenceService confluenceService;

    /**
     * Endpoint to export release details to an Excel file.
     *
     * @return ResponseEntity containing the Excel file.
     */
    @GetMapping("/export")
    public ResponseEntity<String> exportReleaseDetailsToExcel() {
        return confluenceService.exportReleaseDetailsToExcel();
    }
}
