package tasklog.kz.epam.task.text;

import java.util.List;

import tasklog.kz.epam.task.text.Word;

public class Proposal {
	
	private List<Word> words;
	private boolean theInterrogativeSentence;
	private boolean anExclamationSentence;
	private boolean declarativeSentence;
	
	@Override
	public String toString() {
		return "Proposal [words=" + words + "]";
	}

	public Proposal(List<Word> words){
		this.words = words;
	}
	
	public Proposal(String group) {
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
}
