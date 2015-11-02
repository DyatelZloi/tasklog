package tasklog.kz.epam.task.text.create;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tasklog.kz.epam.task.text.SimpleSentence;
import tasklog.kz.epam.task.text.Symbol;
import tasklog.kz.epam.task.text.Text;
import tasklog.kz.epam.task.text.Unknown;
import tasklog.kz.epam.task.text.Word;

public class Creating implements Create {

	@Override
	public List<Object> create(List<String> lines, Pattern pattern, String name) {
		List<Object> returnList = new ArrayList <Object>();
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			Matcher matcher = pattern.matcher(line);
			while (matcher.find()) {
				switch(name){
				case "Word":
					returnList.add(new Word( matcher.group()));
					break;
				case "Symbol":
					returnList.add(new Symbol(matcher.group()));
					break;
				case "Proposal":
					returnList.add(new SimpleSentence(matcher.group()));
					break;
				case "Text":
					returnList.add(new Text(matcher.group()));
					break;
				default:
					returnList.add(new Unknown(matcher.group()));
				} 
			 }
		}
		return returnList;
	}
}
