package dwMapMgmt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TblDataUpd
 */
@WebServlet("/TblDataUpd")
public class TblDataUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TblDataUpd() {
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
		
		List<Tbl_Dtl> TBL_LIST = new ArrayList<Tbl_Dtl>();
		String Tbl_Nm=request.getParameter("tableNm");
		TBL_LIST = getTaleNames(Tbl_Nm);
		request.setAttribute("TBL_LIST", TBL_LIST);
		request.getRequestDispatcher("/UpdateTableInfo.jsp").forward(request,
				response);
		// TODO Auto-generated method stub
	}

	//Get all table names for drop down field
	public List<Tbl_Dtl> getTaleNames( String Tbl_Nm)
	{
		List<Tbl_Dtl> TBL_LIST = new ArrayList<Tbl_Dtl>();
		Connection con = null;
		String sql ="select *  from TBL_DTL where PHYS_TBL_NM=Tbl_Nm";
        try{
       	 
       	 con = ConnectionMgt.getConnectionObject();
       	 PreparedStatement stmt = null;
       	 stmt= con.prepareStatement(sql);
       	 ResultSet rst = stmt.executeQuery();
   		 while(rst.next())
			{
   					
   			 Tbl_Dtl TBL_DESC=new Tbl_Dtl();
				
 			TBL_DESC.setTBL_ID(rst.getString("TBL_ID"));
 			TBL_DESC.setPH_VERS_ID(rst.getString("PH_VERS_ID"));
 			TBL_DESC.setSRC(rst.getString("SRC"));
 			TBL_DESC.setTBL_OWN(rst.getString("TBL_OWN"));
 			TBL_DESC.setLOGIC_TBL_NM(rst.getString("LOGIC_TBL_NM"));
 			TBL_DESC.setPHYS_TBL_NM(rst.getString("PHYS_TBL_NM"));
 			TBL_DESC.setVW_IND(rst.getString("VW_IND"));
 			TBL_DESC.setETL_LYR(rst.getString("ETL_LYR"));
 			TBL_DESC.setROW_QRY(rst.getString("ROW_QRY"));
 			TBL_DESC.setTBL_SGNFC(rst.getString("TBL_SGNFC"));
 			TBL_DESC.setLD_SCNRO(rst.getString("LD_SCNRO"));
 			TBL_DESC.setSA_Desc(rst.getString("SA_Desc"));
 			
 			TBL_LIST.add(TBL_DESC);
   			
			}
   		
		
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return TBL_LIST;
	
	}

	}


