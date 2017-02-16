package dwMapMgmt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Actionloging extends HttpServlet {

String userid;
String password;
   //temp

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
		
		userid=request.getParameter("userid");
		password=request.getParameter("password");
		
		
		Connection con = null;
		try {
			con = ConnectionMgt.getConnectionObject();
			
			String sql="select userid,password from user_details where userid=? and password=?";
			PreparedStatement stmt = null;
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userid);
			stmt.setString(2, password);
			ResultSet rst =stmt.executeQuery();
			
			
			if(rst.next()){
				request.getRequestDispatcher("/Welcome.jsp").forward(
						request, response);
				HttpSession session = request.getSession(true);
				session.setAttribute("userid",userid);
				session.setAttribute("password",password);
				
			}else{
				request.getRequestDispatcher("/login.jsp").forward(
						request, response);
			}
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
