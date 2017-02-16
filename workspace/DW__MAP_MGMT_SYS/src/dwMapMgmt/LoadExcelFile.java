package dwMapMgmt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
//import javax.swing.text.html.HTMLDocument.Iterator;
import  java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet; 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.NoSuchElementException;



public class LoadExcelFile {

	String Subject_Area ;
	String Phase_1 ;
	String Application ;
	String SCD_NON_SCD ;
	String SK_NOT_SK ;
	String RI_NOT_RI ;
	String RI_col ;
	String Code_Logic_Scenario ;
	String Ref_Table ;
	String Status ;
	String PI ;
	String PPI ;
	String Key_Columns ;
	String Tier_2_Target_Table_Logical_Name ;
	String Tier_2_Target_Column_Logical_Name ;
	String Tier_2_Target_Table_Physical_Name ;
	String Tier_2_Target_Column_Physical_Name ;
	String Tier_2_Data_Type ;
	String Tier_1_Source_Table ;
	String Tier_1_Source_Column ;
	String Business_Logic_Column_Level ;
	String Business_Logic_Row_Level ;
	String Table_column_change_detail ;
	

	
	public String getSubject_Area() {
		return Subject_Area;
	}



	public void setSubject_Area(String subject_Area) {
		Subject_Area = subject_Area;
	}



	public String getPhase_1() {
		return Phase_1;
	}



	public void setPhase_1(String phase_1) {
		Phase_1 = phase_1;
	}



	public String getApplication() {
		return Application;
	}



	public void setApplication(String application) {
		Application = application;
	}



	public String getSCD_NON_SCD() {
		return SCD_NON_SCD;
	}



	public void setSCD_NON_SCD(String sCD_NON_SCD) {
		SCD_NON_SCD = sCD_NON_SCD;
	}



	public String getSK_NOT_SK() {
		return SK_NOT_SK;
	}



	public void setSK_NOT_SK(String sK_NOT_SK) {
		SK_NOT_SK = sK_NOT_SK;
	}



	public String getRI_NOT_RI() {
		return RI_NOT_RI;
	}



	public void setRI_NOT_RI(String rI_NOT_RI) {
		RI_NOT_RI = rI_NOT_RI;
	}



	public String getRI_col() {
		return RI_col;
	}



	public void setRI_col(String rI_col) {
		RI_col = rI_col;
	}



	public String getCode_Logic_Scenario() {
		return Code_Logic_Scenario;
	}



	public void setCode_Logic_Scenario(String code_Logic_Scenario) {
		Code_Logic_Scenario = code_Logic_Scenario;
	}



	public String getRef_Table() {
		return Ref_Table;
	}



	public void setRef_Table(String ref_Table) {
		Ref_Table = ref_Table;
	}



	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}



	public String getPI() {
		return PI;
	}



	public void setPI(String pI) {
		PI = pI;
	}



	public String getPPI() {
		return PPI;
	}



	public void setPPI(String pPI) {
		PPI = pPI;
	}



	public String getKey_Columns() {
		return Key_Columns;
	}



	public void setKey_Columns(String key_Columns) {
		Key_Columns = key_Columns;
	}



	public String getTier_2_Target_Table_Logical_Name() {
		return Tier_2_Target_Table_Logical_Name;
	}



	public void setTier_2_Target_Table_Logical_Name(
			String tier_2_Target_Table_Logical_Name) {
		Tier_2_Target_Table_Logical_Name = tier_2_Target_Table_Logical_Name;
	}



	public String getTier_2_Target_Column_Logical_Name() {
		return Tier_2_Target_Column_Logical_Name;
	}



	public void setTier_2_Target_Column_Logical_Name(
			String tier_2_Target_Column_Logical_Name) {
		Tier_2_Target_Column_Logical_Name = tier_2_Target_Column_Logical_Name;
	}



	public String getTier_2_Target_Table_Physical_Name() {
		return Tier_2_Target_Table_Physical_Name;
	}



	public void setTier_2_Target_Table_Physical_Name(
			String tier_2_Target_Table_Physical_Name) {
		Tier_2_Target_Table_Physical_Name = tier_2_Target_Table_Physical_Name;
	}



	public String getTier_2_Target_Column_Physical_Name() {
		return Tier_2_Target_Column_Physical_Name;
	}



	public void setTier_2_Target_Column_Physical_Name(
			String tier_2_Target_Column_Physical_Name) {
		Tier_2_Target_Column_Physical_Name = tier_2_Target_Column_Physical_Name;
	}



	public String getTier_2_Data_Type() {
		return Tier_2_Data_Type;
	}



	public void setTier_2_Data_Type(String tier_2_Data_Type) {
		Tier_2_Data_Type = tier_2_Data_Type;
	}



	public String getTier_1_Source_Table() {
		return Tier_1_Source_Table;
	}



	public void setTier_1_Source_Table(String tier_1_Source_Table) {
		Tier_1_Source_Table = tier_1_Source_Table;
	}



	public String getTier_1_Source_Column() {
		return Tier_1_Source_Column;
	}



	public void setTier_1_Source_Column(String tier_1_Source_Column) {
		Tier_1_Source_Column = tier_1_Source_Column;
	}



	public String getBusiness_Logic_Column_Level() {
		return Business_Logic_Column_Level;
	}



	public void setBusiness_Logic_Column_Level(String business_Logic_Column_Level) {
		Business_Logic_Column_Level = business_Logic_Column_Level;
	}



	public String getBusiness_Logic_Row_Level() {
		return Business_Logic_Row_Level;
	}



	public void setBusiness_Logic_Row_Level(String business_Logic_Row_Level) {
		Business_Logic_Row_Level = business_Logic_Row_Level;
	}



	public String getTable_column_change_detail() {
		return Table_column_change_detail;
	}



	public void setTable_column_change_detail(String table_column_change_detail) {
		Table_column_change_detail = table_column_change_detail;
	}



	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		
		PreparedStatement stmt = null;
		 
		try {
	           FileInputStream file = new FileInputStream(new File("C:\\soft dumps\\Globe Optimus Phase 2 -  Tier 1 to Tier 2 Mapping Sheet_TRX.xlsx")); 
	           //Get the workbook instance for XLS file
	           XSSFWorkbook workbook = new XSSFWorkbook(file);     
	           //Get first sheet from the workbook     
	           XSSFSheet sheet = workbook.getSheetAt(0);           
	           //Iterate through each rows from first sheet     
	           java.util.Iterator<Row> rowIterator = sheet.iterator();  
	           List<LoadExcelFile> Col_DtlFromExcel = new ArrayList<LoadExcelFile>();
	       int b=1;
	           while( rowIterator.hasNext()) {
	        	   		String a="";
	        	   		List<String> TBL_LIST = new ArrayList<String>();
	        	   		LoadExcelFile e1=new LoadExcelFile();
	        	   					
	        	   		Row row = rowIterator.next();
	                    //For each row, iterate through each columns
	                    Iterator<Cell> cellIterator = row.cellIterator();         
	                         
	                     while(cellIterator.hasNext()) {   
	                    	
	                    	 Cell cell = cellIterator.next();
	                    	 cell.setCellType(Cell.CELL_TYPE_STRING);
	                    	 a=a+"#~#"+cell.getStringCellValue();
	                    	 TBL_LIST.add(cell.getStringCellValue());
	                    
	                     }
	                    	                    
	                           
	                     System.out.println(b+":"+a);
	                     for(int i=0;i<TBL_LIST.size();i++){
	                    	 System.out.println( TBL_LIST.get(i));
	                     }
	                     
	                   	 
	                   	  String Subject_Area=TBL_LIST.get(0);
	                   	
	                   	  e1.setSubject_Area(Subject_Area);	
	                   	  
	                   	  String Phase_1=TBL_LIST.get(1);
	                   	
	                   	  e1.setPhase_1(Phase_1);	
	                   	  
	                   	 String Application=TBL_LIST.get(2);
	                   	
	                   	  e1.setApplication(Application);	
	                   	  	                   	
	                   	 String SCD_NON_SCD=TBL_LIST.get(3);
	                   	
	                   	  e1.setSCD_NON_SCD(SCD_NON_SCD);	
	                   	  
	                   	  
	                   	  
	                 	 String SK_NOT_SK=TBL_LIST.get(4);
	                 	
	                   	  e1.setSK_NOT_SK(SK_NOT_SK);	
	                   	                    	  
	                   	  
	                   	 String RI_NOT_RI=TBL_LIST.get(5);
	                   	
	                   	  e1.setRI_NOT_RI(RI_NOT_RI);	
	                   	
	                   	
	                   	  
	                   	String RI_col=TBL_LIST.get(6);
	                   	
	                   	  e1.setRI_col(RI_col);	
	                   	 
	                   	  
	                   	String Code_Logic_Scenario=TBL_LIST.get(7);
	                   	
	                   	  e1.setCode_Logic_Scenario(Code_Logic_Scenario);	
	                   	 
	                   	  
	                     	String Ref_Table=TBL_LIST.get(8);
	                     	
		                   	  e1.setRef_Table(Ref_Table);	
		                   			                   	  
		                   	  
		                   	String Status=TBL_LIST.get(9);
		                   
		                   	  e1.setStatus(Status);	
		                   	 
		                   	  
		                   	String PI=TBL_LIST.get(10);
		                   	
		                   	
		                   	  e1.setPI(PI);	
		                   	
		                   	  
		                   	  
		                     String PPI=TBL_LIST.get(11);
		                    
			                 e1.setPPI(PPI);	
			                
			                   	  
			                   	  
			                  String Key_Columns=TBL_LIST.get(12);
			                  
				              e1.setKey_Columns(Key_Columns);	
				             
				                   	  
				             String Tier_2_Target_Table_Logical_Name=TBL_LIST.get(13);
				             
					         e1.setTier_2_Target_Table_Logical_Name(Tier_2_Target_Table_Logical_Name);	
					         
				         					        
					         
					         String Tier_2_Target_Column_Logical_Name=TBL_LIST.get(14);
					         e1.setTier_2_Target_Column_Logical_Name(Tier_2_Target_Column_Logical_Name);	
					       
					        
					         
					         String Tier_2_Target_Table_Physical_Name=TBL_LIST.get(15);
					         e1.setTier_2_Target_Table_Physical_Name(Tier_2_Target_Table_Physical_Name);	
					        
					         
					         String Tier_2_Target_Column_Physical_Name=TBL_LIST.get(16);
					         e1.setTier_2_Target_Column_Physical_Name(Tier_2_Target_Column_Physical_Name);	
					        
					         
					         String Tier_2_Data_Type=TBL_LIST.get(17);
					         e1.setTier_2_Data_Type(Tier_2_Data_Type);	
					        
					         
					         String Tier_1_Source_Table=TBL_LIST.get(18);
					         e1.setTier_1_Source_Table(Tier_1_Source_Table);	
					        
					         
					         String Tier_1_Source_Column=TBL_LIST.get(19);
					         e1.setTier_1_Source_Column(Tier_1_Source_Column);	
					        
					         
					         String Business_Logic_Column_Level=TBL_LIST.get(20);
					         e1.setBusiness_Logic_Column_Level(Business_Logic_Column_Level);	
					         
					         
					         String Business_Logic_Row_Level=TBL_LIST.get(21);
					         e1.setBusiness_Logic_Row_Level(Business_Logic_Row_Level);	
					         
					         
					         String Table_column_change_detail=TBL_LIST.get(22);
					         e1.setTable_column_change_detail(Table_column_change_detail);	
					        
					         	                   	  
	                   	  Col_DtlFromExcel.add(e1);
	                   	  b++;
	                   	 
	                   	  
		                	
	                  }
	                 file.close(); 
	                 Connection con=null;
	                 con = ConnectionMgt.getConnectionObject();
	     			
	     			String sql;	 
	     			int i=0;
	     			
	     			for (LoadExcelFile COLINST : Col_DtlFromExcel){
	     				sql= "insert into datamapping_T2(Subject_Area ,Phase_1 ,Application ,SCD_NON_SCD ,SK_NOT_SK ,RI_NOT_RI ,RI_col ,Code_Logic_Scenario ,Ref_Table ,Status ,PI ,PPI ,Key_Columns ,Tier_2_Table_Logical_Name ,Tier_2_Column_Logical_Name ,Tier_2_Table_Physical_Name ,Tier_2_Column_Physical_Name ,Tier_2_Data_Type ,Tier_1_Source_Table ,Tier_1_Source_Column ,Business_Logic_Column_Level ,Business_Logic_Row_Level ) " +
	    						"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	     				
	    				stmt = con.prepareStatement(sql);
	    				
	    				stmt.setString(1, COLINST.getSubject_Area ());
	    				stmt.setString(2, COLINST.getPhase_1 ());
	    				stmt.setString(3, COLINST.getApplication ());
	    				stmt.setString(4, COLINST.getSCD_NON_SCD ());
	    				stmt.setString(5, COLINST.getSK_NOT_SK ());
	    				stmt.setString(6, COLINST.getRI_NOT_RI ());
	    				stmt.setString(7, COLINST.getRI_col ());
	    				stmt.setString(8, COLINST.getCode_Logic_Scenario ());
	    				stmt.setString(9, COLINST.getRef_Table ());
	    				stmt.setString(10, COLINST.getStatus ());
	    				stmt.setString(11, COLINST.getPI ());
	    				stmt.setString(12, COLINST.getPPI ());
	    				stmt.setString(13, COLINST.getKey_Columns ());
	    				stmt.setString(14, COLINST.getTier_2_Target_Table_Logical_Name ());
	    				stmt.setString(15, COLINST.getTier_2_Target_Column_Logical_Name ());
	    				stmt.setString(16, COLINST.getTier_2_Target_Table_Physical_Name ());
	    				stmt.setString(17, COLINST.getTier_2_Target_Column_Physical_Name ());
	    				stmt.setString(18, COLINST.getTier_2_Data_Type ());
	    				stmt.setString(19, COLINST.getTier_1_Source_Table ());
	    				stmt.setString(20, COLINST.getTier_1_Source_Column ());
	    				stmt.setString(21, COLINST.getBusiness_Logic_Column_Level ());
	    				stmt.setString(22, COLINST.getBusiness_Logic_Row_Level ());
	    				//stmt.setString(23, COLINST.getTable_column_change_detail ());
	    				i++;
	    				System.out.println(i+":"+COLINST.getTier_2_Target_Column_Physical_Name ());
	    				stmt.execute();
	    				stmt.close();
	    				
	     			}
	                  }
	                    catch (FileNotFoundException e)
	                     {     e.printStackTrace(); 
	                     } catch (IOException e) { 
	                         e.printStackTrace();
	                          } catch (SQLException e) {
							// TODO Auto-generated catch block
	                        	  
							e.printStackTrace();
							
						} 
	}

}



