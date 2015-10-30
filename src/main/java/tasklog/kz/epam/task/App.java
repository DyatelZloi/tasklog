package tasklog.kz.epam.task;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.apache.log4j.xml.DOMConfigurator;
import tasklog.kz.epam.task.system.Prepare;
import tasklog.kz.epam.task.system.Read;
import tasklog.kz.epam.task.text.Text;


public class App {
	
	public static final Logger LOG=Logger.getLogger(App.class.toString());
	
	public static void main(String[] args)  {
		DOMConfigurator.configure("./log4j.xml");
		Read reading = new Read();
		Path path = Paths.get("./test.txt");
		List<String> textFile = reading.readFile(path);
		Pattern forProposal = Pattern.compile(
			"# Match a sentence ending in punctuation or EOS.\n" +
			"[^.!?\\s]    # First char is non-punct, non-ws\n" +
			"[^.!?]*      # Greedily consume up to punctuation.\n" +
			"(?:          # Group for unrolling the loop.\n" +
			"  [.!?]      # (special) inner punctuation ok if\n" +
			"  (?!['\"]?\\s|$)  # not followed by ws or EOS.\n" +
			"  [^.!?]*    # Greedily consume up to punctuation.\n" +
			")*           # Zero or more (special normal*)\n" +
			"[.!?]?       # Optional ending punctuation.\n" +
			"['\"]?       # Optional closing quote.\n" +
			"(?=\\s|$)", 
			Pattern.MULTILINE | Pattern.COMMENTS);
		Text text = new Text(Prepare.findProposal(textFile, forProposal));
		System.out.println(text.toString());
	}
}
