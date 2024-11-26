package reservation;

import java.util.Scanner;

import javax.swing.LookAndFeel;

import java.nio.channels.NonReadableChannelException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class booking {
	booking() {
		System.out.println("press 1 to bus details");
		System.out.println("press 2 to Booking");
		System.out.println("press 3 to Exit");
		System.out.print("Enter:");
	}

	public static void main(String[] args) throws SQLException, ParseException {
		Scanner scanner = new Scanner(System.in);
		Loop: while (true) {
			booking booking = new booking();
			int choice = scanner.nextInt();
			if (choice == 1) {
				db_access.display_bus_info();
			} else if (choice == 2) {
				user_details user_details = new user_details();
				db_access db_access = new db_access();
				System.out.println(db_access.count_seats(user_details.bus_no, user_details.date));
				if (db_access.count_seats(user_details.bus_no, user_details.date) <db_access.get_capacity(user_details.bus_no)) {
					user_details.user_data();
					System.out.println("booking successfully");
				} else {
					System.out.println("booking not available in this date,Try another date");
				}
			} else if (choice == 3) {
				break Loop;
			} else {
				System.out.println("Invalide entry");
			}
		}
	}
}
