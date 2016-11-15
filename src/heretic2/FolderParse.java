package heretic2;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.google.gson.Gson;

public class FolderParse {
	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();
		File directory = new File("res/skills/");
		String[] files = directory.list();
		
		Connection c = null;
		PreparedStatement pstmt = null;
		
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:skills.db");
		System.out.println("Opened database successfully");
		
		for(String f:files){
			String g = "res/skills/"+f;
			Reader reader = new FileReader(g);
			Skill skill = gson.fromJson(reader, Skill.class);
			reader.close();
			
			String sql = "INSERT INTO SKILLS (nameJP,nameEN,attr,cost,power,hits,kuli,hit,targ,str,effect) "+
					"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = c.prepareStatement(sql);
			pstmt.setString(1, skill.nameJP);
			pstmt.setString(2, skill.nameEN);
			pstmt.setString(3, skill.attribute);
			pstmt.setInt(4, skill.cost);
			pstmt.setString(5, skill.power);
			pstmt.setString(6, skill.hits);
			pstmt.setString(7, skill.kuli);
			pstmt.setString(8, skill.hit);
			pstmt.setString(9, skill.target);
			pstmt.setInt(10, skill.strengthen);
			pstmt.setString(11, skill.effect);
			pstmt.executeUpdate();
			
			System.out.println("Inserted "+skill.check());
		}
		pstmt.close();
		c.close();
	}
}
