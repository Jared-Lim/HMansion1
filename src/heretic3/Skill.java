package heretic3;

import java.sql.*;

public class Skill {
	private String nameJP;
	private String nameEN;
	private String attribute;
	private int cost;
	private String power;
	private String hits;
	private String kuli;
	private String hit;
	private String target;
	private int strengthen;
	private String effect;
	
	@Override
	public String toString(){
		return 	"nameJP:  	"+nameJP+"\n"+
				"nameEN: 	"+nameEN+"\n"+
				"attr:     	"+attribute+"\n"+
				"cost:    	"+cost+"\n"+
				"power:	  	"+power+"\n"+
				"hits:	  	"+hits+"\n"+
				"kuli:	  	"+kuli+"\n"+
				"hit:	  	"+hit+"\n"+
				"targ:  	"+target+"\n"+
				"str:	  	"+strengthen+"\n"+
				"effect:\n	"+effect;
	}
	
	public String check(){
		return nameEN+"-----"+nameJP;
	}
	
	public void Insert(String db) throws SQLException{
		Connection conn = null;
		PreparedStatement pstate = null;
		String sql = "INSERT INTO SKILLS (nameJP,nameEN,attr,cost,power,hits,kuli,hit,targ,str,effect) "+
				"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		conn = DriverManager.getConnection(db);
		
		pstate = conn.prepareStatement(sql);
		pstate.setString(1, nameJP);
		pstate.setString(2, nameEN);
		pstate.setString(3, attribute);
		pstate.setInt(4, cost);
		pstate.setString(5, power);
		pstate.setString(6, hits);
		pstate.setString(7, kuli);
		pstate.setString(8, hit);
		pstate.setString(9, target);
		pstate.setInt(10, strengthen);
		pstate.setString(11, effect);
		pstate.executeUpdate();
		
		System.out.println("Inserted "+check());
	}
}
