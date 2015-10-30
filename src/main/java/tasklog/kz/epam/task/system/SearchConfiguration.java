package tasklog.kz.epam.task.system;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchConfiguration {
	private Pattern searchConfigurationPattern;
	private Matcher searchConfigurationMatcher;
	
	public SearchConfiguration(Pattern searchPattern, Matcher searchMatcher){
		this.searchConfigurationPattern = searchPattern;
		this.searchConfigurationMatcher = searchMatcher;
	}
	
	public void ResetConfiguration(){
		
	}

	/**
	 * @return the searchConfigurationPattern
	 */
	public Pattern getSearchConfigurationPattern() {
		return searchConfigurationPattern;
	}

	/**
	 * @param searchConfigurationPattern the searchConfigurationPattern to set
	 */
	public void setSearchConfigurationPattern(Pattern searchConfigurationPattern) {
		this.searchConfigurationPattern = searchConfigurationPattern;
	}

	/**
	 * @return the searchConfigurationMatcher
	 */
	public Matcher getSearchConfigurationMatcher() {
		return searchConfigurationMatcher;
	}

	/**
	 * @param searchConfigurationMatcher the searchConfigurationMatcher to set
	 */
	public void setSearchConfigurationMatcher(Matcher searchConfigurationMatcher) {
		this.searchConfigurationMatcher = searchConfigurationMatcher;
	}
}
