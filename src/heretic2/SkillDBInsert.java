package heretic2;

import java.sql.*;

public class SkillDBInsert {
	public static void main(String[] args) {
		Connection c = null;
		Statement stmt = null;
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:skills.db");
			System.out.println("Opened database successfully");
			
			stmt = c.createStatement();
			String sql = 	"INSERT INTO SKILLS (nameJP,nameEN,attr) "+
							"VALUES ('ティタノマキア','Titanomachia','Physical');";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();	
			
		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}
}
