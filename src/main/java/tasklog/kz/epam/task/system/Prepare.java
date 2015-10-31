package tasklog.kz.epam.task.system;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tasklog.kz.epam.task.text.Proposal;
import tasklog.kz.epam.task.text.Symbol;
import tasklog.kz.epam.task.text.Word;

public class Prepare {
<<<<<<< HEAD

	public List <Symbol> findSymbols2(Pattern findPattern, String lines){
		List <Symbol> sevedList = new ArrayList <Symbol>();
		String x = lines;
		Pattern p2 = findPattern;
		Matcher m2 = p2.matcher(x);
		while (m2.find()) {
			 sevedList.add(new Symbol(m2.group().charAt(0)));
		}
=======
	 
	 public static List <Symbol> findSymbols2( String lines){
		List <Symbol> sevedList = new ArrayList <Symbol>();
		Pattern forSymbol = Pattern.compile("[\\S*]");
		String x = lines;
		Matcher m2 = forSymbol.matcher(x);
			while (m2.find()) {
				sevedList.add(new Symbol(m2.group().charAt(0)));
			}
>>>>>>> origin/master
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
	
	public List <Word> findWords(Pattern findPattern, List<String> lines){
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
	 
	public List <Proposal> findProposal(List<String> lines){
		List<Proposal> returnStatment = new ArrayList<Proposal>();
		Pattern forWords = Pattern.compile("(\\S*[\\s])");
		Pattern forProposal = Pattern.compile(
				"# Match a sentence ending in punctuation or EOS.\n" +
				"[^.!?\\s]    # First char is non-punct, non-ws\n" +
				"[^.!?]*      # Greedily consume up to punctuation.\n" +
				"(?:          # Group for unrolling the loop.\n" +
				"  [.!?]      # (special) inner punctuation ok if\n" +
				"  (?!['\"]?\\s|$)  # not followed by ws or EOS.\n" +
				"  [^.!?]*    # Greedily consume up to punctuation.\n" +
				")*           # Zero or more (special normal*)\n" +
				"[.!?]?       # Optional ending punctuation.\n" +
				"['\"]?       # Optional closing quote.\n" +
				"(?=\\s|$)", 
		Pattern.MULTILINE | Pattern.COMMENTS);
		for (int i = 0; i < lines.size(); i++) {
			 String x = lines.get(i);
<<<<<<< HEAD
=======
			 Pattern forWords = Pattern.compile("(\\S*[\\s])");
			 Pattern forProposal = findPattern;
>>>>>>> origin/master
			 Matcher m2 = forProposal.matcher(x);
			 while (m2.find()) {
				returnStatment.add(new Proposal(findWords(forWords, Prepare.searchForTheLine2(forWords, m2.group()))));
			 }
		 }
		return returnStatment;
	}
<<<<<<< HEAD
=======
	
	public static void printText(Read reading, Path path, List<String> lines){
		for (int i = 0; i < lines.size(); i++) {
			String x = lines.get(i);
			System.out.println(x);
		}
	}
>>>>>>> origin/master
}
