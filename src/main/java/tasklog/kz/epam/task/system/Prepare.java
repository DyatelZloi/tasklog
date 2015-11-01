package tasklog.kz.epam.task.system;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tasklog.kz.epam.task.text.Proposal;
import tasklog.kz.epam.task.text.Symbol;
import tasklog.kz.epam.task.text.Word;

public class Prepare {

	public List <Symbol> findSymbols2(Pattern findPattern, String lines){
		List <Symbol> returnList = new ArrayList <Symbol>();
		String line = lines;
		Matcher matcher = findPattern.matcher(line);
		while (matcher.find()) {
			 returnList.add(new Symbol(matcher.group().charAt(0)));
		}
		return returnList;
	 }
	 
	public static List <String> searchForTheLine2(Pattern findPattern, String lines){
		List <String> returnList = new ArrayList <String>();
		String line = lines;
		Matcher matcher = findPattern.matcher(line);
		while (matcher.find()) {
			returnList.add(matcher.group());
		}
		return returnList;
	}
	
	public List <Word> findWords(Pattern findPattern, List<String> lines){
		List<Word> returnList = new ArrayList<Word>();
		Pattern forSymbol = Pattern.compile("[\\S*]");
		Pattern forWords = Pattern.compile("(\\S*[\\s])");
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			Matcher matcher = forWords.matcher(line);
			while (matcher.find()) {
				 returnList.add(new Word(findSymbols2(forSymbol, matcher.group())));
			 }
		}
		return returnList;
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
			 Matcher m2 = forProposal.matcher(x);
			 while (m2.find()) {
				returnStatment.add(new Proposal(findWords(forWords, Prepare.searchForTheLine2(forWords, m2.group()))));
			 }
		 }
		return returnStatment;
	}
}
