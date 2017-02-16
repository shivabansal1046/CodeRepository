package dwMapMgmt;
/**
 * Servlet implementation class AddColInfo
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Calendar;
//import javax.swing.text.html.HTMLDocument.Iterator;
import  java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFSheet; 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.NoSuchElementException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DataMapUpload {

	String ETL_LYR;
	String Phase_1 ;
	String Subject_Area ;
	String Application ;
	String SCD_NON_SCD ;
	String SK_NOT_SK ;
	String RI_NOT_RI ;
	String RI_col ;
	String Code_Logic_Scenario ;
	String Views;
	String Status ;
	String Ref_Table;
	String PI ;
	String PPI ;
	String Key_Columns ;
	String Tier_2_Target_Table_Logical_Name ;
	String Tier_2_Target_Column_Logical_Name ;
	String Tier_2_Target_Table_Physical_Name ;
	String Tier_2_Target_Column_Physical_Name ;
	String Owner;
	String Tier_2_Data_Type ;
	String Tier_1_Source_Table ;
	String Tier_1_Source_Column ;
	String Business_Logic_Column_Level ;
	String Business_Logic_Row_Level ;
	String Table_column_change_detail ;
	
	


	
	public String getETL_LYR() {
		return ETL_LYR;
	}



	public void setETL_LYR(String eTL_LYR) {
		ETL_LYR = eTL_LYR;
	}



	public String getViews() {
		return Views;
	}



	public void setViews(String views) {
		Views = views;
	}



	public String getOwner() {
		return Owner;
	}



	public void setOwner(String owner) {
		Owner = owner;
	}



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
	public void ExcdbUpload(String Filename) {
		
		PreparedStatement stmt = null;
		 
		try {
			
			 
			
	           FileInputStream file = new FileInputStream(Filename); 
	           //Get the workbook instance for XLS file
	           XSSFWorkbook workbook = new XSSFWorkbook(file);     
	           //Get first sheet from the workbook     
	           XSSFSheet sheet = workbook.getSheetAt(0);           
	           //Iterate through each rows from first sheet     
	           java.util.Iterator<Row> rowIterator = sheet.iterator();  
	           List<DataMapUpload> Col_DtlFromExcel = new ArrayList<DataMapUpload>();
	       int b=1;
	       
	       System.out.println(sheet.getLastRowNum());
	       if(rowIterator != null) 
	    	   rowIterator.next();
	       
	           while( rowIterator.hasNext()) {
	        	   		String a="";
	        	   		List<String> TBL_LIST = new ArrayList<String>();
	        	   		DataMapUpload e1=new DataMapUpload();
	        	   					
	        	   		Row row = rowIterator.next();
	                    //For each row, iterate through each columns
	                    Iterator<Cell> cellIterator = row.cellIterator();         
	                         
	                     while(cellIterator.hasNext()) {   
	                    	
	                    	 Cell cell = cellIterator.next();
	                    	 cell.setCellType(Cell.CELL_TYPE_STRING);
	                    	 a=a+"#~#"+cell.getStringCellValue();
	                    	 String celldt=cell.getStringCellValue();
	                    	 String celldt1=celldt.replaceAll("[\n\r]", " ");
	                    	 TBL_LIST.add(celldt1.replaceAll("[']", "\""));
	                    	 
	                     }
	                    	                    
	                           
	                    	                     
	                     for(int i=0;i<TBL_LIST.size();i++){
	                    	 System.out.println( TBL_LIST.get(i));
	                     }
	                     
	                     int i=0;
	                     
	                     String ETL_LYR=TBL_LIST.get(i);
		                   	
	                   	  e1.setETL_LYR(ETL_LYR);
	                   	  i++;
	                   	  
	                     String Phase_1=TBL_LIST.get(i);
		                   	
	                   	  e1.setPhase_1(Phase_1);
	                   	  i++;
	                   	 
	                   	  String Subject_Area=TBL_LIST.get(i);
	                   	
	                   	  e1.setSubject_Area(Subject_Area);	
	                   	  
	                   	 i++;
	                   	  
	                   	 String Application=TBL_LIST.get(i);
	                   	
	                   	  e1.setApplication(Application);	
	                   	  	
	                   	 i++;
	                   	 
	                   	 String SCD_NON_SCD=TBL_LIST.get(i);
	                   	
	                   	  e1.setSCD_NON_SCD(SCD_NON_SCD);	
	                   	  
	                   	 i++;
	                   	  
	                 	 String SK_NOT_SK=TBL_LIST.get(i);
	                 	
	                   	  e1.setSK_NOT_SK(SK_NOT_SK);	
	                   	    
	                   	 i++;
	                   	  
	                   	 String RI_NOT_RI=TBL_LIST.get(i);
	                   	
	                   	  e1.setRI_NOT_RI(RI_NOT_RI);	
	                   	
	                   	 i++;
	                   	  
	                   	String RI_col=TBL_LIST.get(i);
	                   	
	                   	  e1.setRI_col(RI_col);	
	                   	 
	                   	 i++;
	                   	 
	                   	String Code_Logic_Scenario=TBL_LIST.get(i);
	                   	
	                   	  e1.setCode_Logic_Scenario(Code_Logic_Scenario);	
	                   	 
	                   	 i++;
	                   	 
	                   	String Views=TBL_LIST.get(i);
	                   	
	                   	  e1.setViews(Views);	
	                   	 
	                   	 i++;
	                   	 
	                 	String Status=TBL_LIST.get(i);
		                   
	                   	  e1.setStatus(Status);	
	                   	 i++;
	                   	 
	                     	String Ref_Table=TBL_LIST.get(i);
	                     	
		                   	  e1.setRef_Table(Ref_Table);	
		                   	 i++;			                   	  
		                   	  
		                   
		                   	  
		                   	String PI=TBL_LIST.get(i);
		                   	
		                   	
		                   	  e1.setPI(PI);	
		                   	
		                   	 i++; 
		                   	  
		                     String PPI=TBL_LIST.get(i);
		                    
			                 e1.setPPI(PPI);	
			                
			                 i++;	  
			                   	  
			                  String Key_Columns=TBL_LIST.get(i);
			                  
				              e1.setKey_Columns(Key_Columns);	
				             
				              i++;    	  
				             String Tier_2_Target_Table_Logical_Name=TBL_LIST.get(i);
				             
					         e1.setTier_2_Target_Table_Logical_Name(Tier_2_Target_Table_Logical_Name);	
					         
					         i++;				        
					         
					         String Tier_2_Target_Column_Logical_Name=TBL_LIST.get(i);
					         e1.setTier_2_Target_Column_Logical_Name(Tier_2_Target_Column_Logical_Name);	
					       
					         i++;
					         
					         String Tier_2_Target_Table_Physical_Name=TBL_LIST.get(i);
					         e1.setTier_2_Target_Table_Physical_Name(Tier_2_Target_Table_Physical_Name);	
					        
					         i++;
					         String Tier_2_Target_Column_Physical_Name=TBL_LIST.get(i);
					         e1.setTier_2_Target_Column_Physical_Name(Tier_2_Target_Column_Physical_Name);	
					         i++;
					         
					         
					         String Owner=TBL_LIST.get(i);
					         e1.setOwner(Owner);	
					         i++;
					         
					         String Tier_2_Data_Type=TBL_LIST.get(i);
					         e1.setTier_2_Data_Type(Tier_2_Data_Type);	
					         i++;
					         
					         String Tier_1_Source_Table=TBL_LIST.get(i);
					         e1.setTier_1_Source_Table(Tier_1_Source_Table);	
					         i++;
					         
					         String Tier_1_Source_Column=TBL_LIST.get(i);
					         e1.setTier_1_Source_Column(Tier_1_Source_Column);	
					        
					         i++;
					         String Business_Logic_Column_Level=TBL_LIST.get(i);
					         e1.setBusiness_Logic_Column_Level(Business_Logic_Column_Level);	
					         
					         i++;
					         String Business_Logic_Row_Level=TBL_LIST.get(i);
					         e1.setBusiness_Logic_Row_Level(Business_Logic_Row_Level);	
					         
					         i++;
					         String Table_column_change_detail=TBL_LIST.get(i);
					         e1.setTable_column_change_detail(Table_column_change_detail);	
					         i++;
					         	                   	  
	                   	  Col_DtlFromExcel.add(e1);
	                   	  b++;
	                   	 
	                   	  
		                	
	                  }
	                 file.close(); 
	                 Connection con=null;
	                 con = ConnectionMgt.getConnectionObject();
	     			
	     			String sql;	 
	     			int i=0;
	     			
	     			for (DataMapUpload COLINST : Col_DtlFromExcel){
	     				sql= "insert into datamapping_T2(ETL_LYR,Subject_Area ,Phase_1 ,Application ,SCD_NON_SCD ,SK_NOT_SK ,RI_NOT_RI ,RI_col ,Code_Logic_Scenario ,views,Ref_Table ,Status ,PI ,PPI ,Key_Columns ,Tier_2_Table_Logical_Name ,Tier_2_Column_Logical_Name ,Tier_2_Table_Physical_Name ,Tier_2_Column_Physical_Name ,owners,Tier_2_Data_Type ,Tier_1_Source_Table ,Tier_1_Source_Column ,Business_Logic_Column_Level ,Business_Logic_Row_Level,TABLE_COLUMN_CHANGE_DETAIL,insrt_ts,FILENAME ) " +
	    						"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'MM-DD-YYYY HH24:MI:SS'),?)";
	     				
	    				stmt = con.prepareStatement(sql);
	    				DateFormat df = new SimpleDateFormat("MM-dd-YYYY HH:mm:ss");
	    				Calendar calobj = Calendar.getInstance();
	    				String insrt_ts=df.format(calobj.getTime());
	    				System.out.println(insrt_ts);

	    				stmt.setString(1, COLINST.getETL_LYR ());
	    				stmt.setString(2, COLINST.getSubject_Area ());
	    				stmt.setString(3, COLINST.getPhase_1 ());
	    				stmt.setString(4, COLINST.getApplication ());
	    				stmt.setString(5, COLINST.getSCD_NON_SCD ());
	    				stmt.setString(6, COLINST.getSK_NOT_SK ());
	    				stmt.setString(7, COLINST.getRI_NOT_RI ());
	    				stmt.setString(8, COLINST.getRI_col ());
	    				stmt.setString(9, COLINST.getCode_Logic_Scenario ());
	    				stmt.setString(10, COLINST.getViews ());
	    				stmt.setString(11, COLINST.getRef_Table ());
	    				stmt.setString(12, COLINST.getStatus ());
	    				stmt.setString(13, COLINST.getPI ());
	    				stmt.setString(14, COLINST.getPPI ());
	    				stmt.setString(15, COLINST.getKey_Columns ());
	    				stmt.setString(16, COLINST.getTier_2_Target_Table_Logical_Name ());
	    				stmt.setString(17, COLINST.getTier_2_Target_Column_Logical_Name ());
	    				stmt.setString(18, COLINST.getTier_2_Target_Table_Physical_Name ());
	    				stmt.setString(19, COLINST.getTier_2_Target_Column_Physical_Name ());
	    				stmt.setString(20, COLINST.getOwner());
	    				stmt.setString(21, COLINST.getTier_2_Data_Type ());
	    				stmt.setString(22, COLINST.getTier_1_Source_Table ());
	    				stmt.setString(23, COLINST.getTier_1_Source_Column ());
	    				stmt.setString(24, COLINST.getBusiness_Logic_Column_Level ());
	    				stmt.setString(25, COLINST.getBusiness_Logic_Row_Level ());
	    				stmt.setString(26, COLINST.getTable_column_change_detail ());
	    				stmt.setString(27, insrt_ts);
	    				stmt.setString(28, Filename);
	    				i++;
	    				System.out.println(i+":"+COLINST.getTier_2_Target_Column_Physical_Name ());
	    				stmt.execute();
	    				
	    				
	    				 
	    				 
	    				 
	    				stmt.close();
	    				
	     			}
	     			
	     			 sql="MERGE INTO tbl_dtl TGT"+ 
	     					" USING" +
	     					" (select " +
	     					"PHASE_1" +
	     					",APPLICATION" +
	     					",TIER_2_TABLE_LOGICAL_NAME" +
	     					",TIER_2_TABLE_PHYSICAL_NAME" +
	     					",VIEWS" +
	     					",ETL_LYR" +
	     					",BUSINESS_LOGIC_ROW_LEVEL" +
	     					",TABLE_COLUMN_CHANGE_DETAIL" +
	     					",CODE_LOGIC_SCENARIO" +
	     					",OWNERS" +
	     					",SYSTIMESTAMP" +
	     					",SUBJECT_AREA" +
	     					"    from " +
	     					"  (" +
	     					"  SELECT distinct" +
	     					" max(PHASE_1) PHASE_1" +
	     					",max(APPLICATION) APPLICATION" +
	     					",max(TIER_2_TABLE_LOGICAL_NAME) TIER_2_TABLE_LOGICAL_NAME" +
	     					",max(TIER_2_TABLE_PHYSICAL_NAME) TIER_2_TABLE_PHYSICAL_NAME" +
	     					",max(VIEWS) VIEWS" +
	     					",max(ETL_LYR) ETL_LYR" +
	     					",max(to_char(BUSINESS_LOGIC_ROW_LEVEL)) BUSINESS_LOGIC_ROW_LEVEL" +
	     					",max(TABLE_COLUMN_CHANGE_DETAIL) TABLE_COLUMN_CHANGE_DETAIL" +
	     					",max(CODE_LOGIC_SCENARIO) CODE_LOGIC_SCENARIO" +
	     					",'I'" +
	     					",max(OWNERS) OWNERS" +
	     					",max(SUBJECT_AREA) SUBJECT_AREA" +
	     					" FROM datamapping_T2 group by TIER_2_TABLE_LOGICAL_NAME " +
	     					"  ) a ) src" +
	     					"  " +
	     					"  ON (tgt.LOGIC_TBL_NM = src.TIER_2_TABLE_LOGICAL_NAME)" +
	     					" WHEN MATCHED THEN" +
	     					" UPDATE SET " +
	     					"                tgt.PH_VERS_ID = src.PHASE_1" +
	     					"                ,tgt.SRC = src.APPLICATION" +
	     					"                ,tgt.TBL_OWN = src.OWNERS" +
	     					"                ,tgt.PHYS_TBL_NM = src.TIER_2_TABLE_PHYSICAL_NAME" +
	     					"                ,tgt.VW_IND = src.VIEWS" +
	     					"                ,tgt.ETL_LYR = src.ETL_LYR" +
	     					"                ,tgt.ROW_QRY = src.BUSINESS_LOGIC_ROW_LEVEL                " +
	     					"                ,tgt.TBL_SGNFC = src.TABLE_COLUMN_CHANGE_DETAIL                " +
	     					"                ,tgt.LD_SCNRO = src.CODE_LOGIC_SCENARIO" +
	     					"                ,tgt.ACT_TYP = 'U'" +
	     					"                ,tgt.ACT_USR = src.OWNERS" +
	     					"                ,tgt.ACT_TS = SYSTIMESTAMP" +
	     					"                ,tgt.SA_DESC = src.SUBJECT_AREA" +
	     					"  WHEN NOT MATCHED THEN" +
	     					"        INSERT (TBL_ID,tgt.PH_VERS_ID,tgt.SRC,tgt.LOGIC_TBL_NM,tgt.TBL_OWN,tgt.PHYS_TBL_NM" +
	     					",tgt.VW_IND,tgt.ETL_LYR,tgt.ROW_QRY,tgt.TBL_SGNFC,tgt.LD_SCNRO" +
	     					",tgt.ACT_TYP,tgt.ACT_USR,tgt.ACT_TS,tgt.SA_DESC)" +
	     					"        VALUES (tbl_id.nextval,src.PHASE_1,src.APPLICATION,src.TIER_2_TABLE_LOGICAL_NAME,src.OWNERS,src.TIER_2_TABLE_PHYSICAL_NAME" +
	     					",src.VIEWS,src.ETL_LYR,src.BUSINESS_LOGIC_ROW_LEVEL,src.TABLE_COLUMN_CHANGE_DETAIL                " +
	     					",src.CODE_LOGIC_SCENARIO,'I',src.OWNERS,SYSTIMESTAMP,src.SUBJECT_AREA)" ;
	     			
	     			
	     			System.out.println(sql);
	     			
   				 stmt = con.prepareStatement(sql);
   				 stmt.execute();
   				
   				 
   				 sql="MERGE INTO col_dtl TGT" +
   						 " USING" +
   						 "  ( " +
   						 "  SELECT " +
   						 "  b.TBL_ID" +
   						 ",a.Tier_2_Column_Logical_Name" +
   						 ",a.Tier_2_Column_Physical_Name" +
   						 ",a.Tier_2_Data_Type" +
   						 ",a.Tier_1_Source_Table" +
   						 ",a.Tier_1_Source_Column" +
   						 ",a.Business_Logic_Column_Level" +
   						 ",a.Table_column_change_detail" +
   						 ",a.PI" +
   						 ",a.PPI" +
   						 ",A.KEY_COLUMNS" +
   						 ",A.SCD_NON_SCD" +
   						 ",A.RI_NOT_RI" +
   						 ",A.OWNERS" +
   						 " FROM datamapping_T2 a,tbl_dtl b where b.LOGIC_TBL_NM = a.TIER_2_TABLE_LOGICAL_NAME" +
   						 ") SRC" +
   						 " ON (tgt.TBL_ID = src.TBL_ID AND tgt.PHYS_COL_NM=src.Tier_2_Column_Physical_Name)" +
   						 " WHEN MATCHED THEN" +
   						 " UPDATE SET" +
   						 " tgt.LOGIC_COL_NM=src.Tier_2_Column_Logical_Name" +
   						 ",tgt.DATATYP=src.Tier_2_Data_Type" +
   						 ",tgt.SRC_TBL_NM=src.Tier_1_Source_Table" +
   						 ",tgt.SRC_COL_NM=src.Tier_1_Source_Column" +
   						 ",tgt.COL_BUS_LOGIC=src.Business_Logic_Column_Level" +
   						 ",tgt.COMT=src.Table_column_change_detail" +
   						 ",tgt.ACT_TYP='U'" +
   						 ",tgt.ACT_USR=src.OWNERS" +
   						 ",tgt.ACT_TS= SYSTIMESTAMP" +
   						 ",tgt.PI=src.PI" +
   						 ",tgt.PPI=src.PPI" +
   						 ",tgt.SCD_NON_SCD=src.SCD_NON_SCD" +
   						 ",TGT.RI_NOT_RI=src.RI_NOT_RI" +
   						 "  WHEN NOT MATCHED THEN" +
   						 "        INSERT (tgt.TBL_ID,tgt.col_id,tgt.LOGIC_COL_NM,tgt.PHYS_COL_NM,tgt.DATATYP,tgt.SRC_TBL_NM" +
   						 ",tgt.SRC_COL_NM,tgt.COL_BUS_LOGIC,tgt.COMT,tgt.ACT_TYP,tgt.ACT_USR" +
   						 ",tgt.ACT_TS,tgt.PI,tgt.PPI,tgt.SCD_NON_SCD,tgt.RI_NOT_RI)" +
   						 "        VALUES (src.tbl_id,col_id.nextval,src.Tier_2_Column_Logical_Name,src.Tier_2_Column_Physical_Name,src.Tier_2_Data_Type,src.Tier_1_Source_Table,src.Tier_1_Source_Column";
   				 
   				 
   				 stmt = con.prepareStatement(sql);
   				 stmt.execute();
   				 
   				 stmt.close();
   				 
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






