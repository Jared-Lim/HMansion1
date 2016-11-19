package heretic1;

public class SingleSkill {
	public String name;
	public int level;
	
	public void setName(String name){this.name = name;}
	public void setLevel(int level){this.level=level;}
	
	public String getName(){return name;}
	public int getLevel(){return level;}
	
	@Override
	public String toString(){
		return name+"--"+level;
	}
}