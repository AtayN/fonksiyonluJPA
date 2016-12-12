package folder;

import java.sql.*;

public class connectionss {
	
	static Connection con=null;
	
	
	public static  Connection Jdbc ()
	{
		
		try { 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=company;user=sa;password=N1475369.a");
											
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
