package tasklog.kz.epam.task.system.read;

import java.nio.file.Path;
import java.util.List;

public class Read  {
	private Reader read;
	
	public void setStrategy(Reader read) {
        this.read = read;
    }
	
	public List<String> readFile (Path filePath) {
		return read.readFile(filePath);
    }
}
