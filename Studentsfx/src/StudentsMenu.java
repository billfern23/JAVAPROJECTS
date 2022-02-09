import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/*
 	SUB MENU FOR CLASS
 */
public class StudentsMenu extends Application {
	//Enter here
	@Override 
	public void start(Stage primaryStage) {

		GridPane gridPane = new GridPane();
		Label title = new Label("Main menu");
		gridPane.setVgap(8);

		//Button to open up write Students and write to file
		Button btWriteNewStudent = new Button("Write To File");
		btWriteNewStudent.setOnAction(arg0 -> {
			new WriteMenu();  // call the writeMenu() constructor
		});

		//Button to read file
		Button btReadStudents = new Button("Read File");
		btReadStudents.setOnAction(arg0 -> {
			new ReadFile(); // call the ReadFile() constructor
		});
		gridPane.add(title, 0, 0);
		gridPane.add(btWriteNewStudent, 1 , 1);
		gridPane.add(btReadStudents, 1 , 3);

		Scene scene = new Scene(gridPane, 300, 100);
		primaryStage.setTitle("Main menu");
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
}
