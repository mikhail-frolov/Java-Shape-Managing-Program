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

// Rectangle has the same formula as Parallelogram so we can make Parallelogram as a super class
public class Rectangle extends Parallelogram {
	
	public Rectangle(double width, double length) throws ParallelogramClassException {
		//uses same constructor as Parallelogram by calling "super"
		super(width, length);
	}

}