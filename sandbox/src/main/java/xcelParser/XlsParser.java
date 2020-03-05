package xcelParser;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class XlsParser {
    public static void main(String[] args) {
        String path = "sandbox\\src\\main\\resources\\testXls.xls";

        parseXls(new File(path));
    }

    private static void parseXls(File file) {
        HSSFWorkbook myExcelBook = null;
        try {
            myExcelBook = new HSSFWorkbook(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        HSSFSheet myExcelSheet = myExcelBook.getSheet("Лист1");
        for (Row row : myExcelSheet) {
            HSSFRow r = (HSSFRow)row;

            System.out.println("rowNum: " + r.getRowNum());
            for (Cell cell: row) {
                HSSFCell c = (HSSFCell) cell;
                HSSFColor color = c.getCellStyle().getFont(myExcelBook).getHSSFColor(myExcelBook);
                short colorShort = c.getCellStyle().getFont(myExcelBook).getColor();
                if(!c.getStringCellValue().isEmpty())
                    System.out.println("cellNum: " + c.getColumnIndex()
                            + " value: " + c.getStringCellValue());
                        System.out.print("  color: " + colorShort + "\n");
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
