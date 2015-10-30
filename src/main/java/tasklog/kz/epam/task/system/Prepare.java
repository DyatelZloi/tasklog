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

	/*
	 public static void splitText(List<String> lines,Pattern configuringPattern){  
	     for (int i = 0; i < lines.size(); i++) {
			String x = lines.get(i);
			String[] symbols = configuringPattern.split(x);//стринг токенайзер - выпилить
			for (String symbol : symbols){
			    //System.out.println(new Symbol(symbol.charAt(0)));
			}
		}   
	 } 
	 */
	
	 /*
	 public static List <Symbol> findSymbols(Pattern findPattern, List<String> lines){
		 List <Symbol> sevedList = new ArrayList <Symbol>();
		 for (int i = 0; i < lines.size(); i++) {
			 String x = lines.get(i);
			 Pattern p2 = findPattern;
			 Matcher m2 = p2.matcher(x);
			 while (m2.find()) {
				 //System.out.println(new Symbol(m2.group().charAt(0)).toString());
				 sevedList.add(new Symbol(m2.group().charAt(0)));
			 }
		 }
		return sevedList;
	 }
	 */
	 
	 public static List <Symbol> findSymbols2(Pattern findPattern, String lines){
		 List <Symbol> sevedList = new ArrayList <Symbol>();
			 String x = lines;
			 Pattern p2 = findPattern;
			 Matcher m2 = p2.matcher(x);
			 while (m2.find()) {
				 //System.out.println(new Symbol(m2.group().charAt(0)).toString());
				 sevedList.add(new Symbol(m2.group().charAt(0)));
			 }
		return sevedList;
	 }
	 
	 /*
	 public static List <String> searchForTheLine(Pattern findPattern, List<String> lines){
		 List <String> returnStatment = new ArrayList <String>();
		 for (int i = 0; i < lines.size(); i++) {
			 String x = lines.get(i);
			 Pattern p2 = findPattern;
			 Matcher m2 = p2.matcher(x);
			 while (m2.find()) {
				 returnStatment.add(m2.group());
			 }
		 }
		return returnStatment;
	 }
	 */
	 
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
		Pattern forSymbol = Pattern.compile("[\\S*]");
		Pattern forWords = Pattern.compile("(\\S*[\\s])");
		for (int i = 0; i < lines.size(); i++) {
			String x = lines.get(i);
			Matcher m2 = forWords.matcher(x);
			while (m2.find()) {
				 returnStatment.add(new Word(findSymbols2(forSymbol, m2.group())));
			 }
		}
		return returnStatment;
	}
	 
	public static List <Proposal> findProposal(List<String> lines, Pattern findPattern){
		List<Proposal> returnStatment = new ArrayList<Proposal>();
		for (int i = 0; i < lines.size(); i++) {
			 String x = lines.get(i);
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
			 Matcher m2 = forProposal.matcher(x);
			 while (m2.find()) {
				 returnStatment.add(new Proposal(findWords(forWords, Prepare.searchForTheLine2(forWords, m2.group()))));
			 }
		 }
		return returnStatment;
	}
	 
	 
	 /*
	 public static void findSymbol(String regex, List<String> lines){
		 for (int i = 0; i < lines.size(); i++) {
			 String x = lines.get(i);
			 Pattern p2 = Pattern.compile(regex);
			 Matcher m2 = p2.matcher(x);
			 while (m2.find()) {
				// new Word(Prepare.createText(anyList));
			 }
		 }
	 }
	 */
	
	/*
	public static boolean checkSymbol(Symbol anySymbol){
		if (anySymbol.getValue() == ' ' || anySymbol.getValue() == ','){
			return false;
		}
		else return true;
	} 
	 */
	
	/*
    public static void createWord(List <Symbol> anyList){
    	List <Symbol> miniList = new ArrayList <Symbol>();
    	for (Symbol anySymbol: anyList){
			if (Prepare.checkSymbol(anySymbol)){
				miniList.add(anySymbol);
			}
			else {
				System.out.println(new Word(miniList).toString());
				miniList.clear();
			}
		}	
    }
    */
	
	public static void printText(Read reading, Path path, List<String> lines){
		for (int i = 0; i < lines.size(); i++) {
			String x = lines.get(i);
			System.out.println(x);
		}
	}
}
