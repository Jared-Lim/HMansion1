package heretic2;

import java.io.File;

public class FolderParse {
	public static void main(String[] args) {
		File directory = null;
		
		directory = new File("res/skills/");
		
		String a = directory.getAbsolutePath();
		
		System.out.println(a);
		
		System.out.println(directory.isDirectory());
		String[] files = directory.list();
		for(String f:files){
			String g = "res/skills/"+f;
			System.out.println(g);
		}
	}
}
