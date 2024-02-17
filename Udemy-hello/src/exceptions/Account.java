package exceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Account {
	
	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/";
		String user = "user";
		String password = "abcd";
		
		Connection conn = null;
		conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
	
	public void withdraw(int amount) throws SQLException {
		getConnection();
	}
}
