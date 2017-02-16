package dwMapMgmt;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import java.util.Enumeration;

import java.util.List;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import dwMapMgmt.ConnectionMgt;

import dwMapMgmt.Tbl_Dtl;

@SuppressWarnings("serial")
public class ViewColInfo extends HttpServlet {

	protected void doGet(HttpServletRequest request,

	HttpServletResponse response) throws ServletException, IOException {

		List<Tbl_Dtl> TBL_LIST = new ArrayList<Tbl_Dtl>();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><Body>");
		request.setAttribute("TBL_LIST", TBL_LIST);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/ViewTblInfo.jsp");
		rd.forward(request, response);

	}

	public List<Col_Dtl> getAllColDetails() {
		List<Col_Dtl> TBL_LIST = new ArrayList<Col_Dtl>();
		Connection con = null;
		String sql;
		try {

			con = ConnectionMgt.getConnectionObject();
			sql = "select  a.*,b.PHYS_TBL_NM,b.LOGIC_TBL_NM from col_dtl a inner join tbl_dtl b on a.tbl_id=b.tbl_id";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			ResultSet rst = stmt.executeQuery();
			while (rst.next()) {
				Col_Dtl TBL_DESC = new Col_Dtl();

				TBL_DESC.setTBL_ID(rst.getString("TBL_ID"));
				TBL_DESC.setPHYS_TBL_NM(rst.getString("PHYS_TBL_NM"));
				TBL_DESC.setLOGIC_TBL_NM(rst.getString("LOGIC_TBL_NM"));
				TBL_DESC.setCOL_ID(rst.getString("COL_ID"));
				TBL_DESC.setLOGIC_COL_NM(rst.getString("LOGIC_COL_NM"));
				TBL_DESC.setPHYS_COL_NM(rst.getString("PHYS_COL_NM"));
				TBL_DESC.setDATATYP(rst.getString("DATATYP"));
				TBL_DESC.setSRC_TBL_NM(rst.getString("SRC_TBL_NM"));
				TBL_DESC.setSRC_COL_NM(rst.getString("SRC_COL_NM"));
				TBL_DESC.setCOL_BUS_LOGIC(rst.getString("COL_BUS_LOGIC"));
				TBL_DESC.setCOMT(rst.getString("COMT"));
				TBL_DESC.setPI(rst.getString("PI"));
				TBL_DESC.setPPI(rst.getString("PPI"));
				TBL_DESC.setKEY_COLUMNS(rst.getString("KEY_COLUMNS"));
				TBL_DESC.setSCD_NON_SCD(rst.getString("SCD_NON_SCD"));
				TBL_DESC.setRI_NOT_RI(rst.getString("RI_NOT_RI"));
				TBL_LIST.add(TBL_DESC);
	
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return TBL_LIST;
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String requestComingFrom = request.getParameter("pagefrom");
		//System.out.println(requestComingFrom);
		//if (requestComingFrom.equals("onloadpage")) {
			List<String> TBL_LIST = new ArrayList<String>();
			TBL_LIST = getTableNames();
			
			
			request.setAttribute("TBL_LIST", TBL_LIST);
			request.setAttribute("selectedTableDetails", new Tbl_Dtl());

			Map<String, String> tableDetailsForEachTable = new HashMap<String, String>();
			List<Col_Dtl> colDetails = new ArrayList<Col_Dtl>();
			ViewColInfo viewColObject = new ViewColInfo();
			colDetails = viewColObject.getAllColDetails();

			for (Col_Dtl colDet : colDetails) {
				String commmaSeparatedTableInfo = "";
				if(!tableDetailsForEachTable.containsKey(colDet.getLOGIC_TBL_NM()))
				{
				commmaSeparatedTableInfo = colDet.toString();
				tableDetailsForEachTable.put(colDet.getLOGIC_TBL_NM(),commmaSeparatedTableInfo);
				}
				else
				{
					commmaSeparatedTableInfo = tableDetailsForEachTable.get(colDet.getLOGIC_TBL_NM())+"#~#"+colDet.toString();
					tableDetailsForEachTable.put(colDet.getLOGIC_TBL_NM(),commmaSeparatedTableInfo);
				}
			
				
				
			}
			
			for(Map.Entry<String,String> e : tableDetailsForEachTable.entrySet()){ 
		      System.out.println(e.getKey()+":"+e.getValue());
		      } 
			
			request.setAttribute("TBL_LIST_DETAILS", tableDetailsForEachTable);
			request.getRequestDispatcher("/ViewTableColumnsInfo.jsp").forward(
					request, response);
		//} else {
			
//		}
		// TODO Auto-generated method stub
	}
	
	// Get all table names for drop down field
	public List<String> getTableNames() {
		List<String> TBL_LIST = new ArrayList<String>();
		Connection con = null;
		String sql = "select LOGIC_TBL_NM  from TBL_DTL order by LOGIC_TBL_NM";
		try {

			con = ConnectionMgt.getConnectionObject();
			sql = "select * from tbl_dtl order by LOGIC_TBL_NM";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			ResultSet rst = stmt.executeQuery();
			while (rst.next()) {
				TBL_LIST.add(rst.getString("LOGIC_TBL_NM"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return TBL_LIST;

	}
}
