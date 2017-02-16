package dwMapMgmt;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class ViewColInfoAll extends HttpServlet {

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

	public List<TblCol_Dtl> getAllColDetails() {
		List<TblCol_Dtl> TBL_LIST = new ArrayList<TblCol_Dtl>();
		Connection con = null;
		String sql;
		try {

			con = ConnectionMgt.getConnectionObject();
			sql = "select a.*,b.COL_ID,b.LOGIC_COL_NM,b.PHYS_COL_NM," +
					"b.DATATYP,b.SRC_TBL_NM,b.SRC_COL_NM,b.COL_BUS_LOGIC,b.COMT,b.PI,b.PPI,b.KEY_COLUMNS,b.SCD_NON_SCD,b.RI_NOT_RI from tbl_dtl a  left join col_dtl b on a.tbl_id=b.tbl_id";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			ResultSet rst = stmt.executeQuery();
			while (rst.next()) {
				TblCol_Dtl TBL_DESC = new TblCol_Dtl();

				TBL_DESC.setTBL_ID(rst.getString("TBL_ID"));
				TBL_DESC.setPHYS_TBL_NM(rst.getString("PHYS_TBL_NM"));
				TBL_DESC.setCOL_ID(rst.getString("COL_ID"));
				TBL_DESC.setLOGIC_COL_NM(rst.getString("LOGIC_COL_NM"));
				TBL_DESC.setPHYS_COL_NM(rst.getString("PHYS_COL_NM"));
				TBL_DESC.setDATATYP(rst.getString("DATATYP"));
				TBL_DESC.setSRC_TBL_NM(rst.getString("SRC_TBL_NM"));
				TBL_DESC.setSRC_COL_NM(rst.getString("SRC_COL_NM"));
				TBL_DESC.setCOL_BUS_LOGIC(rst.getString("COL_BUS_LOGIC"));
				TBL_DESC.setCOMT(rst.getString("COMT"));
				TBL_DESC.setPH_VERS_ID(rst.getString("PH_VERS_ID"));
				TBL_DESC.setSRC(rst.getString("SRC"));
				TBL_DESC.setTBL_OWN(rst.getString("TBL_OWN"));
				TBL_DESC.setLOGIC_TBL_NM(rst.getString("LOGIC_TBL_NM"));
				TBL_DESC.setVW_IND(rst.getString("VW_IND"));
				TBL_DESC.setETL_LYR(rst.getString("ETL_LYR"));
				TBL_DESC.setROW_QRY(rst.getString("ROW_QRY"));
				TBL_DESC.setTBL_SGNFC(rst.getString("TBL_SGNFC"));
				TBL_DESC.setLD_SCNRO(rst.getString("LD_SCNRO"));
				TBL_DESC.setSA_Desc(rst.getString("SA_Desc"));
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
			List<TblCol_Dtl> colDetails = new ArrayList<TblCol_Dtl>();
			ViewColInfoAll viewColObject = new ViewColInfoAll();
			colDetails = viewColObject.getAllColDetails();

			for (TblCol_Dtl colDet : colDetails) {
				String commmaSeparatedTableInfo = "";
				if(!tableDetailsForEachTable.containsKey(colDet.getLOGIC_TBL_NM()))
				{
				commmaSeparatedTableInfo = colDet.toStringExp();
				tableDetailsForEachTable.put(colDet.getLOGIC_TBL_NM(),commmaSeparatedTableInfo);
				}
				else
				{
					commmaSeparatedTableInfo = tableDetailsForEachTable.get(colDet.getLOGIC_TBL_NM())+"||||"+colDet.toStringExp();
					tableDetailsForEachTable.put(colDet.getLOGIC_TBL_NM(),commmaSeparatedTableInfo);
				}
			
				System.out.println(colDet.toStringExp());
			}
			 
			request.setAttribute("TBL_LIST_DETAILS", tableDetailsForEachTable);
			request.getRequestDispatcher("/ViewTableColumnsInfoAll.jsp").forward(
					request, response);
		//} else {
			
//		}
		// TODO Auto-generated method stub
	}
	
	// Get all table names for drop down field
	public List<String> getTableNames() {
		List<String> TBL_LIST = new ArrayList<String>();
		Connection con = null;
		String sql = "select LOGIC_TBL_NM  from TBL_DTL";
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
