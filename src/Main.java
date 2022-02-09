import shapes.Shape;
import shapes.Rectangle;
import shapes.RectangleException;
import shapes.Square;
import shapes.SquareException;
import shapes.Parallelogram;
import shapes.Circle;
import shapes.CirclesExceptions;
import shapes.Triangle;
import shapes.TriangleException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* 
 This File takes shapes from shapes.txt and calculates parameters polymorphically.
 */

public class Main {

	//this function prints all the shapes from the array

	public static void printShapes(Shape[] shapes) {

		for (Shape shape : shapes) {  
			if (shape != null) {        //checks if its not null
				System.out.println(shape);

			}

		}

	}

	//this function calculates the total perimiter from a shape, for a particular shape like circle, rectangle...etc

	public static double calculateTotalPerimeter(Shape[] shapes, String className) {
		//local variable to keep track of total perimeter
		double totalPerimter = 0;
		for (Shape shape : shapes) {
			if (shape != null) { //checks for not null shapes
				if (shape.getClass().getSimpleName().equals(className)) {
					totalPerimter += shape.calculatePerimeter();   //adds to totalPerimeter

				}
			}

		}

		return totalPerimter;

	}
	//this function deletes the triangle/s with the smallest perimeter
	public static void deleteSmallestTrianglePerimeter(Shape[] shapes, double smallestTrianglePerimeter) {

		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] != null) {
				if (shapes[i].getClass().getSimpleName().equals("Triangle")) { //checks for classname = Tirangle
					if (shapes[i].calculatePerimeter() == smallestTrianglePerimeter) { // finds if perimeter of a particular triangle = smallestPerimiter
						shapes[i] = null;									 //if true set the shapes array to null;

					}

				}
			}
		}


	}

	// finds smallest perimeter of triangle in the shapes array and returns it
	public static double findSmallestPerimeter(Shape[] shapes) {
		/*local variable keeps a track of the first index position a triangle class. 
		 * first triangle parimeter can be stored and then other can be compared to other perimeters.
		 */
		double indexTracker = 0;
		//local variable keeps track of smallest perimeter
		double smallestPerimeter = 0;
		// keep track of initial index position
		for (int j = 0; j < shapes.length; j++) {
			if (shapes[j] != null) {
				if (shapes[j].getClass().getSimpleName().equals("Triangle")) {
					if (indexTracker == 0) {
						smallestPerimeter = shapes[j].calculatePerimeter();    /*if it is the first triangle to be found, store value in smallestPerimeter 
																				and increase the indexTracker by one. */
						indexTracker++;
					} else {
						if (shapes[j].calculatePerimeter() <= smallestPerimeter) { /*if the perimeter is smaller or equal to the smallestPerimeter
																					Replace the smallest perimeter with new perimeter.*/
							smallestPerimeter = shapes[j].calculatePerimeter();

						}
					}

				}
			}

		}
		return smallestPerimeter;

	}

	public static void main(String[] args) {

		// track how many initial number of shapes are possible
		int initialShapes = 0;
		System.out.print("------->JAC 444 Assignment 1<-------\r\n" + "------->Task 1 ... <-------\n");
		// Find Total number of possible shapes to create a new array by counting the
		// total number of lines
		try (BufferedReader bl = new BufferedReader(new FileReader("shapes.txt"))) {
			String line;
			while ((line = bl.readLine()) != null) {
				initialShapes++;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// create a new array
		Shape[] shapes = new Shape[initialShapes];
		// index starts from -1, so that the actual index can start from 0 after
		// intialization
		int index = -1;
		// re-opens file but this time split it using , to find how many characters are
		// in each line
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
			String s;

			while ((s = br.readLine()) != null) {
				index++; // increase index++ to start array off from 0

				String[] tokens = s.split(",");
				/*
				 * Check for shape rectangle and then try to create an object, else throw an
				 * error if an exception is thrown go back to previous index, retry
				 */
				if (tokens[0].equals("Rectangle")) {
					if (tokens.length > 3) { // if there are more than three tokens, that means the line is not formated
						// properly
						index--;
					} else {
						double token1 = Double.parseDouble(tokens[1]); // check for token 1 and then token 2, which //
						// should contain length
						double token2 = Double.parseDouble(tokens[2]);
						try {
							shapes[index] = new Rectangle("Rectangle", token1, token2);
						} catch (RectangleException e) {
							index--;
							System.out.print(e.getMessage());
						}
					}
				}
				/*
				 * Check for shape Square and then try to create an object, else throw an error
				 * if an exception is thrown go back to previous index, retry
				 */
				else if (tokens[0].equals("Square")) {
					if (tokens.length > 2) {// if there are more than two tokens, that means the line is not formated
						// properly
						--index;
					} else {
						double token1 = Double.parseDouble(tokens[1]);
						try {
							shapes[index] = new Square("Square", token1); // check for token 1 for value

						} catch (SquareException e) {
							index--;
							System.out.println(e.getMessage());
						}
					}
				} /*
				 * Check for shape Parallelogram and then check number of lines try to create an
				 * object, else throw an error if an exception is thrown go back to previous
				 * index, retry
				 */
				else if (tokens[0].equals("Parallelogram")) {

					if (tokens.length > 3) { // if there are more than three tokens, that means the line is not formated
						// properly
						index--;
					} else {
						double token1 = Double.parseDouble(tokens[1]); // parse the string to a double, token[1],
						// token[2] are the ideal parameters
						double token2 = Double.parseDouble(tokens[2]);

						try {
							shapes[index] = new Parallelogram("Parallelogram", token1, token2);

						} catch (RectangleException e) { // Paralleogram extends shape, so it uses the same
							// functionality
							index--;
							System.out.print(e.getMessage());
						}

					}
				}
				/*
				 * Check for shape Circle and then check number of lines try to create an
				 * object, else throw an error if an exception is thrown go back to previous
				 * index, retry
				 */

				else if (tokens[0].equals("Circle")) {
					if (tokens.length > 2) { // if there are more than two tokens, that means the line is not formated
						// properly

						index--;
					} else {
						double token1 = Double.parseDouble(tokens[1]);// token[1] has the value needed
						try {
							shapes[index] = new Circle("Circle", token1);
							

						} catch (CirclesExceptions e) {
							index--;
							System.out.print(e.getMessage() + "\n");

						}
					}
				}
				/*
				 * Check for shape Triangle and then check number of lines try to create an
				 * object, else throw an error if an exception is thrown go back to previous
				 * index, retry
				 */

				else if (tokens[0].equals("Triangle")) {
					if (tokens.length > 4) { // if there are more than 4 tokens, line is not formated properly
						index--;
					} else {

						double token1 = Double.parseDouble(tokens[1]); // Token[1] , token[2], token[3] are the values
						double token2 = Double.parseDouble(tokens[2]);
						double token3 = Double.parseDouble(tokens[3]);
						try {

							shapes[index] = new Triangle("Triangle", token1, token2, token3);

						} catch (TriangleException e) {
							index--;
							System.out.print(e.getMessage());
						}
					}

				} else
					// none of the above shapes are present skip the line and reduce the index to
					// prevent nulls in middle.
				{
					index--;
				}

			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		// Total number of shapes actually created would be index + 1 because array
		// indexes start from 0.
		index++;
		System.out.printf("\n");
		System.out.printf("%d Shapes were created: \n", index);

		//prints out all the shapes
		printShapes(shapes);

		System.out.println("\n------->Task 2 ... <-------");

		// local variable to store smallestTriangle perimeter
		double smallestTrianglePerimeter = 0;

		//  smallest perimiter of triangles found by calling the function findsmallestPerimeter and sending shapes array
		smallestTrianglePerimeter = findSmallestPerimeter(shapes);

		// delete the smallest perimeter by sending shapes and the smallest perimeter
		deleteSmallestTrianglePerimeter(shapes, smallestTrianglePerimeter);

		//print shapes without the smallest perimeter
		printShapes(shapes);

		//local variables to store parallelogram and triangle total perimeters
		double parallelogramTotalPerimter = 0;
		double triangleTotalPerimeter = 0;

		System.out.print("\n------->Task 3 ... <-------\n");

		//calculated parellogram total perimeter
		parallelogramTotalPerimter = calculateTotalPerimeter(shapes, "Parallelogram");

		//calculated Triangle total perimeter, used the same function twice
		triangleTotalPerimeter = calculateTotalPerimeter(shapes, "Triangle");

		//print total perimeter of paralleogram and triangle
		System.out.printf("Total perimeter of Parallelogram is: %f \n Total perimeter of Triangle is: %.1f", parallelogramTotalPerimter,triangleTotalPerimeter);


	}
}
