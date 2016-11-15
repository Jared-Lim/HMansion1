package heretic3;

import java.sql.*;

public class CreateDB {
	
	private static String db = "jdbc:sqlite:heretic.db";
	
	public static void main(String[] args) {
		try {
			makeSkillsTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void makeSkillsTable() throws Exception{
		Connection conn = null;		
		PreparedStatement pstate = null;
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
		try{
			conn = DriverManager.getConnection(db);
			System.out.println("Opened database successfully");
			pstate = conn.prepareStatement(sql);
			pstate.executeUpdate();
			System.out.println("Created skills table");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			if(pstate!=null){pstate.close();}
			if(conn!=null){conn.close();}
		}
	}

	

}
