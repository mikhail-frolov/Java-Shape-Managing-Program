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

// for double formating in toString()
import java.text.DecimalFormat;

public class Parallelogram implements Shape {
	
	//Parameters
	private double width;
	private double lenght;
	
	//Constructor
	Parallelogram(double width, double lenght) throws ParallelogramClassException {
		if (width > 0 && lenght > 0) {
			this.lenght = lenght;
			this.width = width;
			
		} else {
			throw new ParallelogramClassException("Invalid side(s)!");
		}
	}
	
	//Setters for parameters
	public void setWidth(double width) throws ParallelogramClassException {
		if (width > 0) {
		
			this.width = width;
			
		} else {
			throw new ParallelogramClassException("Invalid width...");
		}
	}
	
	public void setLength(double lenght) throws ParallelogramClassException {
		if (lenght > 0) {
			this.lenght = lenght;
			
		} else {
			throw new ParallelogramClassException("Invalid lenght...");
		}
	}
	
	// Getters for parameters
	public double getWidth() {
		return width;
	}
	
	public double getLength() {
		return lenght;
	}
	
	// Perimeter for Parallelogram 2weight+2lenght
	@Override
	public double perimeter() {
		return 2 * width + 2 * lenght;
	}
	
	//Overriding toString() for correct output
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {w=" + getWidth() + ", h=" + getLength() + "} perimeter = " + new DecimalFormat("0.00000").format(perimeter());
	}

}