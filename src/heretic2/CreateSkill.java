package heretic2;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.google.gson.Gson;

public class CreateSkill {
	public static void main(String[] args) throws IOException {
		Gson gson = new Gson();
		Reader reader = new FileReader("res/skills/Titanomachia.json");
		
		Skill skill = gson.fromJson(reader, Skill.class);
		reader.close();
		System.out.println(skill.sql());
		
		Connection c = null;
		Statement stmt = null;
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:skills.db");
			System.out.println("Opened database successfully");
			
			stmt = c.createStatement();
			String sql = skill.sql();
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
