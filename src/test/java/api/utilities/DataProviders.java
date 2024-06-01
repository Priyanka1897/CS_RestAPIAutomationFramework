package api.utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "AllData")
    public String [][] AllDataProvider() {
        String fileName = System.getProperty("user.dir") + "//TestData//TestData.xlsx";
        String sheetname="Sheet1";
        int totalrows = ReadExcelFile.getRowCount(fileName, sheetname);
        int totalcell = ReadExcelFile.getColCount(fileName, sheetname);

        String[][] userData = new String[totalrows - 1][totalcell];
        //DataFormatter formatter = new DataFormatter();

        for (int rowNo = 1; rowNo < totalrows; rowNo++) {
            for (int cellNo = 0; cellNo < totalcell; cellNo++) 
            	
            	{
    				userData[rowNo-1][cellNo] = ReadExcelFile.getCellvalue(fileName, "Sheet1", rowNo, cellNo).toString();
    				
            	}
        }
        return userData;
    }
       
        @DataProvider(name="UserNamesData")
        public String [] UserNamesDataProvider(){
    		String fileName = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
    		 String sheetname="Sheet1";
    		
    		int totalrows = ReadExcelFile.getRowCount(fileName, sheetname);
    	//	int ttlColCnt= ReadExcelFile.getColCount(fName, "Sheet1");
    		
    		String userNamesData[] = new String[totalrows-1];
    		
    		for(int rowNo = 1; rowNo<totalrows; rowNo++)
    		{
    			userNamesData[rowNo-1] = ReadExcelFile.getCellvalue(fileName, "Sheet1", rowNo, 1);
    			
    		}
    		return userNamesData;
    	}
    	
       
}

