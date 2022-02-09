import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;




public class ReadFile {
	//ArrayList to downcast
	ArrayList<Student> students = new ArrayList<Student>();

	public ReadFile() {
		//create newStage
		Stage readStudent = new Stage();
		readStudent.setTitle("Read Student");

		GridPane readStudentPane = new GridPane();
		readStudentPane.setVgap(7);
		readStudentPane.setHgap(7);
		readStudentPane.setAlignment(Pos.TOP_CENTER);
		//Text Area scrollable
		TextArea studentObjects = new TextArea();
		readStudentPane.setAlignment(Pos.TOP_CENTER);

		
		readStudentPane.add(studentObjects, 0, 0);

		try {
			FileInputStream fis = new FileInputStream("Students.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			students = (ArrayList<Student>) ois.readObject(); //downcast object to arrayList<Student>
			fis.close();
		} catch (IOException e) {
			System.err.print(e +"\n");
			System.exit(0);
		}
		catch (ClassNotFoundException e) {
			System.err.print(e + "\n");
		}
		//downcast each item of arrayList to object Student to access each property. 

		for(Student student: students) { 
			studentObjects.appendText(Integer.toString(student.getStdID()) + "\n");
			studentObjects.appendText(student.getFirstName() + "\n");
			studentObjects.appendText(student.getLastName() + "\n");
			studentObjects.appendText(student.getCourses() + "\n");
		}

		Scene scene = new Scene(readStudentPane, 600, 500);
		readStudent.setScene(scene);
		readStudent.show();


	}


}