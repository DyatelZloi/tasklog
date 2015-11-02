package tasklog.kz.epam.task.text;

import java.util.List;

public class Text {
	
	private List <SimpleSentence> anyText;

	@Override
	public String toString() {
		return "Text [anyText=" + anyText + "]";
	}

	public Text(List <SimpleSentence> anyText){
		this.anyText = anyText;
	}
	
	public Text(String group) {
	// TODO Auto-generated constructor stub
	}

	/**
	 * @return the anytext
	 */
	public List <SimpleSentence> getAnytext() {
		return anyText;
	}

	/**
	 * @param anytext the anytext to set
	 */
	public void setAnytext(List <SimpleSentence> anytext) {
		this.anyText = anytext;
	}
}
