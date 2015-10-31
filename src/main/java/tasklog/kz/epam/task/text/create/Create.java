package tasklog.kz.epam.task.text.create;

import java.util.List;
import java.util.regex.Pattern;

public interface Create {

	public List<Object> create(List<String> lines, Pattern pattern, String name);
}
