package reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_connection {
	private static final String url = "jdbc:mysql://localhost:3306/java";
	private static final String username = "root";
	private static final String password = "open";
	
	public static Connection get_connection() throws SQLException {
		return DriverManager.getConnection(url,username,password);
	}
}
