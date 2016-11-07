package heretic1;

public class Stats {
	private int hp;
	private int mp;
	private int strength;
	private int skill;
	private int magic;
	private int speed;
	private int luck;
	
	@Override
	public String toString(){
		
		String output = String.format("====| hp  | mp  | str | skl | mag | spd | lck |\n"
									+ "====-------------------------------------------\n"
									+ "====| %3d | %3d | %3d | %3d | %3d | %3d | %3d |", hp, mp, strength, skill, magic, speed, luck);
		return output;
	}
}
