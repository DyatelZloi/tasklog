package tasklog.kz.epam.task.text;

import java.util.Iterator;
import java.util.List;

public class SimpleSentence implements Iterable <Word> {
	
	private List<Word> words;
	private boolean theInterrogativeSentence;
	private boolean anExclamationSentence;
	private boolean declarativeSentence;
	
	@Override
	public String toString() {
		return "Proposal [words=" + words + "]";
	}

	public SimpleSentence(List<Word> words){
		this.words = words;
	}
	
	public SimpleSentence(String group) {
		// TODO Auto-generated constructor stub
	}

	public SimpleSentence() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the words
	 */
	public List<Word> getWords() {
		return words;
	}

	/**
	 * @param words the words to set
	 */
	public void setWords(List<Word> words) {
		this.words = words;
	}

	/**
	 * @return the theInterrogativeSentence
	 */
	public boolean isTheInterrogativeSentence() {
		return theInterrogativeSentence;
	}

	/**
	 * @param theInterrogativeSentence the theInterrogativeSentence to set
	 */
	public void setTheInterrogativeSentence(boolean theInterrogativeSentence) {
		this.theInterrogativeSentence = theInterrogativeSentence;
	}

	/**
	 * @return the anExclamationSentence
	 */
	public boolean isAnExclamationSentence() {
		return anExclamationSentence;
	}

	/**
	 * @param anExclamationSentence the anExclamationSentence to set
	 */
	public void setAnExclamationSentence(boolean anExclamationSentence) {
		this.anExclamationSentence = anExclamationSentence;
	}

	/**
	 * @return the declarativeSentence
	 */
	public boolean isDeclarativeSentence() {
		return declarativeSentence;
	}

	/**
	 * @param declarativeSentence the declarativeSentence to set
	 */
	public void setDeclarativeSentence(boolean declarativeSentence) {
		this.declarativeSentence = declarativeSentence;
	}

	@Override
	public Iterator<Word> iterator() {
		// TODO Auto-generated method stub
		return words.iterator();
	}
	
	public String sourceString(){
		StringBuilder string = new StringBuilder();
		for (Word word : words)
		string.append(word.sourceString()).append(" ");
		String returnString = new String(string);
		return returnString;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((words == null) ? 0 : words.hashCode());
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
		SimpleSentence other = (SimpleSentence) obj;
		if (words == null) {
			if (other.words != null)
				return false;
		} else if (!words.equals(other.words))
			return false;
		return true;
	}
}
