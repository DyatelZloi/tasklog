package tasklog.kz.epam.task.text;

public class Word {
	
	private String symbols;

	public Word( String symbols){
		this.symbols = symbols;
	}
	
	/**
	 * @return the symbols
	 */
	public String getSymbols() {
		return symbols;
	}

	@Override
	public String toString() {
		return "Word [symbols=" + symbols + "]";
	}

	/**
	 * @param symbols the symbols to set
	 */
	public void setSymbols(String symbols) {
		this.symbols = symbols;
	}
}
