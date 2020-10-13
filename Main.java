/* -----------------------------------------------------------------
Workshop 3
--------------------------------------------------------------------
Name: Mikhail Frolov
Date: 2020/10/12
ID: 164788184
E-mail: mfrolov@myseneca.ca
--------------------------------------------------------------------*/
//I have done all the coding by myself and only copied the code that
//my professor provided to complete my workshops and assignments.
/*------------------------------------------------------------------*/
package shapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Class Main reads from a .txt file
public class Main {

	// Task 1: Read the file Shapes.txt, create the shapes and store them in your data structure.
	// Then print the number of shapes you created, and finally,
	// print all the shapes and their calculated perimeters polymorphically.
	
	public static void main(String[] args) throws ParallelogramClassException {

		// Data structure for shapes
		Shape shapes[] = new Shape[33];
		int count = 0;
		
		// Task 1 logic
		System.out.println("------->JAC 444 Assignment 1<-------");
		System.out.println("------->Task 1 ... <-------");

		// (Provided by professor) reads the file line by line
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
			
			String s;
			while ((s = br.readLine()) != null) {
				
				// Splits the line by comma ","
				// Token is a string so we need to pass the value to a constructor as double
				String[] tokens = s.split(",");

				// Circle -> Triangle etc.. checking for a shape
				
				if (tokens[0].equals("Circle") && tokens.length == 2) {
					try {
						shapes[count] = new Circle(Double.parseDouble(tokens[1]));
						count++;
					} catch (Exception msg) {
						System.out.println(msg.getMessage());
					}
				} else if (tokens[0].equals("Square") && tokens.length == 2) {
					try {
						shapes[count] = new Square(Double.parseDouble(tokens[1]));
						count++;
					} catch (Exception msg) {
						System.out.println(msg.getMessage());
					}
				} else if (tokens[0].equals("Rectangle") && tokens.length == 3) {
					try {
						shapes[count] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
						count++;
					} catch (Exception msg) {
						System.out.println(msg.getMessage());
					}
				} else if (tokens[0].equals("Parallelogram") && tokens.length == 3) {
					try {
						shapes[count] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
						count++;
					} catch (Exception msg) {
						System.out.println(msg.getMessage());
					}
				} else if (tokens[0].equals("Triangle") && tokens.length == 4) {
					try {
						shapes[count] = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
						count++;
					} catch (Exception msg) {
						System.out.println(msg.getMessage());
					}
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		// Task 1 OUTPUT
		
		System.out.println();
		System.out.println(count + " shapes were created:");
		for (int i = 0; i < count; i++) {
			System.out.println(shapes[i]);
			System.out.println();
		}
		
	
	
	// Task 2: Delete the triangle with the minimum perimeter (there could be more than one minimum)
	// and the circle with the maximum perimeter (there could be more than one maximum) from the shapes.
	// Print the all the remaining shapes and their perimeters polymorphically.
	
	// minimum perimeter triangle has to be the biggest value for us to calculate the smallest one as we going to compare each triangle with each other.
	double minTrianglePerimeter = 999999999;
	
	// maximum Circle perimeter value is 0 originally so any value is the largest at first and then we compare that value to all the circles.
	double maxCirclePerimeter = 0;
	
	// Integer to count the amount of deleted shapes.
	int deletedCount = 0;
	
	// let's get minimum and maximum perimeters for the shapes (Triangle and Circle). 
	// Looping through all shapes
	
	for (int i = 0; i < count; i++) {
		
		// Minimum Perimeter for Triangle
		if (shapes[i].getClass().getSimpleName().equals("Triangle")) {
			if (shapes[i].perimeter() < minTrianglePerimeter) {
				
				//assign minimum Triangle to a minimum value among Triangles.
				minTrianglePerimeter = shapes[i].perimeter();
	
			}
		}
		
		// Maximum Perimeter for Circle
		if (shapes[i].getClass().getSimpleName().equals("Circle")) {
			if (shapes[i].perimeter() > maxCirclePerimeter) {
				
				//assign maximum Circle to a maximum value among Circles.
				maxCirclePerimeter = shapes[i].perimeter();
			
			}
		}
	}
	
	
	// Let's count items that need to be deleted.
	for (int i = 0; i < count; i++) {
		if (shapes[i].getClass().getSimpleName().equals("Triangle")) {
			if (shapes[i].perimeter() == minTrianglePerimeter) {
				deletedCount++;
			}
		}
		
		if (shapes[i].getClass().getSimpleName().contentEquals("Circle")) {
			if (shapes[i].perimeter() == maxCirclePerimeter) {
				deletedCount++;
			}
		}
	}
	
	// Creating new integer value to calculate the number of shapes in new array.
	int newCount = 0;
	newCount = count - deletedCount;
	
	// new array without deleted shapes
	Shape renewedShapes[] = new Shape[newCount];
	int index = 0;
	
	// If it is not the min. Triangle or max. Circle -> move it into a new array of Shapes.
	for (int i = 0; i < count; i++) {
		if (shapes[i].getClass().getSimpleName().equals("Triangle")) {
			
			if (shapes[i].perimeter() != minTrianglePerimeter) {
				renewedShapes[index] = shapes[i];
				index++;
			}
		} else if (shapes[i].getClass().getSimpleName().equals("Circle")) {
			
			if (shapes[i].perimeter() != maxCirclePerimeter) {
				renewedShapes[index] = shapes[i];
				index++;
			}
		} else {
			
			// if it is not a triangle or a circle then we add them too.
			renewedShapes[index] = shapes[i];
			index++;
		}
	}
	
	// Tasks 2 OUTPUT
		System.out.println("------->Task 2 ... <-------");
	for (int j = 0; j < newCount; j++) {
		System.out.println(renewedShapes[j]);
		System.out.println();
	}
	
	
	// Task 3: Calculate and print the total perimeter of all Parallelograms and the total perimeter of all triangles.
	
	// declaring total Perimeter values 
	double perimeterOfAllParallelograms = 0;
	double perimeterOfAllTriangles = 0;
	
	// Looping through the shapes and calculating total perimeter of the specified shapes.
	for (int x = 0; x < newCount; x++) {
		
		// Total for perimeter of Parallelograms
		if(renewedShapes[x].getClass().getSimpleName().equals("Parallelogram")) {
			perimeterOfAllParallelograms += renewedShapes[x].perimeter();
		}
		
		// Total for perimeter of Triangles
		if(renewedShapes[x].getClass().getSimpleName().equals("Triangle")) {
			perimeterOfAllTriangles += renewedShapes[x].perimeter();
		}	
	}
	
	// Task 3 OUTPUT
	System.out.println("------->Task 3 ... <-------");
	System.out.println("Total perimeter of Parallelogram is: " + perimeterOfAllParallelograms);
	System.out.println("Total perimeter of Triangle is: " + perimeterOfAllTriangles);
	
	}
}