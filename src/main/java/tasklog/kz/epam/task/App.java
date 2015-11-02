package tasklog.kz.epam.task;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.xml.DOMConfigurator;

import tasklog.kz.epam.task.sorting.SortByIndex;
import tasklog.kz.epam.task.system.Prepare;
import tasklog.kz.epam.task.system.read.ReadFile;
import tasklog.kz.epam.task.system.read.RealAllLines;
import tasklog.kz.epam.task.system.write.WriteFile;
import tasklog.kz.epam.task.system.write.WriteToTheConsole;
import tasklog.kz.epam.task.text.Symbol;
import tasklog.kz.epam.task.text.Text;
import tasklog.kz.epam.task.text.Word;


public class App {
	
	public static final Logger LOG=Logger.getLogger(App.class.toString());
	
	public static void main(String[] args)  {
		DOMConfigurator.configure("./log4j.xml");
		//ввод, завязан на интерфейсе
		ReadFile reading = new ReadFile();
		reading.setStrategy(new RealAllLines());
		Path path = Paths.get("./test.txt");
		reading.readFile(path);
		Prepare prepare = new Prepare();
		List<String> textFile = reading.readFile(path);
		Text text = new Text(prepare.findProposal(textFile));
		//вывод, завязан на интерфейсе
		WriteFile write = new WriteFile();
		write.setStrategy(new WriteToTheConsole());
		write.readFile(text.toString());
		//Vivod
		//Нужно переопределять equals и hashcode
		Pattern forSymbol = Pattern.compile("[\\S*]");
		Word word = new Word(findSymbols2(forSymbol,"лепс спел"));
		System.out.println(word.toString());
		Word word3 = new Word(findSymbols2(forSymbol,"лепс спел"));
		Collections.sort(word3.getSymbols(), new SortByIndex());
		Word word2 = word3; 
		System.out.println(word.toString());
		boolean words = word.equals(word2);
		System.out.println(words);
	}

	private static List<Symbol> findSymbols2(Pattern forSymbol, String string) {
		// TODO Auto-generated method stub
		List <Symbol> returnList = new ArrayList <Symbol>();
		Pattern findPattern = Pattern.compile("[\\S*]");
		Matcher matcher = findPattern.matcher(string);
		while (matcher.find()) {
			 returnList.add(new Symbol(matcher.group().charAt(0)));
		}
		return returnList;
	}
}
