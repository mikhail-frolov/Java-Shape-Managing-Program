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

//for double formating in toString()
import java.text.DecimalFormat;

// Circle class that implements Shape interface
public class Circle implements Shape{
	
	// Circle's radius
	private double radius;
	
	//Constructor for circle
	public Circle(double radius) throws CircleClassException {
		if (radius > 0) {
			this.radius = radius;			
		} else {
			throw new CircleClassException("Invalid radius!");
		}
	}
	
	//Getter for radius
	public double getRadius() {return radius;}
	
	//Setter for radius
	public void setRadius(double radius) throws CircleClassException {
		if (radius > 0) {
			this.radius = radius;			
		} else {
			throw new CircleClassException("Invalid radius!");
		}
	}
	
	
	//Calculation perimeter = 2PI*radius (overriding function for Circle class)
	@Override
	public double perimeter() {
		return 2 * Math.PI * radius;
	}

	//implementation for toString()
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " {r=" + getRadius() + "} perimeter = " + new DecimalFormat("0.00000").format(perimeter());
	}
}
