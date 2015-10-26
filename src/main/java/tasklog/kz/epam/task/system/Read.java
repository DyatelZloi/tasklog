package tasklog.kz.epam.task.system;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Read{
	
	//<a> файла как одной строки

	public java.util.List<String> readFile(Path filePath) { 
		java.util.List<String> text = null;
		try {
			text = Files.readAllLines(filePath, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
}

