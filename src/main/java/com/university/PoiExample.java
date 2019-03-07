package com.university;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PoiExample {
    public static void main(String[] args) throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("depId1 Development");
        XSSFRow row = spreadsheet.createRow(0);
        Workbook wb = new XSSFWorkbook();
        DataFormat format = wb.createDataFormat();
        XSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 9);
        font.setBold(true);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("Emp Id");
        cell.setCellStyle(style);
        style.setAlignment(HorizontalAlignment.CENTER);
        XSSFCell cell2 = row.createCell(1);
        cell2.setCellValue("Last Name");
        cell2.setCellStyle(style);
        style.setAlignment(HorizontalAlignment.CENTER);
        XSSFCell cell3 = row.createCell(2);
        cell3.setCellValue("First Name");
        cell3.setCellStyle(style);
        style.setAlignment(HorizontalAlignment.CENTER);
        XSSFCell cell4 = row.createCell(3);
        cell4.setCellValue("BirthDate");
        cell4.setCellStyle(style);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setDataFormat(format.getFormat("0.0"));
        cell.setCellStyle(style);
        style.setAlignment(HorizontalAlignment.CENTER);
        XSSFCell cell5 = row.createCell(4);
        cell5.setCellValue("Manager ID");
        cell5.setCellStyle(style);
        style.setAlignment(HorizontalAlignment.CENTER);
        XSSFCell cell6 = row.createCell(6);
        cell6.setCellValue("Skills");
        cell6.setCellStyle(style);
        style.setAlignment(HorizontalAlignment.CENTER);

        Map< String, Object[] > empinfo = new TreeMap<>();
        empinfo.put( "1", new Object[] {"001", "LastName", "FirstName", "01.01.2000",  "0",  " Communication" });
        empinfo.put( "2", new Object[] {"002","LastName2", "FirstName2","01.01.2001",  "001", " Sleeps only 2 hours per day,Overtimes without concerns,Works for food"});
        empinfo.put( "3", new Object[] {"003","LastName3", "FirstName3","01.01.2002", "002", " Self-motivation,Creativity,Sherlock Holmes" });
        Set< String > keyId = empinfo.keySet();
        int rowId = 1;

        for (String key : keyId) {
            row = spreadsheet.createRow(rowId++);
            Object [] objectArr = empinfo.get(key);
            XSSFFont font1 = workbook.createFont();
            font1.setFontHeightInPoints((short)9);
            XSSFCellStyle style5 = workbook.createCellStyle();
            style5.setFont(font1);
            int cellId = 0;

            for (Object obj : objectArr) {
                Cell cell20 = row.createCell(cellId++);
                cell20.setCellValue((String)obj);
                cell20.setCellStyle(style5);
                style5.setAlignment(HorizontalAlignment.LEFT);

            }
        }



        XSSFSheet spreadsheet1 = workbook.createSheet("depId2 Accounting");
        XSSFRow row1 = spreadsheet1 .createRow(0);
        Workbook wb1 = new XSSFWorkbook();
        DataFormat format1 = wb1.createDataFormat();
        XSSFFont font1 = workbook.createFont();
        font1.setFontHeightInPoints((short) 9);
        font1.setBold(true);
        XSSFCellStyle style1 = workbook.createCellStyle();
        style1.setFont(font1);
        XSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("Emp Id");
        cell1.setCellStyle(style1);
        style1.setAlignment(HorizontalAlignment.CENTER);
        XSSFCell cell21 = row1.createCell(1);
        cell21.setCellValue("Last Name");
        cell21.setCellStyle(style1);
        style1.setAlignment(HorizontalAlignment.CENTER);
        XSSFCell cell31 = row1.createCell(2);
        cell31.setCellValue("First Name");
        cell31.setCellStyle(style1);
        style1.setAlignment(HorizontalAlignment.CENTER);
        XSSFCell cell41 = row1.createCell(3);
        cell41.setCellValue("BirthDate");
        cell41.setCellStyle(style1);
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setDataFormat(format1.getFormat("0.0"));
        cell.setCellStyle(style1);
        style1.setAlignment(HorizontalAlignment.CENTER);
        XSSFCell cell51 = row1.createCell(4);
        cell51.setCellValue("Manager ID");
        cell51.setCellStyle(style1);
        style1.setAlignment(HorizontalAlignment.CENTER);
        XSSFCell cell61 = row1.createCell(6);
        cell61.setCellValue("Skills");
        cell61.setCellStyle(style1);
        style1.setAlignment(HorizontalAlignment.CENTER);

        Map< String, Object[] > employeeinfo = new TreeMap<>();
        employeeinfo.put( "1", new Object[] {"04", "LastName4", "FirstName4", "01.01.2004",  "0",  " Leadership,Decision Making" });
        employeeinfo.put( "2", new Object[] {"05","LastName5", "FirstName5","01.01.2005",  "04", " Adaptability,Java"});
        Set< String > keyId1 = employeeinfo.keySet();
        int rowId1= 1;

        for (String key : keyId1) {
            row1 = spreadsheet1.createRow(rowId1++);
            Object [] objectArr =employeeinfo.get(key);
            XSSFFont font11 = workbook.createFont();
            font11.setFontHeightInPoints((short)9);
            XSSFCellStyle style5 = workbook.createCellStyle();
            style5.setFont(font11);
            int cellId1 = 0;

            for (Object obj : objectArr) {
                Cell cell20 = row1.createCell(cellId1++);
                cell20.setCellValue((String)obj);
                cell20.setCellStyle(style5);
                style5.setAlignment(HorizontalAlignment.LEFT);

            }
        }


        FileOutputStream out1 = new FileOutputStream(new File("lab.xlsx"));
        workbook.write(out1);
        out1.close();

    }
}