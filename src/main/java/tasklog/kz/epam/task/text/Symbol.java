package tasklog.kz.epam.task.text;

public class Symbol {
	
	private char value;

	public Symbol(){
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Symbol other = (Symbol) obj;
		if (value != other.value)
			return false;
		return true;
	}

	public Symbol(char value){
		this.value = value;
	}
	
	public Symbol(String group) {
		// TODO Auto-generated constructor stub
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
	
	public char SourceString(){
		return value;
	}
}
