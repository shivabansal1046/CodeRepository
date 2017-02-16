package dwMapMgmt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AddTblInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<String> ent_typ_ref = new ArrayList<String>();
		ent_typ_ref=getent_typ_ref();
		
		request.setAttribute("ent_typ_ref", ent_typ_ref);
		request.setAttribute("selectedTableDetails", new Tbl_Dtl());
		
		request.getRequestDispatcher("/AddTblInfo.jsp").forward(
				request, response);
		
	}
	
		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		
		
		
		String	TBL_ID=request.getParameter("TBL_ID");
		String	PH_VERS_ID=request.getParameter("PH_VERS_ID");
		String	SRC=request.getParameter("SRC");	
		String	TBL_OWN=request.getParameter("TBL_OWN");
		String	LOGIC_TBL_NM=request.getParameter("LOGIC_TBL_NM");
		String	PHYS_TBL_NM=request.getParameter("PHYS_TBL_NM");
		String	VW_IND=request.getParameter("VW_IND");
		String	ETL_LYR=request.getParameter("ETL_LYR");
		String	ROW_QRY=request.getParameter("ROW_QRY");
		String	TBL_SGNFC=request.getParameter("TBL_SGNFC");
		String	LD_SCNRO=request.getParameter("LD_SCNRO");
		String	SA_Desc=request.getParameter("SA_Desc");

		Connection con = null;
		//List<Dept> departmentDetails = new ArrayList<Dept>();
		
		//System.out.println("shiva");

		try {
			con = ConnectionMgt.getConnectionObject();
			//System.out.println(con);
			String sql; 
			sql= "insert into TBL_DTL(TBL_ID,PH_VERS_ID,SRC,TBL_OWN,LOGIC_TBL_NM,PHYS_TBL_NM,VW_IND,ETL_LYR,ROW_QRY,TBL_SGNFC,LD_SCNRO,SA_Desc,ACT_TYP,ACT_USR,ACT_TS) " +
					"values(tbl_id.nextval,?,?,?,?,?,?,?,?,?,?,?,'I','SHIVABA',systimestamp)";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setString(1, PH_VERS_ID);
			stmt.setString(2, SRC);
			stmt.setString(3,TBL_OWN);
			stmt.setString(4,LOGIC_TBL_NM);
			stmt.setString(5,PHYS_TBL_NM);
			stmt.setString(6,VW_IND);
			stmt.setString(7,ETL_LYR);
			stmt.setString(8,ROW_QRY);
			stmt.setString(9,TBL_SGNFC);
			stmt.setString(10,LD_SCNRO);
			stmt.setString(11,SA_Desc);
			stmt.execute();
			
			request.getRequestDispatcher("/AddTblInfo.jsp").forward(
					request, response);
					
					
			
		} catch (SQLException e) {
			//System.out.println("reshma mittal");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
			
	public List<String> getent_typ_ref() {
		List<String> ent_typ_ref = new ArrayList<String>();
		Connection con = null;
		
		try {

			con = ConnectionMgt.getConnectionObject();
			String sql = "select ent_typ_nm||'|'||ent_typ_cat drop_dwn_val  from ent_typ_ref ";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			ResultSet rst = stmt.executeQuery();
			while (rst.next()) {
				ent_typ_ref.add(rst.getString("drop_dwn_val"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ent_typ_ref;

	}

	
	
}
