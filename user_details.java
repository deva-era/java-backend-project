package reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class user_details {
	static String name;
	static int bus_no;
	static Date date;

	user_details() throws ParseException {
		// TODO Auto-generated constructor stub
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter bus no: ");
		bus_no = scanner.nextInt();
		scanner.nextLine();
		System.out.print("enter yor name: ");
		name = scanner.next();
		System.out.print("Enter date DD-MM-YYYY:");
		String dates = scanner.next();

		java.util.Date utildate = simpleDateFormat.parse(dates);
		date=new Date(utildate.getTime());

	}

	void user_data() throws SQLException {
		String query = "insert into booking values(?,?,?)";
		Connection connection = db_connection.get_connection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, bus_no);
		preparedStatement.setDate(3, date);
		int data_enter = preparedStatement.executeUpdate();

	}
}
