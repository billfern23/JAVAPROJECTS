package shapes;
//Rectangle custom exception class, stores the errors in this, so the main can throw them.
public class RectangleException extends Exception {
	private String message;

	public RectangleException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
