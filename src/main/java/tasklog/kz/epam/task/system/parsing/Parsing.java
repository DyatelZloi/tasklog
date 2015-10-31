package tasklog.kz.epam.task.system.parsing;

import java.util.List;
import java.util.regex.Pattern;

public interface Parsing {

	public List<String> parsing(Pattern findPattern, String lines);
}
