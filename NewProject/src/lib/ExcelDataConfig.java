package lib;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelDataConfig {
	XSSFWorkbook wb;
    XSSFSheet sheet1;

    public ExcelDataConfig(String excelPath){
        try{
            File src = new File(excelPath);
            FileInputStream fis = new FileInputStream(src);

            wb = new XSSFWorkbook(fis);
            sheet1 = wb.getSheetAt(0);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public String getData(int sheetNumber,int row, int column){
        sheet1 = wb.getSheetAt(0);
        String data = sheet1.getRow(row).getCell(column).getStringCellValue();
        return data;
    }
    public int getRowCounter(int sheetIndex){

        int row = wb.getSheetAt(sheetIndex).getLastRowNum();
        row=row+1;
        return row;
    }
}
