package shapes;
//This is a custom exception class that throws stores the exception in a string for circle shape constructor
public class CirclesExceptions extends Exception {
	private String message;

	public CirclesExceptions(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
