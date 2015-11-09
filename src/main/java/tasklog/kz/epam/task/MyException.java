package tasklog.kz.epam.task;

public class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException(Throwable e) { 
        initCause(e); 
    }
}
