package heretic3;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;

public class InsertSkills {
	public static void main(String[] args) throws Exception{
		Gson gson = new Gson();
		File directory = new File("res/skills/");
		String[] files = directory.list();
		
		for(String f:files){
			String g = "res/skills/"+f;
			Reader reader = new FileReader(g);
			Skill skill = gson.fromJson(reader, Skill.class);
			reader.close();
			
			System.out.println(skill.check());
		}
	}
}
