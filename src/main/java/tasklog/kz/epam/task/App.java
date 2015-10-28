package tasklog.kz.epam.task;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.apache.log4j.xml.DOMConfigurator;

import tasklog.kz.epam.task.system.Prepare;
import tasklog.kz.epam.task.system.Read;
import tasklog.kz.epam.task.text.Symbol;


public class App {
	
	public static final Logger LOG=Logger.getLogger(App.class.toString());
	
	public static void main(String[] args)  {
		DOMConfigurator.configure("./log4j.xml");
		Read reading = new Read();
		Path path = Paths.get("./test.txt");
		java.util.List<String> textFile = reading.readFile(path);
		Pattern configuringPattern = Pattern.compile(".");
		//Prepare.splitText(textFile, configuringPattern);
		//Prepare.splitting(configuringPattern);
		Prepare.findSymbols(".", textFile);
		//Prepare.findSymbol("\\S", textFile);
		Prepare.createWord(Prepare.findSymbols(".|,", textFile));
	}
}
