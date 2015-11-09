package tasklog.kz.epam.task;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;


import tasklog.kz.epam.task.parsing.Parse;
import tasklog.kz.epam.task.system.write.ConsoleRecorder;
import tasklog.kz.epam.task.system.write.FileRecorder;
import tasklog.kz.epam.task.system.read.AllLinesReader;
import tasklog.kz.epam.task.system.read.Read;
import tasklog.kz.epam.task.text.Text;


public class App {
	
	public static final Logger LOG=Logger.getLogger(App.class.toString());
	
	public static void main(String[] args)  {

		//ввод, завязан на интерфейсе
		Read reading = new Read();
		reading.setStrategy(new AllLinesReader());
		Path path = Paths.get("./test.txt");
		reading.readFile(path);
		Parse prepare = new Parse();
		List<String> textFile = reading.readFile(path);
		Text text = new Text(prepare.findProposal(textFile));
		//вывод, завязан на интерфейсе
		FileRecorder write = new FileRecorder();
		write.setStrategy(new ConsoleRecorder());
		write.readFile(text.toString());
		//проверка на палиндром
		text.palindrome();
		write.readFile(text.sourceString());
	}
}