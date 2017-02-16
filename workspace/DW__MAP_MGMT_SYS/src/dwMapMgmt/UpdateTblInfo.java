package dwMapMgmt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateTblInfo
 */
@WebServlet("/UpdateTblInfo")
public class UpdateTblInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateTblInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Tbl_Dtl obj1=new Tbl_Dtl();
		obj1.setTBL_ID(request.getParameter("TBL_ID"));
		obj1.setPH_VERS_ID(request.getParameter("PH_VERS_ID"));
		obj1.setSRC(request.getParameter("SRC"));	
		obj1.setTBL_OWN(request.getParameter("TBL_OWN"));
		obj1.setLOGIC_TBL_NM(request.getParameter("LOGIC_TBL_NM"));
		obj1.setPHYS_TBL_NM(request.getParameter("PHYS_TBL_NM"));
		obj1.setVW_IND(request.getParameter("VW_IND"));
		obj1.setETL_LYR(request.getParameter("ETL_LYR"));
		obj1.setROW_QRY(request.getParameter("ROW_QRY"));
		obj1.setTBL_SGNFC(request.getParameter("TBL_SGNFC"));
		obj1.setLD_SCNRO(request.getParameter("LD_SCNRO"));
		obj1.setSA_Desc(request.getParameter("SA_Desc"));
		boolean status=updTableInfo(obj1);
		
		  response.setContentType("text/html");
		   java.io.PrintWriter out = response.getWriter( );
		    
		     out.println("<html>");
		     out.println("<head>");
		     out.println("<title>Servlet upload</title>");  
		     out.println("</head>");
		     out.println("<body>");
		     if(status==true)
		     {
		     out.println("<p>Table Updated Successfully !!</p>");
		     HttpSession session = request.getSession(false);
		     	out.println((String)session.getAttribute("userid"));
				out.println((String)session.getAttribute("password"));
		     }
		     else
		     {
		    	 out.println("<p>Table Updated failes !!</p>");
		     }
		     out.println("</body>");
		     out.println("</html>");
		     return;
		/*request.getRequestDispatcher("/UpdateTableInfoStart.jsp").forward(
				request, response);*/
		
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String requestComingFrom = request.getParameter("pagefrom");
		//System.out.println(requestComingFrom);
		//if (requestComingFrom.equals("onloadpage")) {
			List<String> TBL_LIST = new ArrayList<String>();
			TBL_LIST = getTableNames();
			List<String> ent_typ_ref = new ArrayList<String>();
			ent_typ_ref=getent_typ_ref();
			request.setAttribute("TBL_LIST", TBL_LIST);
			request.setAttribute("ent_typ_ref", ent_typ_ref);
			request.setAttribute("selectedTableDetails", new Tbl_Dtl());

			Map<String, String> tableDetailsForEachTable = new HashMap<String, String>();
			List<Tbl_Dtl> tableDetails = new ArrayList<Tbl_Dtl>();
			ViewTblInfo viewTblObject = new ViewTblInfo();
			tableDetails = viewTblObject.getAllTableDetails();

			for (Tbl_Dtl tblDet : tableDetails) {
				String commmaSeparatedTableInfo = "";
				commmaSeparatedTableInfo = tblDet.toString();
				tableDetailsForEachTable.put(tblDet.getLOGIC_TBL_NM(),
						commmaSeparatedTableInfo);
				System.out.println(commmaSeparatedTableInfo);
												
			}
			
			request.setAttribute("TBL_LIST_DETAILS", tableDetailsForEachTable);

			request.getRequestDispatcher("/UpdateTableInfo.jsp").forward(
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
	
	
	
	// Get all table names for drop down field
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

	
	public boolean updTableInfo(Tbl_Dtl TBL_INFO) {
		
		Connection con = null;
		String sql = "update TBL_DTL set PH_VERS_ID=?,SRC=?,TBL_OWN=?,LOGIC_TBL_NM=?," +
				"PHYS_TBL_NM=?,VW_IND=?,ETL_LYR=?,ROW_QRY=?,TBL_SGNFC=?,LD_SCNRO=?,SA_Desc=? where TBL_ID=?";
		try {

			con = ConnectionMgt.getConnectionObject();
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, TBL_INFO.getPH_VERS_ID());
			stmt.setString(2, TBL_INFO.getSRC());
			stmt.setString(3,TBL_INFO.getTBL_OWN());
			stmt.setString(4,TBL_INFO.getLOGIC_TBL_NM());
			stmt.setString(5,TBL_INFO.getPHYS_TBL_NM());
			stmt.setString(6,TBL_INFO.getVW_IND());
			stmt.setString(7,TBL_INFO.getETL_LYR());
			stmt.setString(8,TBL_INFO.getROW_QRY());
			stmt.setString(9,TBL_INFO.getTBL_SGNFC());
			stmt.setString(10,TBL_INFO.getLD_SCNRO());
			stmt.setString(11,TBL_INFO.getSA_Desc());
			stmt.setString(12,TBL_INFO.getTBL_ID());
			stmt.execute();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


	}

}
