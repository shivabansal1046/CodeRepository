package dwMapMgmt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateTblInfo
 */
public class UpdateColInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateColInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		Enumeration paramNames = request.getParameterNames();
		// List<Col_Dtl> updatedColumnList = new ArrayList<Col_Dtl>();
		Col_Dtl currentCol = new Col_Dtl();

		Map<String, Col_Dtl> updatedCol = new HashMap<String, Col_Dtl>();
		while (paramNames.hasMoreElements()) {

			String paramName = (String) paramNames.nextElement();
			if (paramName.contains("COL_ID")) {
				currentCol = new Col_Dtl();
				currentCol.setCOL_ID(request.getParameter(paramName));
				currentCol.setCOL_BUS_LOGIC(request.getParameter(paramName
						.replace("COL_ID", "COL_BUS_LOGIC")));
				currentCol.setCOMT(request.getParameter(paramName.replace(
						"COL_ID", "COMT")));
				currentCol.setDATATYP(request.getParameter(paramName.replace(
						"COL_ID", "DATATYP")));
				currentCol.setLOGIC_COL_NM(request.getParameter(paramName
						.replace("COL_ID", "LOGIC_COL_NM")));
				currentCol.setPHYS_COL_NM(request.getParameter(paramName
						.replace("COL_ID", "PHYS_COL_NM")));
				// currentCol.setPHYS_TBL_NM(request.getParameter(paramName.replace("COL_ID",
				// "LOGIC_COL_NM")));
				currentCol.setSRC_COL_NM(request.getParameter(paramName
						.replace("COL_ID", "SRC_COL_NM")));
				currentCol.setSRC_TBL_NM(request.getParameter(paramName
						.replace("COL_ID", "SRC_TBL_NM")));
				currentCol.setTBL_ID(request.getParameter(paramName.replace(
						"COL_ID", "TBL_ID")));
				currentCol.setPI(request.getParameter(paramName.replace(
						"COL_ID", "PI")));
				currentCol.setPPI(request.getParameter(paramName.replace(
						"COL_ID", "PPI")));
				currentCol.setKEY_COLUMNS(request.getParameter(paramName.replace(
						"COL_ID", "KEY_COLUMNS")));
				currentCol.setSCD_NON_SCD(request.getParameter(paramName.replace(
						"COL_ID", "SCD_NON_SCD")));
				currentCol.setRI_NOT_RI(request.getParameter(paramName.replace(
						"COL_ID", "RI_NOT_RI")));
				updatedCol.put(request.getParameter(paramName), currentCol);
			}

		}

		// Original columns
		List<Col_Dtl> totalModifiedColumns = new ArrayList<Col_Dtl>();
		List<Col_Dtl> orginalColumnList = new ArrayList<Col_Dtl>();
		ViewColInfo viewColObject = new ViewColInfo();
		orginalColumnList = viewColObject.getAllColDetails();
		for (Col_Dtl col : orginalColumnList) {
			if(updatedCol.get(col.getCOL_ID())!=null){
			if (updatedCol.get(col.getCOL_ID()).getTBL_ID().equals(col.getTBL_ID())) {
				//if (updatedCol.get(col.getCOL_ID()).equals(col)) {
				Col_Dtl updatedColm = new Col_Dtl();
				updatedColm = updatedCol.get(col.getCOL_ID());
				if (!col.equals(updatedColm)) {
					totalModifiedColumns.add(updatedColm);
					updColInfo(updatedColm);
				}
			}
			}
		}
		request.getRequestDispatcher("/UpdateColInfoStart.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String requestComingFrom = request.getParameter("pagefrom");
		// System.out.println(requestComingFrom);
		// if (requestComingFrom.equals("onloadpage")) {
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
			if (!tableDetailsForEachTable.containsKey(colDet.getLOGIC_TBL_NM())) {
				commmaSeparatedTableInfo = colDet.toString();
				tableDetailsForEachTable.put(colDet.getLOGIC_TBL_NM(),
						commmaSeparatedTableInfo);
			} else {
				commmaSeparatedTableInfo = tableDetailsForEachTable.get(colDet
						.getLOGIC_TBL_NM()) + "#~#" + colDet.toString();
				tableDetailsForEachTable.put(colDet.getLOGIC_TBL_NM(),
						commmaSeparatedTableInfo);
			}

			// System.out.println(tableDetailsForEachTable.get(colDet
			// .getPHYS_TBL_NM()));
		}
		request.setAttribute("TBL_LIST_DETAILS", tableDetailsForEachTable);
		request.getRequestDispatcher("/UpdateColInfo.jsp").forward(request,
				response);
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

	public void updTableInfo(Tbl_Dtl TBL_INFO) {

		Connection con = null;
		String sql = "update TBL_DTL set PH_VERS_ID=?,SRC=?,TBL_OWN=?,LOGIC_TBL_NM=?,"
				+ "PHYS_TBL_NM=?,VW_IND=?,ETL_LYR=?,ROW_QRY=?,TBL_SGNFC=?,LD_SCNRO=?,SA_Desc=? where TBL_ID=?";
		try {

			con = ConnectionMgt.getConnectionObject();
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, TBL_INFO.getPH_VERS_ID());
			stmt.setString(2, TBL_INFO.getSRC());
			stmt.setString(3, TBL_INFO.getTBL_OWN());
			stmt.setString(4, TBL_INFO.getLOGIC_TBL_NM());
			stmt.setString(5, TBL_INFO.getPHYS_TBL_NM());
			stmt.setString(6, TBL_INFO.getVW_IND());
			stmt.setString(7, TBL_INFO.getETL_LYR());
			stmt.setString(8, TBL_INFO.getROW_QRY());
			stmt.setString(9, TBL_INFO.getTBL_SGNFC());
			stmt.setString(10, TBL_INFO.getLD_SCNRO());
			stmt.setString(11, TBL_INFO.getSA_Desc());
			stmt.setString(12, TBL_INFO.getTBL_ID());
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updColInfo(Col_Dtl COL_INFO) {
		Connection con = null;
		String sql = "update col_dtl set LOGIC_COL_NM=?,PHYS_COL_NM=?,DATATYP=?,SRC_TBL_NM=?,"
				+ "SRC_COL_NM=?,COL_BUS_LOGIC=?,COMT=?,PI=?,PPI=?,KEY_COLUMNS=?,SCD_NON_SCD=?,RI_NOT_RI=? where COL_ID=? and tbl_id =?";
		try {

			con = ConnectionMgt.getConnectionObject();
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, COL_INFO.getLOGIC_COL_NM());
			stmt.setString(2, COL_INFO.getPHYS_COL_NM());
			stmt.setString(3, COL_INFO.getDATATYP());
			stmt.setString(4, COL_INFO.getSRC_TBL_NM());
			stmt.setString(5, COL_INFO.getSRC_COL_NM());
			stmt.setString(6, COL_INFO.getCOL_BUS_LOGIC());
			stmt.setString(7, COL_INFO.getCOMT());
			stmt.setString(8, COL_INFO.getPI());
			stmt.setString(9, COL_INFO.getPPI());
			stmt.setString(10, COL_INFO.getKEY_COLUMNS());
			stmt.setString(11, COL_INFO.getSCD_NON_SCD());
			System.out.println("shiva:"+COL_INFO.getSCD_NON_SCD());
			stmt.setString(12, COL_INFO.getRI_NOT_RI());
			stmt.setString(13, COL_INFO.getCOL_ID());
			stmt.setString(14, COL_INFO.getTBL_ID());
			
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
