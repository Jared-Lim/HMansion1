package heretic2;

import java.io.File;

public class FolderParse {
	public static void main(String[] args) {
		File directory = new File("res/skills/");
		String[] files = directory.list();
		for(String f:files){
			String g = "res/skills/"+f;
			System.out.println(g);
		}
	}
}
