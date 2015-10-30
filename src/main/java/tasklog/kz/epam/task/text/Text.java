package tasklog.kz.epam.task.text;

import java.util.List;

public class Text {
	
	private List <Proposal> anyText;

	@Override
	public String toString() {
		return "Text [anyText=" + anyText + "]";
	}

	public Text(List <Proposal> anyText){
		this.anyText = anyText;
	}
	
	/**
	 * @return the anytext
	 */
	public List <Proposal> getAnytext() {
		return anyText;
	}

	/**
	 * @param anytext the anytext to set
	 */
	public void setAnytext(List <Proposal> anytext) {
		this.anyText = anytext;
	}
}
