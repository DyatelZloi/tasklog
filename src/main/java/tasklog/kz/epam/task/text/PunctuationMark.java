package tasklog.kz.epam.task.text;

public class PunctuationMark extends SimpleSentence{
	private String value;
	
	public PunctuationMark(String string){
		this.setValue(string);
	}


	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
