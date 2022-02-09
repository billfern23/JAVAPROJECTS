package shapes;
import shapes.CirclesExceptions;

//This class implements interface shape and throws an error if an invalid radius is found, calculates perimeter of circle, implements shape
public class Circle implements Shape {
	private String name;
	private double radius;


	// constructor
	public Circle(String name, double radius) throws CirclesExceptions {

		//check if values are negative or zero
		if (radius <= 0.0) {
			throw new CirclesExceptions("Invalid radius! ");

		}
		this.name = name;
		this.radius = radius;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	//overides perimeter
	@Override
	public double calculatePerimeter() {
		return (2 * Math.PI * getRadius());

	}
	//create an object area with lambda expression
	Area areaCircle = ()-> Math.PI * getRadius() * getRadius();
	//overides tostring method to return area
	@Override
	public String toString() {
		return String.format("%s {r=%.2f} perimeter = %f, Area = %f", this.getName(), this.getRadius(), this.calculatePerimeter(),areaCircle.calculateArea());
	}

}
