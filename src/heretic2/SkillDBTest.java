package heretic2;

import java.sql.Connection;
import java.sql.DriverManager;

@SuppressWarnings("unused")
public class SkillDBTest {
	public static void main( String args[] )
	{
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:skills.db");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}
}
