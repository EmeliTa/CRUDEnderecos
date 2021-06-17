package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		String driver = "";
	    String user   = "";
	    String senha = "";
	    String url = "";
	    Connection con = null;
	    try
	    {
	        Class.forName(driver);
	        
	        con = (Connection) DriverManager.getConnection(url, user, senha);
	    
	    }
	    catch (ClassNotFoundException ex)
	    {
	        System.err.print(ex.getMessage());
	    } 
	    catch (SQLException e)
	    {
	        System.err.print(e.getMessage());
	    }
		return con;
}
}
