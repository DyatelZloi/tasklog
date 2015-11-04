package tasklog.kz.epam.task.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import tasklog.kz.epam.task.sorting.SortByIndex;
import tasklog.kz.epam.task.text.Symbol;

public class Word implements Iterable <Symbol> {
	
	private List <Symbol> symbols;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbols == null) ? 0 : symbols.hashCode());
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
		Word other = (Word) obj;
		if (symbols == null) {
			if (other.symbols != null)
				return false;
		} else if (!symbols.equals(other.symbols))
			return false;
		return true;
	}

	public Word(List <Symbol> symbols){
		this.symbols = symbols;
	}
	
	public Word(String group) {
		// TODO Auto-generated constructor stub
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
	
	public boolean palindrome(){
		ArrayList listWords = new ArrayList(this.symbols);
		Word palindrome = new Word(listWords);
		Collections.sort(palindrome.getSymbols(), new SortByIndex());
		return this.equals(palindrome);
	}

	@Override
	public Iterator<Symbol> iterator() {
		// TODO Auto-generated method stub
		return symbols.iterator();
	}
	
	public String sourceString(){
		StringBuilder string = new StringBuilder();
		for (Symbol symbol : symbols)
		string.append(symbol.sourceString());
		String returnString = new String(string);
		return returnString;
	}
}
