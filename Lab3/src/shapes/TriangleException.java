package shapes;
//Custom triangle exception class
public class TriangleException extends Exception {
	private String message;

	public TriangleException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
