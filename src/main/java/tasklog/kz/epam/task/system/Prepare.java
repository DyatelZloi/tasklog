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

	 public static void splitText(java.util.List<String> lines,Pattern configuringPattern){  
	     for (int i = 0; i < lines.size(); i++) {
			String x = lines.get(i);
			String[] symbols = configuringPattern.split(x);//стринг токенайзер - выпилить
			for (String symbol : symbols){
			    //System.out.println(new Symbol(symbol.charAt(0)));
			}
		}   
	 } 
	 
	 //Свапвщполвапрла
	 public static List <Symbol> findSymbols(String regex, java.util.List<String> lines){//public List <String> findAny()
		 List <Symbol> sevedList = new ArrayList <Symbol>();
		 for (int i = 0; i < lines.size(); i++) {
			 String x = lines.get(i);
			 Pattern p2 = Pattern.compile(regex);
			 Matcher m2 = p2.matcher(x);
			 while (m2.find()) {
				 System.out.println(new Symbol(m2.group().charAt(0)).toString());
				 sevedList.add(new Symbol(m2.group().charAt(0)));
			 }
		 }
		return sevedList;// List <String>
	 }
	 
	 public static void findSymbol(String regex, java.util.List<String> lines){
		 for (int i = 0; i < lines.size(); i++) {
			 String x = lines.get(i);
			 Pattern p2 = Pattern.compile(regex);
			 Matcher m2 = p2.matcher(x);
			 while (m2.find()) {
				// new Word(Prepare.createText(anyList));
			 }
		 }
	 }
	 
	public static boolean checkSymbol(Symbol anySymbol){
		if (anySymbol.getValue() == ' ' || anySymbol.getValue() == ','){
			return false;
		}
		else return true;
	} 
	 
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
	 
	public static void printText(Read reading, Path path, java.util.List<String> lines){
		for (int i = 0; i < lines.size(); i++) {
			String x = lines.get(i);
			System.out.println(x);
		}
	}
}
