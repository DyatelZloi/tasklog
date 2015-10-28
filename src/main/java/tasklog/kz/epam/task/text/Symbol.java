package tasklog.kz.epam.task.text;

public class Symbol {
	
	private char value;

	public Symbol(){
	}
	
	public Symbol(char value){
		this.value = value;
	}
	
	/**
	 * @return the value
	 */
	public char getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(char value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Symbol [value=" + value + "]";
	}
}
