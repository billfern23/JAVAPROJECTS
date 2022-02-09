import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

/*
	THIS CLASS LETS USER INPUT STUDENT DATA
 */

public class WriteMenu {
	//TAKES IN STUDENT makes an arrayList
	ArrayList<Student> students = new ArrayList<Student>();
	
	//MAJOR FLAG FOR WRITING A FILE
	private Boolean errorChecker;
	
	//GETTER AND SETTER FOR FLAG
	private void setErrorChecker( Boolean check) {

		this.errorChecker = check;

	}
	private Boolean getErrorChecker() {

		return errorChecker;

	}
	//private Labels and Textfields for inputs
	private final Label studentNumberLabel = new Label("Student Number");
	private final TextField studentNumber = new TextField(); 

	private final Label firstNameLabel = new Label("First Name");
	private final TextField firstName = new TextField();

	private final Label lastNameLabel = new Label("Last Name");
	private final TextField lastName = new TextField();

	private final Label coursesLabel = new Label("Course");
	private final TextField courses = new TextField();

	private final Button addCourse = new Button("Add  Course");
	private final Button addStudent = new Button("Add Student");
	private final Button writeTofile = new Button("write Student");

	//CONSTRUCTOR, TO START NEW STAGE
	public WriteMenu() {
		//set this to false, because, initial load, nothing is entered and add student needs to be clicked before the program can write to file
		errorChecker = false;
		Stage writeStudent = new Stage();
		writeStudent.setTitle("Add Student");
		//GRIDPANE WAS USED
		GridPane writeStudentPane = new GridPane();
		//SET GAPS SO EVERYTHING DOESNT STICK
		writeStudentPane.setVgap(7);
		writeStudentPane.setHgap(7);
		writeStudentPane.setAlignment(Pos.TOP_CENTER);

		//TEXTFIELD AND LABEL FOR STUDENT NUMBER

		writeStudentPane.add(studentNumberLabel, 0, 0);
		writeStudentPane.add(studentNumber, 1, 0);

		//TEXTFIELD AND LABEL FOR FIRST NAME

		writeStudentPane.add(firstNameLabel, 0, 1);
		writeStudentPane.add(firstName, 1, 1);

		//TEXTFIELD AND LABEL FOR LAST NAME

		writeStudentPane.add(lastNameLabel, 0, 2);	
		writeStudentPane.add(lastName, 1, 2);

		//BUTTON TO ADD COURSE

		addCourse.setDisable(true);
		writeStudentPane.add(addCourse, 2, 3);

		//TEMPORARY ARRAY LIST TO ADD COURSES
		ArrayList <String> additionalCourses= new ArrayList <String>();	

		//TEXTFIELD AND LABEL  FOR COURSES

		writeStudentPane.add(coursesLabel, 0, 3);
		writeStudentPane.add(courses, 1, 3);
		
		//ADD LISTENER TO ONLY MAKE BUTTON CLICKABLE IF SOMETHING IS TYPED
		courses.textProperty().addListener((observable, oldValue, newValue) ->{
			addCourse.setDisable(false);
			if(courses.getText().isEmpty()) {
				addCourse.setDisable(true);  
			}

			//BUTTON WHEN CLICKED, ADDS COURSE TO TEMP ARRAYLIST
			addCourse.setOnAction(arg0-> {
				additionalCourses.add(courses.getText());
				courses.clear();
			});
		});

		//Button to addStudent to Student ArrayList
		//Checks if fields are empty, checks for datatype and then adds one Student to the  students arrayList.
		//generates alert fields with the appropriate errors


		writeStudentPane.add(addStudent, 2, 10);

		addStudent.setOnAction(arg0 -> { 
			Boolean studentNumberCheck = true;
			Boolean firstNameCheck = true;
			Boolean lastNameCheck = true;
			Boolean courseCheck = true;
			if(studentNumber.getText() == "") {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Student number is empty");
				alert.setHeaderText("Student number is empty");
				alert.show();
				studentNumber.setStyle("-fx-text-box-border: red;");
				studentNumber.clear();
				studentNumberCheck = false;
			}
			else {
				try {  
					Integer.parseInt(studentNumber.getText()); 
					studentNumber.setStyle(null);
					studentNumberCheck = true;

				} catch(NumberFormatException e){ 
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Student number has numbers Only");
					alert.setHeaderText("Student number has numbers Only");
					alert.show();
					studentNumber.setStyle("-fx-text-inner-color: red;-fx-text-box-border: red;");
					studentNumber.clear();
					studentNumberCheck = false;
				} 
			}	

			//check first Name  empty, regex text to make sure its letters only
			if(firstName.getText().equals("")) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("First Name is empty");
				alert.setHeaderText("First Name is empty");
				alert.show();
				firstName.setStyle("-fx-text-box-border: red;");
				firstNameCheck = false;
			}
			else {
				Pattern pattern = Pattern.compile("^[a-z]+$", Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(firstName.getText());
				boolean isString = matcher.find();
				if(isString == false) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("First Name has letter Only");
					alert.setHeaderText("Change First Name to letters Only");
					alert.show();
					firstName.setStyle("-fx-text-inner-color: red;-fx-text-box-border: red;");
					firstNameCheck = false;
				}
				else {
					firstNameCheck = true;
				}

			}	
			//check last Name  empty, regex text to make sure its letters only
			if(lastName.getText().equals("")) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Last Name is empty");
				alert.setHeaderText("Last Name is empty");
				alert.show();
				lastName.setStyle("-fx-text-box-border: red;");
				lastNameCheck = false;

			}
			else {
				Pattern pattern = Pattern.compile("^[a-z]+$", Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(lastName.getText());
				boolean isString = matcher.find();
				if(isString == false) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Last Name has letter Only");
					alert.setHeaderText("Change Last Name to letters Only");
					alert.show();
					lastName.setStyle("-fx-text-inner-color: red;-fx-text-box-border: red;");
					lastNameCheck = false;
				} 
				else {
					lastNameCheck = true;
				}
			}
			//checks size of temp arraylist to make sure atleast one course is added, does not do a type check, courses can be named anything
			if(additionalCourses.size() == 0) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("No courses added is empty");
				alert.setHeaderText("You need to add one course empty ");
				alert.show();
				courses.setStyle("-fx-text-box-border: red;");
				courses.clear();
				courseCheck = false;
			} else {
				courseCheck = true;
			}


			//if all the fields and datypes are good, we make a student object
			if(studentNumberCheck == true && firstNameCheck == true &&lastNameCheck == true && courseCheck == true ) {
				Student student = new Student(Integer.parseInt(studentNumber.getText()), firstName.getText(), lastName.getText());

			
					for(String course : additionalCourses) {
						//iterate through array and keep adding the course to student arraylist courses.
						if(course.equals("") == false) { //this is needed in case user keeps clicking on add course accidentally

							student.setCourses(course); //call the setCourses functions
						}


					}
				
				//add student to students arraylist
				students.add(student);
				//show alert Student was added
				Alert alert = new Alert(Alert.AlertType.INFORMATION );
				alert.setTitle("Student added suceesfully");
				alert.setHeaderText("Student added suceesfully");
				alert.show();
				setErrorChecker(true);
				//clear all fields
				studentNumber.clear();
				firstName.clear();
				lastName.clear();
				courses.clear();
				additionalCourses.removeAll(additionalCourses); //clear Temp array
			} else {
				//something is wrong, set this flag so the program wont write student
				setErrorChecker(false);
			}

		});

		//this writes the file
		writeTofile.setOnAction( arg0 -> {
			//check major flag if there are any errors, if no show success message else show error message
			if(getErrorChecker()) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION );
				alert.setTitle("Student File added suceesfully");
				alert.setHeaderText("Student File added suceesfully");
				alert.show();
				try {

					FileOutputStream fos = new FileOutputStream("Students.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(students);
					oos.flush();
					fos.close();
				} catch (IOException e) {
					System.err.print(e);
				}
			}
			else {
				Alert alert = new Alert(Alert.AlertType.ERROR );
				alert.setTitle("File not Created");
				alert.setHeaderText("Missing information");
				alert.show();
			}


		});

		// write all the stuff to the Scene
		writeStudentPane.add(writeTofile, 2, 12);
		Scene scene = new Scene(writeStudentPane, 600, 500);
		writeStudent.setScene(scene);
		writeStudent.show();
	}

}