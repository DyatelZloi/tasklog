package tasklog.kz.epam.task.system;

import java.nio.file.Path;
import java.util.regex.Pattern;
import tasklog.kz.epam.task.text.Word;

public class Prepare {

	 public static void splitText(java.util.List<String> lines){  
		 Pattern p3 = Pattern.compile("[(.)|(?)|(!)]");
	     for (int i = 0; i < lines.size(); i++) {
			String x = lines.get(i);
			String[] symbols = p3.split(x);
			for (String symbol : symbols){
			    System.out.println(new Word(symbol));
			}
		}   
	 } 
	 
	public static void printText(Read reading, Path path, java.util.List<String> lines){
		for (int i = 0; i < lines.size(); i++) {
			String x = lines.get(i);
			System.out.println(x);
		}
	}
}
