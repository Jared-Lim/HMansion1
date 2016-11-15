package heretic2;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;

public class CreateSkill {
	public static void main(String[] args) throws IOException {
		Gson gson = new Gson();
		Reader reader = new FileReader("res/skills/Titanomachia.json");
		
		Skill skill = gson.fromJson(reader, Skill.class);
		reader.close();
		System.out.println(skill.sql());
		System.exit(0);
	}
}
