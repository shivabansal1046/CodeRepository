package dwMapMgmt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionMgt {
	
	private static Properties properties=new Properties();
	private static String propertiesFileName = "C:\\shiva personal\\datamapping proj\\dwMAPMGMTConfigProperties.properties.txt";
	private static String userName;
	private static String password;
	private static String constr;

	@SuppressWarnings("unused")
	
	public ConnectionMgt()
	{
		
	}
	
	public  static Connection getConnectionObject() {
		
		Connection con = null;
		try {
			
			properties.load(new FileInputStream(propertiesFileName));
			userName = properties.getProperty("userName");
			password=properties.getProperty("password");
			constr=properties.getProperty("constr");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			con = DriverManager.getConnection(
				constr, userName, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	

	
	public  static Connection getConnectionObjectTD(String dbname) {
		
		
		
		

		Connection con = null;
		try {
			
			properties.load(new FileInputStream(propertiesFileName));
			
			userName = properties.getProperty("OLD_userNameTD");
			password=properties.getProperty("OLD_passwordTD");
			String OLD_TD_SERVER=properties.getProperty("OLD_TD_SERVER");
			String	NEW_TD_SERVER=properties.getProperty("NEW_TD_SERVER");
			String	OLD_TD_DBLIST=properties.getProperty("OLD_TD_DBLIST");
			String	NEW_TD_DBLIST=properties.getProperty("NEW_TD_DBLIST");
			String url = "jdbc:teradata://";
					
			if(NEW_TD_DBLIST.contains(dbname)){
				url=url+NEW_TD_SERVER+"/database="+dbname;
				userName = properties.getProperty("NEW_userNameTD");
				password=properties.getProperty("OLD_passwordTD");
			}
			else{
				url=url+OLD_TD_SERVER+"/database="+dbname;
			}
				
			url=url+",USER="+userName+",PASSWORD="+password;
			

			
			Class.forName("com.teradata.jdbc.TeraDriver");
			
			
			con = DriverManager.getConnection(url);
			System.out.println(" User " + userName + " connected.");
			System.out.println(url);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	
}
