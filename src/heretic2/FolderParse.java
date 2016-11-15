package heretic2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.gson.Gson;

public class FolderParse {
	public static void main(String[] args) throws IOException {
		Gson gson = new Gson();
		File directory = new File("res/skills/");
		String[] files = directory.list();
		
		Connection c = null;
		Statement stmt = null;
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:skills.db");
		}catch (Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Opened database successfully");
		
		try {
			stmt = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String f:files){
			String g = "res/skills/"+f;
			Reader reader = new FileReader(g);
			Skill skill = gson.fromJson(reader, Skill.class);
			reader.close();
			try{
				stmt.executeUpdate(skill.sql());
				System.out.println("inserted "+skill.check());
			}catch(Exception e){
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    System.exit(0);
			}
		}
		try{
			stmt.close();
			c.close();
		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
	}
}
