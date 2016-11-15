package heretic2;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.google.gson.Gson;

public class FolderParse {
	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();
		File directory = new File("res/skills/");
		String[] files = directory.list();
		
		Connection c = null;
		Statement stmt = null;
		
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:skills.db");
		System.out.println("Opened database successfully");
		stmt = c.createStatement();
		
		for(String f:files){
			String g = "res/skills/"+f;
			Reader reader = new FileReader(g);
			Skill skill = gson.fromJson(reader, Skill.class);
			reader.close();
			
			stmt.executeUpdate(skill.sql());
		}
		stmt.close();
		c.close();
	}
}
