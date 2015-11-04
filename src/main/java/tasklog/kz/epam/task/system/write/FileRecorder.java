package tasklog.kz.epam.task.system.write;


public class FileRecorder {
	
	private Recorder write;
	
	public void setStrategy(Recorder write) {
        this.write = write;
    }
	
	public void readFile (String string) {
		write.write(string);
    }
}
