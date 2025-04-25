package com.mock.project.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Utility class for parsing HTML table data.
 * <p>
 * This class provides a method to parse HTML content and extract data from the first table found.
 * </p>
 */
public class HtmlTableParserUtil {

    /**
     * Private constructor to prevent instantiation.
     */
    private HtmlTableParserUtil() {
        // Prevent instantiation
    }
    /**
     * Parses the given HTML content and extracts data from the first table found.
     *
     * @param htmlContent The HTML content to be parsed.
     * @return A 2D array containing the table data.
     * @throws IllegalArgumentException If no table is found in the HTML content.
     */
    public static String[][] parseTableData(String htmlContent) {
        Document document = Jsoup.parse(htmlContent);
        Element table = document.selectFirst("table");
        if (table == null) {
            throw new IllegalArgumentException("No table found in the HTML content");
        }

        Elements rows = table.select("tr");
        String[][] tableData = new String[rows.size()][];

        for (int i = 0; i < rows.size(); i++) {
            Elements cells = rows.get(i).select("th, td");
            tableData[i] = new String[cells.size()];
            for (int j = 0; j < cells.size(); j++) {
                tableData[i][j] = cells.get(j).text();
            }
        }

        return tableData;
    }
}