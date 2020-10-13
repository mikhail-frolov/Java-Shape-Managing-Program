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

public class Triangle implements Shape {
	
	// Three sides
	private double one;
	private double two;
	private double three;
	
	// Constructor for Triangle
	public Triangle(double one, double two, double three) throws TriangleClassException {
		if (one < (two + three) && two < (one + three) && three < (one + two)) {
			this.one = one;
			this.two = two;
			this.three = three;
		} else {
			throw new TriangleClassException("Invalid side(s)!");
		}
	}
	
	// Setters for each side
	public void setFirstSide(double one, double two, double three)  throws TriangleClassException {
		if (one < (two + three)) {
			this.one = one;
			
		} else {
			throw new TriangleClassException("The first side is invalid...");
		}
	}
	
	public void setSecondSide(double one, double two, double three) throws TriangleClassException {
		if (two < (one + three)) {
			
			this.two = two;
		} else {
			throw new TriangleClassException("The second side is invalid...");
		}
	}
	
	public void setThirdSide(double one, double two, double three) throws TriangleClassException {
		if (three < (one + two)) {
	
			this.three = three;
		} else {
			throw new TriangleClassException("The third side is invalid...");
		}
	}
	
	
	// Getters for each side
	public double getFirstSide() {
		return one;
	}
	
	public double getSecondSide() {
		return two;
	}
	
	public double getThirdSide() {
		return three;
	}
	
	// Overriding perimeter of triangle one+two+three
	@Override
	public double perimeter() {
		return one + two + three;
	}
	
	// Overriding toString() for correct output
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " {s1=" + getFirstSide() + ", s2=" + getSecondSide() + ", s3=" + getThirdSide() + "} perimeter = " + new DecimalFormat("0.00000").format(perimeter());
	}
}
