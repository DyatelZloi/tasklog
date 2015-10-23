package tasklog.kz.epam.task;
import java.util.logging.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Hello world!
*/
	public class App {
		public static final Logger LOG=Logger.getLogger(App.class.toString());
		public static void main(String[] args) {
			DOMConfigurator.configure("./log4j.xml");
			LOG.info("Hello World!!!!");
		}
	}
