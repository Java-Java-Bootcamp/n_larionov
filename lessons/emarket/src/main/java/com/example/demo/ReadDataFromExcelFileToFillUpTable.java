//package com.example.demo;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.springframework.stereotype.Service;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//@Service
//public class ReadDataFromExcelFileToFillUpTable {
//    public ReadDataFromExcelFileToFillUpTable() throws IOException {
//        FileInputStream fis = new FileInputStream("E:/EmarketData/Temp.xls");
//        Workbook wb = new HSSFWorkbook(fis);
//
//        String result = wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
//        System.out.println(String.valueOf(result));
//        fis.close();
//    }
//}
