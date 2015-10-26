package tasklog.kz.epam.task.text;

public class Proposal {
	
	private String words;

	@Override
	public String toString() {
		return "Proposal [words=" + words + "]";
	}

	public Proposal(String words){
		this.words = words;
	}
	
	/**
	 * @return the words
	 */
	public String getWords() {
		return words;
	}

	/**
	 * @param words the words to set
	 */
	public void setWords(String words) {
		this.words = words;
	}
}
