package com.mock.project.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Utility class for writing data to an Excel file.
 * <p>
 * This class provides methods to create an Excel file and write table data to it.
 * </p>
 */
public class ExcelWriterUtil {

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private ExcelWriterUtil() {
        // Prevent instantiation
    }

    /**
     * Writes the given table data to an Excel file.
     *
     * @param tableData The 2D array containing the table data.
     * @param fileName  The name of the Excel file to be created.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void writeToExcel(String[][] tableData, String fileName) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(); FileOutputStream fileOut = new FileOutputStream(fileName)) {
            Sheet sheet = workbook.createSheet("Release Details");
            for (int i = 0; i < tableData.length; i++) {
                Row row = sheet.createRow(i);
                for (int j = 0; j < tableData[i].length; j++) {
                    row.createCell(j).setCellValue(tableData[i][j]);
                }
            }
            workbook.write(fileOut);
        }
    }
}