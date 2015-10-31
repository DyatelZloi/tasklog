package tasklog.kz.epam.task.system.write;


public class WriteToTheConsole implements Write{

	@Override
	public void write(String string) {
		// TODO Auto-generated method stub
			System.out.println(string);
	}

}
