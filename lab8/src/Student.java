// Student class
public class Student {
	private String firstName;
	private String lastName;
	private double grade;
	private String department;

	public Student(String firstName, String lastName, double grade, String department) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.department = department;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	// returns firstName and lastName
	public String getName() {
		return this.getFirstName() + ' ' + this.getLastName();

	}
	//override toString

	@Override
	public String toString() {
		return String.format("%s\t%s\t%.2f\t%s", this.getFirstName(), this.getLastName(), this.getGrade(), this.getDepartment());
	}
	//override the equals method.
	@Override
	public boolean equals(Object obj) {
		Boolean check = true;
		if(obj == null) {
			check = false;  //not required but there for additional validation.
		}
		if(getClass() != obj.getClass()) {
			check = false;  //not required but there for additional validation.
		}
		if(check) {
			Student other = (Student) obj; //Cast obj to student
			if(this.getFirstName() != other.getFirstName()) {  //check firstName
				check = false;
			}

			if(this.getLastName() != other.getLastName()) {
				check = false; //check last name
			}

			if(this.getGrade() != other.getGrade()) {
				check = false;   //check grade
			}
			if(this.getDepartment() != other.getDepartment()) {
				check = false;  //check department.
			}


		}
		return check;
	}

}
