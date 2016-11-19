package heretic1;

public class SingleSkill {
	private String name;
	private int level;
	
	@Override
	public String toString(){
		return name+"--"+level;
	}

	public String getName(){return name;}
	public int getLevel(){return level;}
}
