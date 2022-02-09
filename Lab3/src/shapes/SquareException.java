package shapes;
// Square exception class, custom exception class
public class SquareException extends Exception {
	private String message;

	public SquareException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
