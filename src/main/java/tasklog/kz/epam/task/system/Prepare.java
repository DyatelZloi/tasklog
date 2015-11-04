package tasklog.kz.epam.task.system;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tasklog.kz.epam.task.text.SimpleSentence;
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

    public List <SimpleSentence> findProposal(List<String> lines){
        List<SimpleSentence> returnStatment = new ArrayList<SimpleSentence>();
        Pattern forWords = Pattern.compile("(\\S*[\\s])");
        Pattern forProposal = Pattern.compile("([^.!?]*([.]{3}|[.!?]))" );
        for (int i = 0; i < lines.size(); i++) {
            String x = lines.get(i);
            Matcher m2 = forProposal.matcher(x);
            while (m2.find()) {
                returnStatment.add(new SimpleSentence(findWords(forWords, Prepare.searchForTheLine2(forWords, m2.group()))));
            }
        }
        return returnStatment;
    }
}
