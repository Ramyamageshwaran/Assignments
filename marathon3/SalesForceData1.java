package marathon3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SalesForceData1 {
		    public static String[][] readData(String fileName) throws IOException {
		        //Set up the Path
		        XSSFWorkbook wb = new XSSFWorkbook("Data/"+fileName+".xlsx");
		        XSSFSheet ws = wb.getSheet("Sheet1");
		        XSSFRow row = ws.getRow(0);
		        XSSFCell cell = row.getCell(0);
		        String stringCellValue = cell.getStringCellValue();
		        System.out.println(stringCellValue);
		        
		        int lastRowNum = ws.getLastRowNum();
		        short lastCellNum = row.getLastCellNum();
		        String[][] data=new String[lastRowNum][lastCellNum];
		        
		         for (int i = 1; i <=lastRowNum ; i++) {
		                XSSFRow Lrow = ws.getRow(i);
		                
		                for (int j = 0; j <lastCellNum ; j++) {                            
		                    
		                    //get into cell
		                    XSSFCell cell2 = Lrow.getCell(j);
		                    
		                    String stringCellValue2 = cell2.getStringCellValue();
		                    data[i-1][j]=stringCellValue2;
		                    System.out.println(stringCellValue2);
		                    
		                }        
		    
		         }
		         
		        //close the file
		            wb.close();
		            return data;

	}

}
