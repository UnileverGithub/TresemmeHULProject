package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private String filePath;

    public ExcelUtils(String filePath) {
        this.filePath = filePath;
    }

    public String readData(String sheetName, int rowNum, int colNum) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        String data = cell.getStringCellValue();
        workbook.close();
        fis.close();
        return data;
    }

    public void writeData(String sheetName, int rowNum, int colNum, String data) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.createCell(colNum);
        cell.setCellValue(data);
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();
    }
    
    public String[] getColumnData(String sheetName, int columnIndex) {
        String[] columnData = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum() + 1;
            columnData = new String[rowCount];
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(columnIndex);
                if (cell != null) {
                    columnData[i] = cell.toString();
                } else {
                    columnData[i] = ""; // or any default value
                }
            }

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return columnData;
    }

}
