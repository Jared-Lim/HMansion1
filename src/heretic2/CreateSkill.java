package heretic2;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.google.gson.Gson;

public class CreateSkill {
	public static void main(String[] args) throws IOException {
		Gson gson = new Gson();
		Reader reader = new FileReader("res/skills/Titanomachia.json");
		
		Skill skill = gson.fromJson(reader, Skill.class);
		reader.close();
		
		Connection c = null;
		PreparedStatement stmt = null;
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:skills.db");
			System.out.println("Opened database successfully");
			String sql = "INSERT INTO SKILLS (nameJP,nameEN,attr,cost,power,hits,kuli,hit,targ,str,effect) "+
					"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			stmt = c.prepareStatement(sql);
			stmt = c.prepareStatement(sql);
			stmt.setString(1, skill.nameJP);
			stmt.setString(2, skill.nameEN);
			stmt.setString(3, skill.attribute);
			stmt.setInt(4, skill.cost);
			stmt.setString(5, skill.power);
			stmt.setString(6, skill.hits);
			stmt.setString(7, skill.kuli);
			stmt.setString(8, skill.hit);
			stmt.setString(9, skill.target);
			stmt.setInt(10, skill.strengthen);
			stmt.setString(11, skill.effect);
			stmt.executeUpdate();
			c.close();	
			
		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Records created successfully");
		
		
	}
}
