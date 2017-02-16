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
public class ColumnImpactAnalysis extends HttpServlet {

	private String PHYS_TBL_NM;
	private String PHYS_COL_NM;
	private String ETL_LYR;
	private String SRC_TBL_NM;
	private String SRC_COL_NM;
	private String SRC_ETL_LYR;
	private String COL_BUS_LOGIC;
	private String SRC1_TBL_NM;
	private String SRC1_COL_NM;
	private String SRC1_ETL_LYR;
	private String SRC_COL_BUS_LOGIC;
	

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

	public String getETL_LYR() {
		return ETL_LYR;
	}

	public void setETL_LYR(String eTL_LYR) {
		ETL_LYR = eTL_LYR;
	}

	public String getSRC_TBL_NM() {
		return SRC_TBL_NM;
	}

	public void setSRC_TBL_NM(String sRC_TBL_NM) {
		SRC_TBL_NM = sRC_TBL_NM;
	}

	public String getSRC_COL_NM() {
		return SRC_COL_NM;
	}

	public void setSRC_COL_NM(String sRC_COL_NM) {
		SRC_COL_NM = sRC_COL_NM;
	}

	public String getSRC_ETL_LYR() {
		return SRC_ETL_LYR;
	}

	public void setSRC_ETL_LYR(String sRC_ETL_LYR) {
		SRC_ETL_LYR = sRC_ETL_LYR;
	}

	public String getSRC1_TBL_NM() {
		return SRC1_TBL_NM;
	}

	public void setSRC1_TBL_NM(String sRC1_TBL_NM) {
		SRC1_TBL_NM = sRC1_TBL_NM;
	}

	public String getSRC1_COL_NM() {
		return SRC1_COL_NM;
	}

	public void setSRC1_COL_NM(String sRC1_COL_NM) {
		SRC1_COL_NM = sRC1_COL_NM;
	}

	public String getSRC1_ETL_LYR() {
		return SRC1_ETL_LYR;
	}

	public void setSRC1_ETL_LYR(String sRC1_ETL_LYR) {
		SRC1_ETL_LYR = sRC1_ETL_LYR;
	}

	
	public String getCOL_BUS_LOGIC() {
		return COL_BUS_LOGIC;
	}

	public void setCOL_BUS_LOGIC(String cOL_BUS_LOGIC) {
		COL_BUS_LOGIC = cOL_BUS_LOGIC;
	}

	public String getSRC_COL_BUS_LOGIC() {
		return SRC_COL_BUS_LOGIC;
	}

	public void setSRC_COL_BUS_LOGIC(String sRC_COL_BUS_LOGIC) {
		SRC_COL_BUS_LOGIC = sRC_COL_BUS_LOGIC;
	}

	@Override
	public String toString() {
		return PHYS_TBL_NM + "|" + PHYS_COL_NM + "|" + ETL_LYR + "|"
				+ SRC_TBL_NM + "|" + SRC_COL_NM + "|" + COL_BUS_LOGIC + "|"+SRC_ETL_LYR + "|"
				+ SRC1_TBL_NM + "|" + SRC1_COL_NM + "|" + SRC_COL_BUS_LOGIC + "|" + SRC1_ETL_LYR;
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

	public List<ColumnImpactAnalysis> getAllColDetails() {
		List<ColumnImpactAnalysis> TBL_LIST = new ArrayList<ColumnImpactAnalysis>();
		Connection con = null;
		String sql;
		try {

			con = ConnectionMgt.getConnectionObject();
			sql = "SELECT A.PHYS_TBL_NM,A.PHYS_COL_NM,A.ETL_LYR,B.PHYS_TBL_NM SRC_TBL_NM, "
					+ "B.PHYS_COL_NM SRC_COL_NM,A.COL_BUS_LOGIC COL_BUS_LOGIC,B.ETL_LYR SRC_ETL_LYR,C.PHYS_TBL_NM SRC1_TBL_NM, "
					+ "C.PHYS_COL_NM SRC1_COL_NM,B.COL_BUS_LOGIC SRC_COL_BUS_LOGIC,C.ETL_LYR SRC1_ETL_LYR " +
							"FROM TBL_COL_DTL A LEFT JOIN TBL_COL_DTL B "
					+ "ON A.SRC_TBL_NM=B.PHYS_TBL_NM AND A.SRC_COL_NM=B.PHYS_COL_NM "
					+ "LEFT JOIN  TBL_COL_DTL C "
					+ "ON B.SRC_TBL_NM=C.PHYS_TBL_NM AND B.SRC_COL_NM=C.PHYS_COL_NM";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			ResultSet rst = stmt.executeQuery();
			while (rst.next()) {
				ColumnImpactAnalysis TBL_DESC = new ColumnImpactAnalysis();

				TBL_DESC.setPHYS_TBL_NM(rst.getString("PHYS_TBL_NM"));
				TBL_DESC.setPHYS_COL_NM(rst.getString("PHYS_COL_NM"));
				TBL_DESC.setETL_LYR(rst.getString("ETL_LYR"));
				TBL_DESC.setSRC_TBL_NM(rst.getString("SRC_TBL_NM"));
				TBL_DESC.setSRC_COL_NM(rst.getString("SRC_COL_NM"));
				TBL_DESC.setCOL_BUS_LOGIC(rst.getString("COL_BUS_LOGIC"));
				TBL_DESC.setSRC_ETL_LYR(rst.getString("SRC_ETL_LYR"));
				TBL_DESC.setSRC1_TBL_NM(rst.getString("SRC1_TBL_NM"));
				TBL_DESC.setSRC1_COL_NM(rst.getString("SRC1_COL_NM"));
				TBL_DESC.setSRC_COL_BUS_LOGIC(rst.getString("SRC_COL_BUS_LOGIC"));
				TBL_DESC.setSRC1_ETL_LYR(rst.getString("SRC1_ETL_LYR"));
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
		List<ColumnImpactAnalysis> colDetails = new ArrayList<ColumnImpactAnalysis>();
		ColumnImpactAnalysis viewColObject = new ColumnImpactAnalysis();
		colDetails = viewColObject.getAllColDetails();

		for (ColumnImpactAnalysis colDet : colDetails) {
			String commmaSeparatedTableInfo = "";
			if (!tableDetailsForEachTable.containsKey(colDet.getPHYS_TBL_NM())) {
				commmaSeparatedTableInfo = colDet.toString();
				tableDetailsForEachTable.put(colDet.getPHYS_TBL_NM(),
						commmaSeparatedTableInfo);
			} else {
				commmaSeparatedTableInfo = tableDetailsForEachTable.get(colDet
						.getPHYS_TBL_NM()) + "~" + colDet.toString();
				tableDetailsForEachTable.put(colDet.getPHYS_TBL_NM(),
						commmaSeparatedTableInfo);
			}

			// System.out.println(tableDetailsForEachTable.get(colDet.getPHYS_TBL_NM()));
		}
		for (Map.Entry<String, String> e : tableDetailsForEachTable.entrySet()) {
			System.out.println(e.getKey()+"           "+e.getValue());
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
		String sql = "select PHYS_TBL_NM  from TBL_DTL";
		try {

			con = ConnectionMgt.getConnectionObject();
			sql = "select * from tbl_dtl";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			ResultSet rst = stmt.executeQuery();
			while (rst.next()) {
				TBL_LIST.add(rst.getString("PHYS_TBL_NM"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return TBL_LIST;

	}
}
