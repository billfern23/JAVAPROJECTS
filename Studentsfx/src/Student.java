
import java.util.ArrayList;
import java.io.Serializable;
// Students seriliazable class,
public class Student implements Serializable {
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses = new ArrayList<String>();

	public Student(int stdID, String firstName, String lastName) {
		this.stdID = stdID;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public int getStdID() {
		return stdID;
	}

	public void setStdID(int stdID) {
		this.stdID = stdID;
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

	public ArrayList<String> getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses.add(courses);
	}

}
