package tasklog.kz.epam.task;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import tasklog.kz.epam.task.system.Prepare;
import tasklog.kz.epam.task.system.Read;


public class App {
	
	public static final Logger LOG=Logger.getLogger(App.class.toString());
	
	public static void main(String[] args)  {
		DOMConfigurator.configure("./log4j.xml");
		Read reading = new Read();
		Path path = Paths.get("./test.txt");
		java.util.List<String> textFile = reading.readFile(path);
		Prepare.splitText(textFile);
	}
}
