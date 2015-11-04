package tasklog.kz.epam.task.system.write;


public class ConsoleRecorder implements Recorder{

	@Override
	public void write(String string) {
		// TODO Auto-generated method stub
			System.out.println(string);
	}

}
