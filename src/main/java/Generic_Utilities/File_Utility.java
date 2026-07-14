package Generic_Utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
    static  FileInputStream file = null;
    static  Workbook book = null;
    static  Sheet sheet=null;
    static  Row row = null;
    static  Cell cell = null;

    public static String getProperty(String key)  {
        try {
             file=new FileInputStream("./src/main/resources/common.properties");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        Properties properties =new Properties();
        try {
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
         return properties.getProperty(key);
    }

    public static String getSingleData(String sheetName,int rowNum,int cellNum) {
        try{
            file= new FileInputStream("./src/test/resources/testScriptData.xlsx");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
           e.printStackTrace();
        }
        sheet= book.getSheet(sheetName);
         row = sheet.getRow(rowNum);
         cell = row.getCell(cellNum);
        return  cell.toString();
    }

    public static String[][] getMultipleData(String sheetName) {
        try{
            file= new FileInputStream("./src/test/resources/testScriptData.xlsx");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int rowNum = getNumberOfRows(sheetName);
        int cellNum = getNumberOfCells(sheetName);
        String[][] data = new String[rowNum-1][cellNum];
        for (int i = 1; i < rowNum; i++) {
            for (int j = 0; j < cellNum; j++) {
                data[i-1][j]=book.getSheet(sheetName).getRow(i).getCell(j).toString();
            }
        }
        return data;
    }

    public static int getNumberOfRows(String sheetName){
        try{
            file= new FileInputStream("./src/test/resources/testScriptData.xlsx");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return book.getSheet(sheetName).getPhysicalNumberOfRows();
    }
    public static int getNumberOfCells(String sheetName){
        try{
            file= new FileInputStream("./src/test/resources/testScriptData.xlsx");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return book.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
    }
}

