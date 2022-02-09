import java.io.Serializable;

public class Car implements Serializable{
	private String model;
	private String color;
	private int milage;
	private int plate;
	//constructor
	public Car(String model, String color, int milage) {
		this.model = model;
		this.color = color;
		this.milage = milage;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMilage() {
		return milage;
	}

	public void setMilage(int milage) {
		this.milage = milage;
	}

	public int getPlate() {
		return plate;
	}

	public void setPlate(int plate) {
		this.plate = plate;
	}

	//override toString method
	@Override
	public String toString() {
		return String.format("Model:%s\nColor: %s\nMillage: %d\nPlate: %d\n", this.getModel(), this.getColor(), this.getMilage(), this.getPlate());
	}


}
