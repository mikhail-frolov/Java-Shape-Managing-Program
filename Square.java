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

import java.text.DecimalFormat;


public class Square extends Rectangle {
	
	//Constructor for Square, we can use the super class and we do not override the formula
	public Square(double length) throws ParallelogramClassException {
		super(length, length);
	}

	// No need for setter and getter because we already have it in other class, the functions are public so we can use it in this class too.

	
	//Implementation for Perimeter of Square 4length
	@Override
	public double perimeter() {
		
		return 4 * getLength();
	}

	//Overriding toString() for correct output
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " {s=" + getLength() + "} perimeter = " + new DecimalFormat("0.00000").format(perimeter());
	}
}