package heretic4;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;

import com.google.gson.Gson;

public class DBStuff {
	
	private static String db = "jdbc:sqlite:heretic2.db";
	private static String skillsFold = "res/skills/";
	
	public static void main(String[] args) {
		makeSkillsTable();
		parseSkillsFolder();
	}
	
	public static Connection connectDB(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(db);
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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

	public static void parseSkillsFolder(){
		Gson gson = new Gson();
		File directory = new File(skillsFold);
		String[] files = directory.list();
		try(Connection conn = connectDB()){
			for(String f:files){
				String g = skillsFold+f;
				try(Reader reader = new FileReader(g)){
					Skill skill = gson.fromJson(reader, Skill.class);
					skill.Insert(conn, db);
					System.out.println("Inserted "+skill.check());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());;
		}
	}
	
	
}
