package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

    public static String getCellvalue(String fileName, String sheetName, int rowNo, int cellNo) {
    	String cellvalue = "";
    	try
		{
    		 
           //to read the file
    		FileInputStream inputStream = new FileInputStream(fileName);
    		XSSFWorkbook	workBook = new XSSFWorkbook(inputStream);
    		XSSFSheet excelSheet =  workBook.getSheet(sheetName);
    		XSSFCell cell = workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
    		if (cell.getCellType()==CellType.NUMERIC) {
    			cellvalue=String.valueOf((long)cell.getNumericCellValue());
    		}else if(cell.getCellType()==CellType.STRING){
    			cellvalue=cell.getStringCellValue();  			
    		}  /*else {
    			cellvalue = cell.toString(); 
    		}*/
    		

    		workBook.close();

    		return cellvalue;
			
					

		}

		catch (Exception e)

		{
			return "";

		}
	}

    public static int getRowCount(String fileName, String sheetName) {
        try {
        FileInputStream inputStream = new FileInputStream(fileName);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet(sheetName);
          
           int totalrows=sheet.getLastRowNum() + 1;
           return totalrows;
             }    
        catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getColCount(String fileName, String sheetName) {
        try (FileInputStream inputStream = new FileInputStream(fileName);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);

                int totalcell= sheet.getRow(0).getLastCellNum();
                return totalcell;
            }
         catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
