package dwMapMgmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 

/**
 * Servlet implementation class PDMGen
 */

public class PDMGen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PDMGen() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}




	public static void pdmGEN(String PDM_TAG) {
		
		
		
		
		try {
 
			
			
			Connection con = null;
			con = ConnectionMgt.getConnectionObject();
			//System.out.println(con);
			String sql; 
			

			
			
			sql = "select  TIER,TABLE_TYPE,PHYS_TBL_NM,max(PHYS_TBL_NM) over(order by PHYS_TBL_NM rows between 1 following and 1 following) nex_tbl_nm ,PI,PHYS_COL_NM,PHYS_COL_NM||' '||DATA_TYP ||'' col_dtls from PDM_GEN_TEMP where TAG=? order by PHYS_TBL_NM,PI";
			
			PreparedStatement stmt = null;
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1,PDM_TAG);
			ResultSet rst = stmt.executeQuery();
			String PDM_FILE_NAME=PDM_TAG+"PDM.sql";
			File file = new File("C:\\soft dumps\\GEN_PDM\\"+PDM_FILE_NAME);
			// if file doesnt exists, then create it
						if (!file.exists()) {
							file.createNewFile();
						}
						
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			String tblnm="";
			int i=0;
			String PI="";
			while (rst.next()) {
				
				
				if (tblnm=="")
				{
					if(rst.getString("TABLE_TYPE").equals("GTT")){
						bw.write("\nCREATE GLOBAL TEMPORARY TABLE <");
					}
					else{
					bw.write("\nCREATE TABLE <");
					}
					bw.write(rst.getString("TIER"));
					bw.write(">.");
					bw.write(rst.getString("PHYS_TBL_NM"));
					bw.write("(\n");
					bw.write(rst.getString("col_dtls"));
					bw.write("\n");
					tblnm=rst.getString("PHYS_TBL_NM");
					if(! tblnm.equals(rst.getString("nex_tbl_nm"))){
						bw.write(")\n");
						bw.write("PRIMARY INDEX(");
						bw.write(PI);
						bw.write(")"); 
						if(rst.getString("TABLE_TYPE").equals("GTT")){
							bw.write("\n ON COMMIT PRESERVE ROWS;\n\n");
						}
						else{
							bw.write("\n;\n\n");
						}
								
						bw.write("REPLACE VIEW  <VW>."+tblnm+ " AS LOCKING ROW FOR ACCESS    SELECT * FROM   <"+ rst.getString("TIER")+">."+tblnm+";");
						bw.write("\n\n");
						
						tblnm="";
						i=0;
						PI="";
					}
					
					String PI1=rst.getString("PI");
					if(PI1.contains("P")){
						String PI_COL_NM=rst.getString("PHYS_COL_NM");
						if(PI.equals("")){
							PI=PI_COL_NM;
						}
						else		
						{
						PI=PI+","+	PI_COL_NM;
						}
						
					}
					i++;
					
				}
				else if(tblnm.equals(rst.getString("PHYS_TBL_NM")))
				{
					if(i>=1)
					{
					bw.write(",");
					}
					bw.write(rst.getString("col_dtls"));
					bw.write("\n");
					tblnm=rst.getString("PHYS_TBL_NM");
					String PI1=rst.getString("PI");
					if(PI1.contains("P")){
						String PI_COL_NM=rst.getString("PHYS_COL_NM");
						if(PI.equals("")){
							PI=PI_COL_NM;
						}
						else		
						{
						PI=PI+","+	PI_COL_NM;
						}
						
					}
					i++;
					
					if(! tblnm.equals(rst.getString("nex_tbl_nm"))){
						bw.write(")\n");
						bw.write("PRIMARY INDEX(");
						bw.write(PI);
						bw.write(")"); 
						if(rst.getString("TABLE_TYPE").equals("GTT")){
							bw.write("\n ON COMMIT PRESERVE ROWS;\n\n");
						}
						else{
							bw.write("\n;\n\n");
						}
								
						bw.write("REPLACE VIEW  <VW>."+tblnm+ " AS LOCKING ROW FOR ACCESS    SELECT * FROM   <"+ rst.getString("TIER")+">."+tblnm+";");
						bw.write("\n\n");
						
						tblnm="";
						i=0;
						PI="";
					}
					
				}
				
				
				
			}
 
			
			
			bw.close();
			
			
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void pdmGENTD(String PDM_TAG){
		try{
			
			
		
		Connection con=ConnectionMgt.getConnectionObject();
		String sql = "select * from PDM_GEN_TD_TEMP where TAG=?";
		PreparedStatement stmt = null;
		stmt = con.prepareStatement(sql);
		stmt.setString(1, PDM_TAG);
		ResultSet rst = stmt.executeQuery();
			
		File file = new File("C:\\soft dumps\\GEN_PDM\\"+PDM_TAG+"PDM.sql");
		// if file doesnt exists, then create it
					if (!file.exists()) {
						file.createNewFile();
					}
					
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		
		
		while(rst.next())
		{
			
		String PHYS_TBL_NM=rst.getString("PHYS_TBL_NM");
		String dbname=rst.getString("dbname");
		String TIER=dbname.substring(dbname.length()-2,dbname.length());
		String PDMGEN_TYP=rst.getString("PDMGEN_TYP");
		String target_db=rst.getString("target_db");
		
		Connection con1=ConnectionMgt.getConnectionObjectTD(target_db);
		bw.write("\n\r");
		bw.write("\n\r");
		String Helptbl="";
		if(PDMGEN_TYP.equalsIgnoreCase("DROP_CREATE")){
		sql = "help table "+target_db+"."+PHYS_TBL_NM;
		
		
		PreparedStatement stmt1 = null;
		stmt = con1.prepareStatement(sql);
		ResultSet rst1 = stmt.executeQuery();
		
		
		
		int i=0;
		while(rst1.next()){
			if(i==0){
				Helptbl=rst1.getString(1).replace(" ", "");
			}
			else{
				Helptbl=Helptbl+","+rst1.getString(1).replace(" ", "");	
			}
			i++;
		}
		
		}
		
		con1.close();
		
		if(PDMGEN_TYP.equalsIgnoreCase("VIEW")){
		sql = "show view "+dbname+"."+ PHYS_TBL_NM;
		}else{
			sql = "show table "+dbname+"."+ PHYS_TBL_NM;
		}
		Connection con2=ConnectionMgt.getConnectionObjectTD(dbname);
		stmt = null;
		stmt = con2.prepareStatement(sql);
		ResultSet rst2 = stmt.executeQuery();
		
		while(rst2.next()){
				
			if(PDMGEN_TYP.equalsIgnoreCase("DROP_CREATE")){
			bw.write("Create <WRK>.");
			bw.write(PHYS_TBL_NM);
			bw.write(" AS <");
			bw.write(TIER);
			bw.write(">.");
			bw.write(PHYS_TBL_NM);
			bw.write(" WITH DATA;");
			bw.write("\n\r");
			bw.write("\n\r");
			}
			if(PDMGEN_TYP.equalsIgnoreCase("EXISTING") || PDMGEN_TYP.equalsIgnoreCase("DROP_CREATE")){
			bw.write("DROP TABLE <");
			bw.write(TIER);
			bw.write(">.");
			bw.write(PHYS_TBL_NM);
			bw.write(";\n\r");
			}
			
			bw.write(rst2.getString(1).replace(dbname,"<"+TIER+">"));
			bw.write("\n\r");
			bw.write("\n\r");
			if(PDMGEN_TYP.equalsIgnoreCase("DROP_CREATE")){
			bw.write("insert into <");
			bw.write(TIER);
			bw.write(">.");
			bw.write(PHYS_TBL_NM);
			bw.write("(");
			bw.write(Helptbl);
			bw.write(")\n\r select ");
			bw.write(Helptbl);
			bw.write("\n\rFROM <WRK>.");
			bw.write(PHYS_TBL_NM+";");
			}
			
			bw.write("\n\r");
			bw.write("\n\r");
			if(! PDMGEN_TYP.equalsIgnoreCase("VIEW")){
			bw.write("REPLACE VIEW  <VW>."+PHYS_TBL_NM+ " AS LOCKING ROW FOR ACCESS    SELECT * FROM   <"+ TIER+">."+PHYS_TBL_NM+";");
			}
			bw.write("\n\n");
			
		con2.close();
			
		}
		
		}
		bw.close();
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
