package tasklog.kz.epam.task.system.write;


public class WriteFile {
	
	private Write write;
	
	public void setStrategy(Write write) {
        this.write = write;
    }
	
	public void readFile (String string) {
		write.write(string);
    }
}
