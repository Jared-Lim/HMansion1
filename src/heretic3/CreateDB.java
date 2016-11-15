package heretic3;

import java.sql.*;

public class CreateDB {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:sqlite:heretic.db");
		System.out.println("Opened database successfully");
	}
}
