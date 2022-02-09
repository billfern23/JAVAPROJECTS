package shapes;
//this class implements Shape, throws an error if the width or length are not good, and uses a custom exception class, it calculates the parimeter of a Rectangle.
public class Rectangle implements Shape {

	private String name;
	private double width;
	private double length;

	public Rectangle(String name, double width, double length) throws RectangleException {
		if (width <= 0.0 || length <= 0.0) {
			throw new RectangleException("Invalide side!");
		}

		this.name = name;
		this.width = width;
		this.length = length;

	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	//over rides calculatePerimeter from shapes
	@Override
	public double calculatePerimeter() {
		return (2 * getWidth() + 2 * getLength());

	}
	//create an object area with lambda expression
	Area areaRectangle = ()->  getWidth() * getLength();
	//over rides tostring method, if paralleogram dont return area, else return area
	@Override
	public String toString() {
		if(this.getName().equals("Parallelogram")) {
			return String.format("%s {w=%.2f, h=%.2f} perimeter = %f", this.getName(), this.getWidth(), this.getLength(),
					this.calculatePerimeter());
		}
		return String.format("%s {w=%.2f, h=%.2f} perimeter = %f, area = %f", this.getName(), this.getWidth(), this.getLength(),
				this.calculatePerimeter(), areaRectangle.calculateArea());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
