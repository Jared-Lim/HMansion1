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
		try(Connection conn = connectDB()){
			makeSkillsTable(conn);
			parseSkillsFolder(conn);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
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
	
	public static void makeSkillsTable(Connection conn){
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
		
		try(PreparedStatement pstate = conn.prepareStatement(sql)){
			pstate.executeUpdate();
			System.out.println("Created skills table");
		}catch(SQLException e){
			System.out.println(e.getMessage());;
		}
	}

	public static void parseSkillsFolder(Connection conn){
		Gson gson = new Gson();
		File directory = new File(skillsFold);
		String[] files = directory.list();
		for(String f:files){
			String g = skillsFold+f;
			try(Reader reader = new FileReader(g)){
				Skill skill = gson.fromJson(reader, Skill.class);
				insertSkill(conn,skill);
				System.out.println("Inserted "+skill.check());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void insertSkill(Connection conn,Skill skill){
		String sql = "INSERT INTO skills (nameJP,nameEN,attr,cost,power,hits,kuli,hit,targ,str,effect) "+
				"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement pstate = conn.prepareStatement(sql)){
			pstate.setString(1, skill.nameJP);
			pstate.setString(2, skill.nameEN);
			pstate.setString(3, skill.attribute);
			pstate.setInt(4, skill.cost);
			pstate.setString(5, skill.power);
			pstate.setString(6, skill.hits);
			pstate.setString(7, skill.kuli);
			pstate.setString(8, skill.hit);
			pstate.setString(9, skill.target);
			pstate.setInt(10, skill.strengthen);
			pstate.setString(11, skill.effect);
			pstate.executeUpdate();
		}catch(SQLException e){
			System.out.println(e.getMessage());;
		}
		
	}
}
