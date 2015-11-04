package tasklog.kz.epam.task;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.xml.DOMConfigurator;

import tasklog.kz.epam.task.system.Prepare;
import tasklog.kz.epam.task.system.read.Read;
import tasklog.kz.epam.task.system.read.AllLinesReader;
import tasklog.kz.epam.task.system.write.FileRecorder;
import tasklog.kz.epam.task.system.write.ConsoleRecorder;
import tasklog.kz.epam.task.text.SimpleSentence;
import tasklog.kz.epam.task.text.Symbol;
import tasklog.kz.epam.task.text.Text;
import tasklog.kz.epam.task.text.Word;


public class App {
	
	public static final Logger LOG=Logger.getLogger(App.class.toString());
	
	public static void main(String[] args)  {
		List<Word> palindrome = new ArrayList<Word>();
		DOMConfigurator.configure("./log4j.xml");
		//ввод, завязан на интерфейсе
		Read reading = new Read();
		reading.setStrategy(new AllLinesReader());
		Path path = Paths.get("./test.txt");
		reading.readFile(path);
		Prepare prepare = new Prepare();
		List<String> textFile = reading.readFile(path);
		Text text = new Text(prepare.findProposal(textFile));
		//вывод, завязан на интерфейсе
		FileRecorder write = new FileRecorder();
		write.setStrategy(new ConsoleRecorder());
		write.readFile(text.toString());
		//Vivod
		//Нужно переопределять equals и hashcode
		Pattern forSymbol = Pattern.compile("[\\S*]");
		Word word = new Word(findSymbols2(forSymbol,"лепс спел"));
		System.out.println(word.palindrome());
		for (SimpleSentence simpleSentence : text){
			for (Word words : simpleSentence){
				if (words.palindrome()){
					palindrome.add(words);
					System.out.println(palindrome.toString());
				} else {
					palindrome.clear();
				}
			}
		}
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