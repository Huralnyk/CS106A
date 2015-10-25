/*
 * File: SecondLargest.java
 * ------------------------
 * This program finds the largest and the second-largest integer
 * in a list entered by user.
 */

import acm.program.*;

public class SecondLargest extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		println("This program finds the two largest integers in a list. " +
				"Enter values, one per line, using a 0 to signal the end" +
				" of the list.");
		int largest = 0;
		int secondLargest = 0;
		while (true) {
			int n = readInt(" ? ");
			if (n == 0) break;
			if (n > largest) {
				secondLargest = largest;
				largest = n;
			} else if (n > secondLargest) {
				secondLargest = n;
			}
		}
		println("The largest value is " + largest);
		println("The second largest is " + secondLargest);
	}
}
