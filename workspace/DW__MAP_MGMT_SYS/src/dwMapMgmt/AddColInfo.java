package dwMapMgmt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddColInfo
 */
public class AddColInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddColInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public String getTableId( String LOGIC_TBL_NM) {
		String TBL_ID=null;
		Connection con = null;
		String sql = "select TBL_ID  from TBL_DTL where LOGIC_TBL_NM='"+LOGIC_TBL_NM+"'";
		try {

			con = ConnectionMgt.getConnectionObject();
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			ResultSet rst = stmt.executeQuery();
			while (rst.next()) {
				TBL_ID=rst.getString("TBL_ID");
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return TBL_ID;

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
		
		
		List<Col_Dtl> Col_DtlFromJsp = new ArrayList<Col_Dtl>();
		String tbl_id = null;

        //get data from jsp table

        Enumeration paramNames = request.getParameterNames();
        Connection con = null;
       
        while (paramNames.hasMoreElements()) 

        {
        	
        
       		 String paramName = (String) paramNames.nextElement();

              if (paramName.contains("LOGIC_TBL_NM")) {

            	  Col_Dtl e1 = new Col_Dtl();
            	  
            	  String LOGIC_TBL_NM=paramName.replace("LOGIC_TBL_NM", "LOGIC_TBL_NM");
            	  tbl_id=getTableId(request.getParameter(LOGIC_TBL_NM));

                    e1.setTBL_ID(tbl_id);

                    String LOGIC_COL_NM = paramName.replace("LOGIC_TBL_NM", "LOGIC_COL_NM");

                    e1.setLOGIC_COL_NM(request.getParameter(LOGIC_COL_NM));

                    String PHYS_COL_NM = paramName.replace("LOGIC_TBL_NM", "PHYS_COL_NM");

                    e1.setPHYS_COL_NM(request.getParameter(PHYS_COL_NM));
                    
                    String DATATYP = paramName.replace("LOGIC_TBL_NM", "DATATYP");

                    e1.setDATATYP(request.getParameter(DATATYP));
                    
                    String SRC_TBL_NM = paramName.replace("LOGIC_TBL_NM", "SRC_TBL_NM");

                    e1.setSRC_TBL_NM(request.getParameter(SRC_TBL_NM));
                    
                    String SRC_COL_NM = paramName.replace("LOGIC_TBL_NM", "SRC_COL_NM");

                    e1.setSRC_COL_NM(request.getParameter(SRC_COL_NM));
                    
                    String COL_BUS_LOGIC = paramName.replace("LOGIC_TBL_NM", "COL_BUS_LOGIC");

                    e1.setCOL_BUS_LOGIC(request.getParameter(COL_BUS_LOGIC));
                    
                    String COMT = paramName.replace("LOGIC_TBL_NM", "COMT");

                    e1.setCOMT(request.getParameter(COMT));

                    String PI = paramName.replace("LOGIC_TBL_NM", "PI");

                    e1.setPI(request.getParameter(PI));
                    
                    String PPI = paramName.replace("LOGIC_TBL_NM", "PPI");

                    e1.setCOMT(request.getParameter(PPI));
                    
                    String KEY_COLUMNS = paramName.replace("LOGIC_TBL_NM", "KEY_COLUMNS");

                    e1.setKEY_COLUMNS(request.getParameter(KEY_COLUMNS));
                    
                    String SCD_NON_SCD = paramName.replace("LOGIC_TBL_NM", "SCD_NON_SCD");

                    e1.setSCD_NON_SCD(request.getParameter(SCD_NON_SCD));
                    
                    String RI_NOT_RI = paramName.replace("LOGIC_TBL_NM", "RI_NOT_RI");

                    e1.setRI_NOT_RI(request.getParameter(RI_NOT_RI));




                    Col_DtlFromJsp.add(e1);

              }		
        	
        }
        
        addColDetl(Col_DtlFromJsp);
		request.getRequestDispatcher("/ModColInfo.jsp").forward(
				request, response);
		
	}
        
    public void addColDetl(List <Col_Dtl> obj){
    	
    	
    	Connection con = null;
		//List<Dept> departmentDetails = new ArrayList<Dept>();
		
		try {
			con = ConnectionMgt.getConnectionObject();
			
			String sql;
			
			
			//System.out.println(obj.size());
			for (Col_Dtl COLINST : obj){
				//System.out.println("inside for loop");
				sql= "insert into COL_DTL(TBL_ID,COL_ID,LOGIC_COL_NM,PHYS_COL_NM,DATATYP,SRC_TBL_NM,SRC_COL_NM,COL_BUS_LOGIC,COMT,PI,PPI,KEY_COLUMNS,SCD_NON_SCD,RI_NOT_RI,ACT_TYP,ACT_USR,ACT_TS) " +
						"values(?,col_id.nextval,?,?,?,?,?,?,?,?,?,?,?,?,'I','SHIVABA',systimestamp)";
				PreparedStatement stmt = null;
				stmt = con.prepareStatement(sql);
				stmt.setInt(1,Integer.parseInt(COLINST.getTBL_ID()));
				stmt.setString(2, COLINST.getLOGIC_COL_NM());
				stmt.setString(3,COLINST.getPHYS_COL_NM());
				stmt.setString(4,COLINST.getDATATYP());
				stmt.setString(5,COLINST.getSRC_TBL_NM());
				stmt.setString(6,COLINST.getSRC_COL_NM());
				stmt.setString(7,COLINST.getCOL_BUS_LOGIC());
				stmt.setString(8,COLINST.getCOMT());
				stmt.setString(9,COLINST.getPI());
				stmt.setString(10,COLINST.getPPI());
				stmt.setString(11,COLINST.getKEY_COLUMNS());
				stmt.setString(12,COLINST.getSCD_NON_SCD());
				stmt.setString(13,COLINST.getRI_NOT_RI());
				
				stmt.execute();
			}
				
			} catch (SQLException e) {
			
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    }

}
