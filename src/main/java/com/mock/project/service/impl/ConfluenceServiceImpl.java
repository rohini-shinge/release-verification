package com.mock.project.service.impl;

import com.jayway.jsonpath.JsonPath;
import com.mock.project.feign.ConfluenceFeignProxy;
import com.mock.project.service.ConfluenceService;
import com.mock.project.util.ExcelWriterUtil;
import com.mock.project.util.HtmlTableParserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
/**
 * Implementation of the ConfluenceService interface.
 * <p>
 * This class fetches release details from Confluence and exports them to an Excel file.
 * </p>
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ConfluenceServiceImpl implements ConfluenceService {

    /**
     * The ConfluenceFeignProxy is used to interact with the Confluence API.
     */
    private final ConfluenceFeignProxy confluenceFeignProxy;

    /**
     * Exports release details to an Excel file.
     *
     * @return ResponseEntity containing the Excel file.
     */
    @Override
    public ResponseEntity<String> exportReleaseDetailsToExcel() {
        try {
            // Fetch the page content from Confluence using Feign
            Optional<String> pageContent = this.getPageContent();
            if (pageContent.isPresent()) {

                // Extract HTML content
                String htmlContent = JsonPath.read(pageContent.get(), "$.body.storage.value");

                // Parse the table data
                String[][] tableData = HtmlTableParserUtil.parseTableData(htmlContent);
                // Write the table data to an Excel file
                ExcelWriterUtil.writeToExcel(tableData, "ReleaseDetails.xlsx");

                return ResponseEntity.ok("Excel file created successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch page content.");
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error writing to Excel file: " + e.getMessage());
        }
    }

    /**
     * Fetches the content of a Confluence page.
     *
     * @return The content of the Confluence page.
     */
    private Optional<String> getPageContent() {
        try {
            ResponseEntity<String> response = confluenceFeignProxy.getPageContent();
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null && !response.getBody().isEmpty()) {
                return Optional.ofNullable(response.getBody());
            }
        } catch (Exception e) {
            log.error("Error fetching page content from Confluence: {}", e.getMessage());
        }
        return Optional.empty();
    }
}