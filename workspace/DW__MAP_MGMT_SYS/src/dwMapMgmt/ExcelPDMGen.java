package dwMapMgmt;


import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

 import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

   import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dwMapMgmt.DataMapUpload;

/**
 * Servlet implementation class ExcelPDMGen
 */

public class ExcelPDMGen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	  private boolean isMultipart;
	   private String filePath="C:\\Users\\shivaba\\Downloads\\";
	  private int maxFileSize = 1000 * 1024;
	   private int maxMemSize = 1000 * 1024;
	   private File file ;
	   private String TIER;
	   private String TABLE_TYPE;
	   private String PHYS_TBL_NM;
	   private String PHYS_COL_NM;
	   private String DATA_TYP;
	   private String PI;
	   
	   
	   
    public String getTIER() {
		return TIER;
	}

	public void setTIER(String tIER) {
		TIER = tIER;
	}

	public String getTABLE_TYPE() {
		return TABLE_TYPE;
	}

	public void setTABLE_TYPE(String tABLE_TYPE) {
		TABLE_TYPE = tABLE_TYPE;
	}

	public String getPHYS_TBL_NM() {
		return PHYS_TBL_NM;
	}

	public void setPHYS_TBL_NM(String pHYS_TBL_NM) {
		PHYS_TBL_NM = pHYS_TBL_NM;
	}

	public String getPHYS_COL_NM() {
		return PHYS_COL_NM;
	}

	public void setPHYS_COL_NM(String pHYS_COL_NM) {
		PHYS_COL_NM = pHYS_COL_NM;
	}

	public String getDATA_TYP() {
		return DATA_TYP;
	}

	public void setDATA_TYP(String dATA_TYP) {
		DATA_TYP = dATA_TYP;
	}

	public String getPI() {
		return PI;
	}

	public void setPI(String pI) {
		PI = pI;
	}

	public ExcelPDMGen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 public void doPost(HttpServletRequest request, 
	           HttpServletResponse response)
	          throws ServletException, java.io.IOException {
	  // Check that we have a file upload request
	     isMultipart = ServletFileUpload.isMultipartContent(request);
	     
	     System.out.println(request.getParameterNames());
	     
	   

	     response.setContentType("text/html");
	     java.io.PrintWriter out = response.getWriter( );
	      if( !isMultipart ){
	     out.println("<html>");
	     out.println("<head>");
	     out.println("<title>Servlet upload</title>");  
	     out.println("</head>");
	     out.println("<body>");
	     out.println("<p>No file uploaded</p>"); 
	     out.println("</body>");
	     out.println("</html>");
	     return;
	     }
	     DiskFileItemFactory factory = new DiskFileItemFactory();
	  // maximum size that will be stored in memory
	     factory.setSizeThreshold(maxMemSize);
	  // Location to save data that is larger than maxMemSize.
	     factory.setRepository(new File("C:\\Users\\shivaba\\Downloads\\"));  

	  // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	  // maximum file size to be uploaded.
	     upload.setSizeMax( maxFileSize );

	     try{ 
	  // Parse the request to get file items.
	     List fileItems = upload.parseRequest(request);
	    
	     // Process the uploaded file items
	      Iterator i = fileItems.iterator();

	     out.println("<html>");
	     out.println("<head>");
	     out.println("<title>Servlet upload</title>");  
	     out.println("</head>");
	     out.println("<body>");
	     while ( i.hasNext () ) 
	     {
	       FileItem fi = (FileItem)i.next();
	     if ( !fi.isFormField () )  
	     {
	        // Get the uploaded file parameters
	        String fieldName = fi.getFieldName();
	        String fileName = fi.getName();
	        System.out.println(fileName);
	        String contentType = fi.getContentType();
	        boolean isInMemory = fi.isInMemory();
	        long sizeInBytes = fi.getSize();
	        // Write the file
	        if( fileName.lastIndexOf("\\") >= 0 ){
	           file = new File( filePath + 
	           fileName.substring( fileName.lastIndexOf("\\"))) ;
	        }else{
	           file = new File( filePath + 
	           fileName.substring(fileName.lastIndexOf("\\")+1)) ;
	        }
	        
	        
	        
	        fi.write( file ) ;
	             
	        String Filename=filePath+fileName.substring( fileName.lastIndexOf("\\"));
	        
	        if(Filename.contains("TERADATA")){
	        	ExcdbUploadTD(filePath+fileName.substring( fileName.lastIndexOf("\\")),fileName.substring( fileName.lastIndexOf("\\")));
	        }
	        else{	        
	        ExcdbUpload(filePath+fileName.substring( fileName.lastIndexOf("\\")),fileName.substring( fileName.lastIndexOf("\\")));
	        }
	        out.println("Uploaded Filename: " + fileName + "<br>");
	     }
	      }
	     out.println("</body>");
	          out.println("</html>");
	     }catch(Exception ex) {
	     System.out.println(ex);
	     }
	       }
	 
	 
	 
	 public void ExcdbUpload(String Filename,String PDM_TAG) {
			
			PreparedStatement stmt = null;
			 
			try {
				
				 
				
		           FileInputStream file = new FileInputStream(Filename); 
		           //Get the workbook instance for XLS file
		           XSSFWorkbook workbook = new XSSFWorkbook(file);     
		           //Get first sheet from the workbook     
		           XSSFSheet sheet = workbook.getSheetAt(0);           
		           //Iterate through each rows from first sheet     
		           java.util.Iterator<Row> rowIterator = sheet.iterator();  
		           List<ExcelPDMGen> Col_DtlFromExcel = new ArrayList<ExcelPDMGen>();
		       int b=1;
		       
		       System.out.println(sheet.getLastRowNum());
		       
		           while( rowIterator.hasNext()) {
		        	   		String a="";
		        	   		List<String> TBL_LIST = new ArrayList<String>();
		        	   		ExcelPDMGen e1=new ExcelPDMGen();
		        	   					
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
		                    	                    
		                           
		                    	                     
		                     
		                     int i=0;
		                     
		                     String TIER=TBL_LIST.get(i);
			                   	
		                   	  e1.setTIER(TIER);
		                   	  i++;
		                   	  
		                   	  String TABLE_TYPE=TBL_LIST.get(i);
			                   	
		                   	  e1.setTABLE_TYPE(TABLE_TYPE);
		                   	  i++;
		                     
		                     String PI=TBL_LIST.get(i);
			                   	
		                   	  e1.setPI(PI);
		                   	  i++;
		                   	  
		                     String PHYS_TBL_NM=TBL_LIST.get(i);
			                   	
		                   	  e1.setPHYS_TBL_NM(PHYS_TBL_NM);
		                   	  i++;
		                   	 
		                   	  String PHYS_COL_NM=TBL_LIST.get(i);
		                   	
		                   	  e1.setPHYS_COL_NM(PHYS_COL_NM);	
		                   	  
		                   	 i++;
		                   	  
		                   	 String DATA_TYP=TBL_LIST.get(i);
		                   	
		                   	  e1.setDATA_TYP(DATA_TYP);	
		                   	  	                  	
			                  	                
						         	                   	  
		                   	  Col_DtlFromExcel.add(e1);
		                   	  b++;
		                   	 
		                   	  
			                	
		                  }
		                 file.close(); 
		                 Connection con=null;
		                 con = ConnectionMgt.getConnectionObject();
		     			
		     			String sql;	
		    			sql="delete from  PDM_GEN_TEMP where TAG=?";
		    			stmt = null;
		    						
		    						stmt = con.prepareStatement(sql);
		    						stmt.setString(1,PDM_TAG);
		    						ResultSet rst = stmt.executeQuery();
		     			int i=0;
		     			
		     			for (ExcelPDMGen COLINST : Col_DtlFromExcel){
		     				sql= "insert into PDM_GEN_TEMP(TIER,TABLE_TYPE,PI,PHYS_TBL_NM,PHYS_COL_NM,DATA_TYP,insrt_ts,TAG ) " +
		    						"values(?,?,?,?,?,?,to_date(?,'MM-DD-YYYY HH24:MI:SS'),?)";
		     				
		    				stmt = con.prepareStatement(sql);
		    				DateFormat df = new SimpleDateFormat("MM-dd-YYYY HH:mm:ss");
		    				Calendar calobj = Calendar.getInstance();
		    				String insrt_ts=df.format(calobj.getTime());
		    				
		    				stmt.setString(1, COLINST.getTIER ());
		    				stmt.setString(2, COLINST.getTABLE_TYPE ());
		    				stmt.setString(3, COLINST.getPI ());
		    				stmt.setString(4, COLINST.getPHYS_TBL_NM ());
		    				stmt.setString(5, COLINST.getPHYS_COL_NM ());
		    				stmt.setString(6, COLINST.getDATA_TYP());
		    				stmt.setString(7, insrt_ts);
		    				stmt.setString(8,PDM_TAG);
		    				i++;
		    				
		    				stmt.execute();
		    				stmt.close();
		    				
		     			}
		     			
		     			PDMGen obj=new PDMGen();
		     			
		     			obj.pdmGEN(PDM_TAG);
		     			
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


	 public void ExcdbUploadTD(String Filename,String PDM_TAG) {
			
			PreparedStatement stmt = null;
			 
			try {
				
				 
				
		           FileInputStream file = new FileInputStream(Filename); 
		           //Get the workbook instance for XLS file
		           XSSFWorkbook workbook = new XSSFWorkbook(file);     
		           //Get first sheet from the workbook     
		           XSSFSheet sheet = workbook.getSheetAt(0);           
		           //Iterate through each rows from first sheet     
		           java.util.Iterator<Row> rowIterator = sheet.iterator();  
		           List<ExcelPDMGen> Col_DtlFromExcel = new ArrayList<ExcelPDMGen>();
		       int b=1;
		       
		       
		       
		           while( rowIterator.hasNext()) {
		        	   		String a="";
		        	   		List<String> TBL_LIST = new ArrayList<String>();
		        	   		ExcelPDMGen e1=new ExcelPDMGen();
		        	   					
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
		                    	                    
		                     
		                    	  
		                     int i=0;
		                     
		                     String TIER=TBL_LIST.get(i);
			                   	
		                   	  e1.setTIER(TIER);
		                   	  i++;
		                   	 
		                   	
		                   	  
		                   	String PHYS_COL_NM=TBL_LIST.get(i);
		                   	
		                    e1.setPHYS_COL_NM(PHYS_COL_NM);
		                    i++;
		                    
		                   	  String TABLE_TYPE=TBL_LIST.get(i);
			                   	
		                   	  e1.setTABLE_TYPE(TABLE_TYPE);
		                   	  i++;
		                     
		                     String PI=TBL_LIST.get(i);
			                   	
		                   	  e1.setPI(PI);
		                   	  
		                   	
		                   	
		                   	Col_DtlFromExcel.add(e1);
		                   	  b++;
		                   	 
		                   	  
		                   	  
			                	
		                  }
		                 file.close(); 
		                 Connection con=null;
		                 con = ConnectionMgt.getConnectionObject();
		     			
		     			String sql;	
		    			sql="delete from  PDM_GEN_TD_TEMP where TAG=?";
		    			stmt = null;
		    						
		    						stmt = con.prepareStatement(sql);
		    						stmt.setString(1,PDM_TAG);
		    						ResultSet rst = stmt.executeQuery();
		     			int i=0;
		     			
		     			for (ExcelPDMGen COLINST : Col_DtlFromExcel){
		     				sql= "insert into PDM_GEN_TD_TEMP(dbname,target_db,TAG,PHYS_TBL_NM,pdmgen_typ,insrt_ts) " +
		    						"values(?,?,?,?,?,to_date(?,'MM-DD-YYYY HH24:MI:SS'))";
		     				
		    				stmt = con.prepareStatement(sql);
		    				DateFormat df = new SimpleDateFormat("MM-dd-YYYY HH:mm:ss");
		    				Calendar calobj = Calendar.getInstance();
		    				String insrt_ts=df.format(calobj.getTime());
		    				
		    				stmt.setString(1, COLINST.getTIER ());
		    				stmt.setString(2, COLINST.getPHYS_COL_NM ());
		    				stmt.setString(3,PDM_TAG);
		    				stmt.setString(4, COLINST.getTABLE_TYPE ());
		    				stmt.setString(5, COLINST.getPI ());
		    				stmt.setString(6, insrt_ts);
		    				
		    				i++;
		    				
		    				stmt.execute();
		    				stmt.close();
		    				
		     			}
		     			
		     			PDMGen obj=new PDMGen();
		     			
		     			obj.pdmGENTD(PDM_TAG);
		     			
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
