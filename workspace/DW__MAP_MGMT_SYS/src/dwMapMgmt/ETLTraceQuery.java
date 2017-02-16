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
public class ETLTraceQuery extends HttpServlet {

	private String PHYS_TBL_NM;
	private String PHYS_COL_NM;
	
	private String TRACE_ROUTE;
	

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

	

	

	public String getTRACE_ROUTE() {
		return TRACE_ROUTE;
	}

	public void setTRACE_ROUTE(String tRACE_ROUTE) {
		TRACE_ROUTE = tRACE_ROUTE;
	}

	@Override
	public String toString() {
		return PHYS_TBL_NM + "~#~" + PHYS_COL_NM + "~#~" +TRACE_ROUTE ;
	}

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

	public List<ETLTraceQuery> getAllColDetails() {
		List<ETLTraceQuery> TBL_LIST = new ArrayList<ETLTraceQuery>();
		Connection con = null;
		String sql;
		try {

			con = ConnectionMgt.getConnectionObject();
			sql = "SELECT PHYS_TBL_NM,PHYS_COL_NM,TRACE_ROUTE FROM ETL_TRACE_PATH";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			ResultSet rst = stmt.executeQuery();
			while (rst.next()) {
				ETLTraceQuery TBL_DESC = new ETLTraceQuery();

				TBL_DESC.setPHYS_TBL_NM(rst.getString("PHYS_TBL_NM"));
				TBL_DESC.setPHYS_COL_NM(rst.getString("PHYS_COL_NM"));
				TBL_DESC.setTRACE_ROUTE(rst.getString("TRACE_ROUTE"));
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
		// System.out.println(requestComingFrom);
		// if (requestComingFrom.equals("onloadpage")) {
		List<String> TBL_LIST = new ArrayList<String>();
		TBL_LIST = getTableNames();
		request.setAttribute("TBL_LIST", TBL_LIST);
		request.setAttribute("selectedTableDetails", new Tbl_Dtl());

		Map<String, String> tableDetailsForEachTable = new HashMap<String, String>();
		List<ETLTraceQuery> colDetails = new ArrayList<ETLTraceQuery>();
		ETLTraceQuery viewColObject = new ETLTraceQuery();
		colDetails = viewColObject.getAllColDetails();

		for (ETLTraceQuery colDet : colDetails) {
			String commmaSeparatedTableInfo = "";
			if (!tableDetailsForEachTable.containsKey(colDet.getPHYS_TBL_NM())) {
				commmaSeparatedTableInfo = colDet.toString();
				tableDetailsForEachTable.put(colDet.getPHYS_TBL_NM(),
						commmaSeparatedTableInfo);
			} else {
				commmaSeparatedTableInfo = tableDetailsForEachTable.get(colDet
						.getPHYS_TBL_NM()) + "#~#" + colDet.toString();
				tableDetailsForEachTable.put(colDet.getPHYS_TBL_NM(),
						commmaSeparatedTableInfo);
			}

			// System.out.println(tableDetailsForEachTable.get(colDet.getPHYS_TBL_NM()));
		}
		

		request.setAttribute("TBL_LIST_DETAILS", tableDetailsForEachTable);
		request.getRequestDispatcher("/ETLTraceQuery.jsp").forward(request,
				response);
		// } else {

		// }
		// TODO Auto-generated method stub
	}

	// Get all table names for drop down field
	public List<String> getTableNames() {
		List<String> TBL_LIST = new ArrayList<String>();
		Connection con = null;
		String sql = "select LOGIC_TBL_NM  from TBL_DTL";
		try {

			con = ConnectionMgt.getConnectionObject();
			sql = "select * from tbl_dtl order by PHYS_TBL_NM";
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
