package heretic4;

import java.sql.*;

public class MakeDB {
	
	private static String db = "jdbc:sqlite:heretic2.db";
	
	public static void main(String[] args) {
		makeSkillsTable();
	}
	
	public static Connection connectDB(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(db);
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
		}
		return conn;
	}
	
	public static void makeSkillsTable(){
		String sql ="CREATE TABLE skills ("+
				"nameJP STRING PRIMARY KEY,"+
				"nameEN STRING,"+
				"attr 	STRING,"+
				"cost 	INT,"+
				"power 	STRING,"+
				"hits 	STRING,"+
				"kuli 	STRING,"+
				"hit 	STRING,"+
				"targ 	STRING,"+
				"str 	INT,"+
				"effect STRING)";
		
		try(Connection conn = connectDB();
				PreparedStatement pstate = conn.prepareStatement(sql)){
			pstate.executeUpdate();
			System.out.println("Created skills table");
		}catch(SQLException e){
			System.out.println(e.getMessage());;
		}
	}

	

}
