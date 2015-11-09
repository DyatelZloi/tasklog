package tasklog.kz.epam.task.parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tasklog.kz.epam.task.text.SimpleSentence;
import tasklog.kz.epam.task.text.Symbol;
import tasklog.kz.epam.task.text.Word;

public class Parse {
	
	 public List <Symbol> findSymbols(Pattern findPattern, String lines){
	        List <Symbol> returnList = new ArrayList <Symbol>();
	        String line = lines;
	        Matcher matcher = findPattern.matcher(line);
	        while (matcher.find()) {
	             returnList.add(new Symbol(matcher.group().charAt(0)));
	        }
	        return returnList;
	     }

	    public static List <String> searchForTheLine(Pattern findPattern, String lines){
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
	                returnList.add(new Word(findSymbols(forSymbol, matcher.group())));
	            }
	        }
	        return returnList;
	    }

	    public List <SimpleSentence> findProposal(List<String> lines){
	        List<SimpleSentence> returnList = new ArrayList<SimpleSentence>();
	        Pattern forWords = Pattern.compile("(\\S*[\\s])");
	        Pattern forProposal = Pattern.compile("([^.!?]*([.]{3}|[.!?]))" );
	        for (int i = 0; i < lines.size(); i++) {
	            String x = lines.get(i);
	            Matcher m2 = forProposal.matcher(x);
	            while (m2.find()) {
	                returnList.add(new SimpleSentence(findWords(forWords, Parse.searchForTheLine(forWords, m2.group()))));
	            }
	        }
	        return returnList;
	    }
	}
