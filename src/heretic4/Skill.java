package heretic4;

import java.sql.*;

public class Skill {
	public String nameJP;
	public String nameEN;
	public String attribute;
	public int cost;
	public String power;
	public String hits;
	public String kuli;
	public String hit;
	public String target;
	public int strengthen;
	public String effect;
	
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
	
	public void Insert(Connection conn, String db){
		String sql = "INSERT INTO skills (nameJP,nameEN,attr,cost,power,hits,kuli,hit,targ,str,effect) "+
				"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement pstate = conn.prepareStatement(sql)){
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
		}catch(SQLException e){
			System.out.println(e.getMessage());;
		}
	}
}
