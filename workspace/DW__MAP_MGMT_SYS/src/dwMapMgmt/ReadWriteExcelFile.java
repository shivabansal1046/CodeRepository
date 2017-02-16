package dwMapMgmt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import javax.swing.text.html.HTMLDocument.Iterator;
import  java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet; 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadWriteExcelFile {

	

	public static void main(String[] args) throws IOException {
		
		
		 
		try {
	           FileInputStream file = new FileInputStream(new File("C:\\soft dumps\\Globe Optimus Phase 2 -  Tier 1 to Tier 2 Mapping Sheet_TRX.xls")); 
	           //Get the workbook instance for XLS file
	           HSSFWorkbook workbook = new HSSFWorkbook(file);     
	           //Get first sheet from the workbook     
	           HSSFSheet sheet = workbook.getSheetAt(0);           
	           //Iterate through each rows from first sheet     
	           java.util.Iterator<Row> rowIterator = sheet.iterator();     
	           while( rowIterator.hasNext()) {
	                    Row row = rowIterator.next();
	                    //For each row, iterate through each columns
	                    Iterator<Cell> cellIterator = row.cellIterator();         
	                    while(cellIterator.hasNext()) {                           
	                    Cell cell = cellIterator.next();
	                    switch(cell.getCellType())
	                     {  
	                       case Cell.CELL_TYPE_BOOLEAN:
	                         System.out.print(cell.getBooleanCellValue() + "\t\t");
	                         break;
	                       case Cell.CELL_TYPE_NUMERIC:
	                         System.out.print(cell.getNumericCellValue() + "\t\t"); 
	                          break;
	                       case Cell.CELL_TYPE_STRING:  
	                         System.out.print(cell.getStringCellValue() + "\t\t"); 
	                         break;
	                     }
	                   }
	                   System.out.println("");
	                  }
	                 file.close(); 
	                  FileOutputStream out = new FileOutputStream(new File("C:\\soft dumps\\test1.xls"));
	                   workbook.write(out);
	                    out.close();
	                   }
	                    catch (FileNotFoundException e)
	                     {     e.printStackTrace(); 
	                     } catch (IOException e) { 
	                         e.printStackTrace();
	                          }
		
	}

}

