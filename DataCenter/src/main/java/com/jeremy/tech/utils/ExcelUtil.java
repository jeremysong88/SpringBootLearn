package com.jeremy.tech.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;

import java.io.File;
import java.io.IOException;

/**
 * Created by jeremysong on 7/6/2017.
 */
public class ExcelUtil {

    public static void createExcel() throws IOException {
        HSSFWorkbook sheets = new HSSFWorkbook();
        HSSFSheet sheet = sheets.createSheet();
        HSSFRow row = sheet.createRow(1);
        HSSFCell cell = row.createCell(1);
        cell.setCellValue("ABC");

        HSSFFont font = sheets.createFont();
        font.setBold(true);
        font.setItalic(true);
        font.setColor(Font.COLOR_RED);

        HSSFCellStyle cellStyle = sheets.createCellStyle();
        cellStyle.setBorderBottom(BorderStyle.DASH_DOT);
        cellStyle.setBorderLeft(BorderStyle.DOUBLE);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        cellStyle.setFont(font);

        cell.setCellStyle(cellStyle);

        sheets.write(new File("F:\\github\\SpringBootLearn\\DataCenter\\test.xlsx"));
    }

    public static void main(String[] args) {
        try {
            createExcel();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
