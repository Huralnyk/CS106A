/*
 * File: Hailstone.java
 * Name: Alexey Huralnyk
 * --------------------
 * This programs reads in a number from the user and then
 * displays the Hailstone sequence for that number, just as
 * in Hofstadter’s book, followed by a line showing the number
 * of steps taken to reach 1. 
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int n = readInt("Enter a number: ");
		int steps = 0;
		while (n != 1) {
			if (n % 2 == 0) {
				println(n + " is even so I take half: " + (n /= 2));
			} else {
				println(n + " is odd so I make 3n + 1: " + (n = (3 * n + 1)));
			}
			steps++;
		}
		println("The process took " + steps + " to reach 1");
	}
}

