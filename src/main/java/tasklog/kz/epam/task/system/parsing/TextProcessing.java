package tasklog.kz.epam.task.system.parsing;

import java.util.List;
import java.util.regex.Pattern;

public class TextProcessing {
	private Parsing parsing;
	
	public void setStrategy(Parsing parsing) {
        this.parsing = parsing;
    }
	
	public List<String> readFile (Pattern findPattern, String lines) {
		return parsing.parsing(findPattern, lines);
    }
}
