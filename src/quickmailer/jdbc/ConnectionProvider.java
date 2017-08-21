package quickmailer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static String user="quickmailer";
	private static String password="quickmailer";
	
	public static Connection con=null;
	
	public static Connection getConnectivity() throws ClassNotFoundException, SQLException{
		
		if(con==null){
			
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
		return con;
		}
		
		return con;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println("connection mail gaya :"+getConnectivity());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

} 
