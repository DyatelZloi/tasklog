package tasklog.kz.epam.task.text;

import java.util.List;
import tasklog.kz.epam.task.text.Symbol;

public class Word {
	
	private List <Symbol> symbols;

	public Word(List <Symbol> symbols){
		this.symbols = symbols;
	}
	
	public void addSymbol(Symbol anySymbol){
		this.symbols.add(anySymbol);
	}
	
	/**
	 * @return the symbols
	 */
	public List <Symbol> getSymbols() {
		return symbols;
	}

	@Override
	public String toString() {
		return "Word [symbols=" + symbols + "]";
	}

	/**
	 * @param symbols the symbols to set
	 */
	public void setSymbols(List <Symbol> symbols) {
		this.symbols = symbols;
	}
}
