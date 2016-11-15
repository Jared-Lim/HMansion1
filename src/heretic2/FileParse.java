package heretic2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileParse {
	public static void main(String[] args) throws IOException {
		Reader readme = new FileReader("res/skills/Agi.json");
		BufferedReader buff = new BufferedReader(readme);
		String line;
		while((line = buff.readLine())!=null){
			System.out.println(line);
		}
		readme.close();
	}
}
