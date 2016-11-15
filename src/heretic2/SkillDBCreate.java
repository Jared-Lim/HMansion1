package heretic2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SkillDBCreate {
	public static void main( String args[] )
	{
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:skills.db");
			System.out.println("Opened database successfully");
			
			stmt = c.createStatement();
			String sql = 	"CREATE TABLE SKILLS ("+
			
						    "nameJP STRING PRIMARY KEY,"+
							"nameEN STRING,"+
							"attr STRING,"+
							"cost INT,"+
							"power STRING,"+
							"hits STRING,"+
							"kuli STRING,"+
							"hit STRING,"+
							"targ STRING,"+
							"str INT,"+
							"effect STRING)";
			
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();			
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	    System.out.println("Table created successfully");
	}
}
