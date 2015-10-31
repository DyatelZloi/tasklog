package tasklog.kz.epam.task.system.parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordProcessor implements Parsing {

	@Override
	public List <String> parsing(Pattern findPattern, String lines) {
		List <String> returnList = new ArrayList <String>();
		Matcher matcher = findPattern.matcher(lines);
			while (matcher.find()) {
				returnList.add(matcher.group());
			}
		return returnList;
	}
	

}
