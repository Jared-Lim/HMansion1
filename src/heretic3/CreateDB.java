package heretic3;

import java.sql.*;

public class CreateDB {
	
	private static String db = "jdbc:sqlite:heretic.db";
	
	public static void main(String[] args) {
		try {
			table();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void table() throws Exception{
		Connection conn = null;
		conn = DriverManager.getConnection(db);
		System.out.println("Opened database successfully");
	}
}
