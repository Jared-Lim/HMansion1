package heretic2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;

public class FolderParse {
	public static void main(String[] args) throws IOException {
		File directory = new File("res/skills/");
		String[] files = directory.list();
		for(String f:files){
			String g = "res/skills/"+f;
			Gson gson = new Gson();
			Reader reader = new FileReader(g);
			Skill skill = gson.fromJson(reader, Skill.class);
			reader.close();
			System.out.println(skill.check());
		}
	}
}
