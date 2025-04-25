package com.mock.project.service;

import org.springframework.http.ResponseEntity;

public interface ConfluenceService {
    /**
     * Exports release details to an Excel file.
     *
     * @return ResponseEntity containing the Excel file.
     */
    ResponseEntity<String> exportReleaseDetailsToExcel();
}
