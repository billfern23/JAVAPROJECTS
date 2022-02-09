
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.stream.Collectors;
public class StudentProcess {

	public static void main(String[] args) {
		//students array
		Student[] students = {
				new Student("Jack", "Smith", 50.0, "IT"),
				new Student("Aaron", "Johnson", 76.0, "IT"),
				new Student("Maaria", "White", 35.8, "Business"),
				new Student("John", "White", 47.0, "Media"),
				new Student("Laney", "White", 62.0, "IT"),
				new Student("Jack", "Jones", 32.9, "Business"),
				new Student("Wesley", "Jones", 42.89, "Media")	


		};
		//task 1
		System.out.print("Task 1: \n");
		System.out.print("Complete Student list:\n");
		List<Student> studentList = Arrays.asList(students); //convert array to arrayList
		studentList.forEach(System.out::println); //print out array using method reference
		System.out.print("\n");
		System.out.print("\n");

		//task 2
		System.out.print("Task 2: \n\n");
		System.out.print("Students who got 50.0-100.0 sorted by grade:\n");
		studentList.stream()														//use stream
		.filter(student-> student.getGrade() >= 50 && student.getGrade() <= 100)	//filter first, grade higher/equals 50 and grades lower/equals 100
		.sorted(Comparator.comparing(Student::getGrade)) //use comparator class method "comparing" comparing that takes in function as argument 
		.forEach(System.out::println); //use method reference to print out sorted array.



		//task 3
		System.out.print("\n");
		System.out.print("Task 3: \n\n");
		System.out.print("First Student who got 50.0-100.0:\n");

		studentList.stream()
		.filter(student-> student.getGrade() >= 50 && student.getGrade() <= 100) //filter first, grade higher/equals 50 and grades lower/equals 100
		.findFirst() //findfirst short circuit 
		.ifPresent(System.out::println); //ifPresent, optional class method that takes in consumer.
		System.out.print("\n");


		//task 4
		System.out.print("Task 4: \n");
		System.out.print("Students in ascending order by last name then first:\n");


		studentList.stream()
		.sorted(Comparator.comparing(Student::getLastName)
				.thenComparing(Comparator.comparing(Student::getFirstName)))  //use comparing method chained with thenComparing to sort by lastName then firstName.
		.forEach(System.out::println);

		System.out.print("\n");
		System.out.print("Students in descending order by last name then first:\n");
		studentList.stream()
		.sorted(Comparator.comparing(Student::getLastName).reversed()
				.thenComparing(Comparator.comparing(Student::getFirstName).reversed()))  //use comparing method chained with thenComparing to sort by lastName then firstName but reverse the order.
		.forEach(System.out::println);
		System.out.print("\n");

		//task 5
		System.out.print("Task 5: \n");
		System.out.print("Unique Student last names:\n");

		//maped student lastname, chained distinct sorted and printed it.
		studentList.stream()
		.map(Student::getLastName)
		.distinct()
		.sorted()
		.forEach(System.out::println);
		System.out.print("\n");

		//task 6
		System.out.print("Task 6: \n");
		System.out.print("Student names in order by last name then first name:\n");

		studentList.stream()         
		.sorted(Comparator.comparing(Student::getLastName) //sort students last name and first name and return stream chained with map
				.thenComparing(Comparator.comparing(Student::getFirstName)))
		.map(Student::getName)    
		.forEach(System.out::println);
		System.out.print("\n");


		//Task 7
		System.out.print("Task 7: \n");
		System.out.print("Students by department: \n");
		Map<String, List<Student>> department = 
				studentList.stream()
				.collect(Collectors.groupingBy(Student::getDepartment));  //grouingby department collect to return map

		department.forEach((key, value) ->{
			System.out.println(key);											//map method, value is a list, used for each to loop through that
			value.forEach(student -> System.out.print("\t" + student + "\n"));
		});

		//Task 8
		System.out.print("\nTask 8: \n");
		System.out.print("Count of Students by department: \n");		
		Map<String, Long> numberOfStudents =  studentList.stream()
				.collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));    //grouingby department, counting counts the number of input elements
		//collect to return map  

		numberOfStudents.entrySet()
		.stream()
		.sorted(Entry.comparingByKey())
		.forEach(entry -> {
			System.out.printf("%s has %d student(s) \n", entry.getKey(), entry.getValue());	 //used entryset and sorted by key because the alternative is too complex
		});

		//Task 9
		System.out.print("\nTask 9: \n");
		double totalGrades =  studentList.stream()
				.mapToDouble(Student::getGrade)              //maptodouble to map stream to double stream, use sum method to calculate sum of grades
				.sum();

		System.out.print("Sum of Students' grades: " + totalGrades);

		//Task 10
		System.out.print("\n\nTask 10: \n");
		double avgGrades =  studentList.stream()
				.mapToDouble(Student::getGrade)
				.average()
				.getAsDouble();                //maptodouble to map stream to double stream, use sum method to calculate average of grades
		//retuns it as an  OptionalDouble, so converted that into a double.
		System.out.printf("Average of Students' grades: %.2f", avgGrades);


	}
}


