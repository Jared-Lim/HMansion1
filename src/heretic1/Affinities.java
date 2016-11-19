package heretic1;

public class Affinities {
	public String physical;
	public String gun;
	public String fire;
	public String ice;
	public String thunder;
	public String shock;
	public String banish;
	public String curse;
	public String bind;
	public String sleep;
	public String cold;
	public String confusion;
	public String poison;
	
	@Override
	public String toString(){
		return 	"phys  : "+physical+"\n"+
				"gun   : "+gun+"\n"+
				"fire  : "+fire+"\n"+
				"ice   : "+ice+"\n"+
				"thun  : "+thunder+"\n"+
				"shock : "+shock+"\n"+
				"banish: "+banish+"\n"+
				"curse : "+curse+"\n"+
				"bind  : "+bind+"\n"+
				"sleep : "+sleep+"\n"+
				"cold  : "+cold+"\n"+
				"confus: "+confusion+"\n"+
				"poison: "+poison;
	}

	public String getphy(){return physical;}
	public String getgun(){return gun;}
	public String getfir(){return fire;}
	public String getice(){return ice;}
	public String getthu(){return thunder;}
	public String getsho(){return shock;}
	public String getban(){return banish;}
	public String getcur(){return curse;}
	public String getbin(){return bind;}
	public String getsle(){return sleep;}
	public String getcol(){return cold;}
	public String getcon(){return confusion;}
	public String getpoi(){return poison;}
}
