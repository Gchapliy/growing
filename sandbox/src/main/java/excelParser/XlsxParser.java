package excelParser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XlsxParser {
    public static void main(String[] args) {
        String path = "sandbox\\src\\main\\resources\\testXlsx.xlsx";
        File file = new File(path);
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //parseXls(file);
    }

    private static void parseXls(File file) {
        XSSFWorkbook myExcelBook = null;
        try {
            myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet myExcelSheet = myExcelBook.getSheet("Лист1");
        for (Row row : myExcelSheet) {

            System.out.println("rowNum: " + row.getRowNum());
            for (Cell cell: row) {
                XSSFCell c = (XSSFCell) cell;
                XSSFColor color = c.getCellStyle().getFont().getXSSFColor();
                if(!c.getStringCellValue().isEmpty())
                    System.out.println("cellNum: " + c.getColumnIndex()
                            + " value: " + c.getStringCellValue());
                if(color != null){
                    System.out.print(" color: " + color.getARGBHex() + "\n");
                }
            }
        }

        try {
            myExcelBook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isRowEmpty(Row row){
        for (Cell c : row) {
            if(!c.getStringCellValue().isEmpty()) return false;
        }

        return true;
    }
}
