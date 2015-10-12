/*
 * File: PythagoreanTheorem.java
 * Name: Alexey Huralnyk
 * -----------------------------
 * This program computes length of the hypotenuse in a right triangle
 * using the Pythagorean theorem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		println("Enter values to compute the Pythagorean theorem.");
		double a = readDouble("a: ");
		double b = readDouble("b: ");
		double c = Math.sqrt(a*a + b*b);
		println("c = " + c);
	}
}
