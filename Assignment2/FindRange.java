/*
 * File: FindRange.java
 * Name: Alexey Huralnyk
 * --------------------
 * This program finds the smallest and largest values in a list
 * of integers entered by the user. To end the list of inputs
 * enter the SENTINEL value.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	/* Sentinel value uses to stop entering a list */
	private static final int SENTINEL = 0;
	
	/* Runs the program */
	public void run() {
		println("This program finds the largest and smalles numbers.");
		
		int smallest = Integer.MAX_VALUE;
		int largest = Integer.MIN_VALUE;
		boolean isEntered = false;
		
		while (true) {
			int value = readInt("? ");
			if (value == SENTINEL) break;
			isEntered = true;
			if (value > largest) {
				largest = value;
			}
			if (value < smallest) {
				smallest = value;
			}
		}
		
		/* Print result depends on if the value was entered */
		if (isEntered) {
			println("smallest: " + smallest);
			println("largest: " + largest);
		} else {
			println("You entered no values");
		}
	}
}

