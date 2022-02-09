package shapes;
//calculates the perimeter of a triangle, implements shape class, checks for the valid triangle rule and throws an error
public class Triangle implements Shape {
	private String name;
	private double sideA;
	private double sideB;
	private double sideC;

	public Triangle(String name, double sideA, double sideB, double sideC) throws TriangleException {
		//check if values are negative or zero
		if (sideA <= 0.0 || sideB <= 0.0 || sideC <= 0.0) {
			throw new TriangleException("Invalide side(s)!  \n");
		}
		//the triangle rule, the sum of two sides has to be greater than the third.
		if ((sideA + sideB) < sideC) {
			throw new TriangleException("Invalide sides(s)! \n");
		} else if ((sideA + sideC < sideB)) {
			throw new TriangleException("Invalide sides(s)!\n");
		} else if ((sideB + sideC < sideA)) {
			throw new TriangleException("Invalide sides(s) \n");
		}

		else {
			this.name = name;
			this.sideA = sideA;
			this.sideB = sideB;
			this.sideC = sideC;
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	
	public double getSideA() {
		return sideA;
	}

	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	public double getSideC() {
		return sideC;
	}

	public void setSideC(double sideC) {
		this.sideC = sideC;
	}

	@Override
	public String toString() {
		return String.format("%s {s1=%.2f, s2=%.2f, s3=%.2f} perimeter = %f", this.getName(), this.getSideA(),
				this.getSideB(), this.getSideC(), this.calculatePerimeter());
	}

	@Override
	public double calculatePerimeter() {
		return (getSideA() + getSideB() + getSideC());

	}
	

}
