package src.main.java.com.AutomatedMeetingBookingSystem.exception;

public class ConnectionFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	public ConnectionFailedException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
