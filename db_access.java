package reservation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import com.mysql.cj.exceptions.RSAException;

public class db_access {
	//info
	public static void display_bus_info() throws SQLException {
		String quary = "select * from bus";
		Connection connection = db_connection.get_connection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(quary);
		while (resultSet.next()) {
			System.out.println("Bus no:" + resultSet.getInt(1));
			System.out.println("Bus name:" + resultSet.getString(2));
			System.out.println("Bus capacity:" + resultSet.getInt(3));
			System.out.println(resultSet.getBoolean(4) == true ? "Ac:Available" : "Ac:None");
			System.out.println("");
		}
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
		connection.close();
        
	}//capacity
	public int get_capacity(int id) throws SQLException {
		String quary="select capacity from bus where id="+id;
		Connection connection = db_connection.get_connection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(quary); 
		resultSet.next();
		return resultSet.getInt(1);
	}//count
	public int count_seats(int bus_no,Date date) throws SQLException, ParseException {
		String query="select count(bus_no=?) from booking where travel_date=?; ";
		Connection connection=db_connection.get_connection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1,bus_no);
		preparedStatement.setDate(2,date);
		ResultSet resultSet=preparedStatement.executeQuery();
		resultSet.next();
		return resultSet.getInt(1);
	}
}
