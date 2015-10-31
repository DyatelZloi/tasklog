package tasklog.kz.epam.task.system.read;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class RealAllLines implements Read {

	@Override
	public List<String> readFile(Path filePath) { 
		List<String> text = null;
		try {
			text = Files.readAllLines(filePath, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
}