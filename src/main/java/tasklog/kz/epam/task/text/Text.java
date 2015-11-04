package tasklog.kz.epam.task.text;

import java.util.Iterator;
import java.util.List;

public class Text implements Iterable<SimpleSentence> {
	
	private List <SimpleSentence> listSimpleSentence;

	@Override
	public String toString() {
		return "Text [anyText=" + listSimpleSentence + "]";
	}

	public Text(List <SimpleSentence> anyText){
		this.listSimpleSentence = anyText;
	}
	
	public Text(String group) {
	// TODO Auto-generated constructor stub
	}

	/**
	 * @return the anytext
	 */
	public List <SimpleSentence> getAnytext() {
		return listSimpleSentence;
	}

	/**
	 * @param anytext the anytext to set
	 */
	public void setAnytext(List <SimpleSentence> anytext) {
		this.listSimpleSentence = anytext;
	}
	
	public void add(SimpleSentence arg0){
		this.listSimpleSentence.add(arg0);
	}


	@Override
	public Iterator<SimpleSentence> iterator() {
		return listSimpleSentence.iterator();
	}
	
	public String sourceString(){
		StringBuilder string = new StringBuilder();
		for (SimpleSentence simpleSentence : listSimpleSentence)
		string.append(simpleSentence.sourceString()).append(".");
		String returnString = new String(string);
		return returnString;
	}
}
