package shapes;
//this class implements shape, calculates the perimter of a square and throws an error.
public class Square implements Shape {
	private double side;
	private String name;

	public Square(String name, double side) throws SquareException {
		//check if values are negative or zero
		if (side <= 0.0) {
			throw new SquareException("Invalid side!");
		}

		else {
			this.name = name;
			this.side = side;
		}

	}

	@Override
	public double calculatePerimeter() {
		return (4 * side);

	}
	//create an object area with lambda expression 
	Area areaSquare =() ->getSide() * getSide();

	//over ride two string method to return area
	@Override
	public String toString() {
		return String.format("%s {s=%f} perimeter = %f, area = %f", this.getName(), this.getSide(), this.calculatePerimeter(), areaSquare.calculateArea());
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
