package heretic2;

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
	
	public String sql(){
		return "INSERT INTO SKILLS (nameJP,nameEN,attr,cost,power,hits,kuli,hit,targ,str,effect) "+
				"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	}
}
