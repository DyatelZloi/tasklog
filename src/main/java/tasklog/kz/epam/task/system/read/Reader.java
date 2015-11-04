package tasklog.kz.epam.task.system.read;

import java.nio.file.Path;
import java.util.List;

public interface Reader {
	public List<String> readFile(Path filePath);
}
