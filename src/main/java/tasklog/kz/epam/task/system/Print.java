package tasklog.kz.epam.task.system;

import java.nio.file.Path;

public class Print {
	public static void printText(Read reading, Path path, java.util.List<String> lines){
		for (int i = 0; i < lines.size(); i++) {
			String x = lines.get(i);
			System.out.println(x);
		}
	}
}
