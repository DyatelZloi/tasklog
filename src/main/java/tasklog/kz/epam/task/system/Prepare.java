package tasklog.kz.epam.task.system;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tasklog.kz.epam.task.text.Proposal;
import tasklog.kz.epam.task.text.Symbol;
import tasklog.kz.epam.task.text.Word;

public class Prepare {
	 
	 public static List <Symbol> findSymbols2( String lines){
		List <Symbol> sevedList = new ArrayList <Symbol>();
		Pattern forSymbol = Pattern.compile("[\\S*]");
		String x = lines;
		Matcher m2 = forSymbol.matcher(x);
			while (m2.find()) {
				sevedList.add(new Symbol(m2.group().charAt(0)));
			}
		return sevedList;
	 }
	 
	public static List <String> searchForTheLine2(Pattern findPattern, String lines){
		List <String> returnStatment = new ArrayList <String>();
		String x = lines;
		Pattern p2 = findPattern;
		Matcher m2 = p2.matcher(x);
			while (m2.find()) {
				returnStatment.add(m2.group());
			}
		return returnStatment;
	}
	 
	public static List <Word> findWords(Pattern findPattern, List<String> lines){
		List<Word> returnStatment = new ArrayList<Word>();
		Pattern forWords = Pattern.compile("(\\S*[\\s])");
		for (int i = 0; i < lines.size(); i++) {
			String x = lines.get(i);
			Matcher m2 = forWords.matcher(x);
			while (m2.find()) {
				 returnStatment.add(new Word(findSymbols2(m2.group())));
			 }
		}
		return returnStatment;
	}
	 
	public static List <Proposal> findProposal(List<String> lines, Pattern findPattern){
		List<Proposal> returnStatment = new ArrayList<Proposal>();
		for (int i = 0; i < lines.size(); i++) {
			 String x = lines.get(i);
			 Pattern forWords = Pattern.compile("(\\S*[\\s])");
			 Pattern forProposal = findPattern;
			 Matcher m2 = forProposal.matcher(x);
			 while (m2.find()) {
				 returnStatment.add(new Proposal(findWords(forWords, Prepare.searchForTheLine2(forWords, m2.group()))));
			 }
		 }
		return returnStatment;
	}
	
	public static void printText(Read reading, Path path, List<String> lines){
		for (int i = 0; i < lines.size(); i++) {
			String x = lines.get(i);
			System.out.println(x);
		}
	}
}
