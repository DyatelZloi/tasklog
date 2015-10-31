package tasklog.kz.epam.task.system.read;

import java.nio.file.Path;
import java.util.List;

public class ReadFile  {
	private Read read;
	
	public void setStrategy(Read read) {
        this.read = read;
    }
	
	public List<String> readFile (Path filePath) {
		return read.readFile(filePath);
    }
}
