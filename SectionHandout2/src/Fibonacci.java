/*
 * File: Fibonacci.java
 * --------------------
 * This program lists the Fibonacci sequence until its
 * term value less than MAX_TERM_VALUE.
 */

import acm.program.*;

public class Fibonacci extends ConsoleProgram {
	
	private static final int MAX_TERM_VALUE = 10000;
	
	/* Runs the program */
	public void run() {
		println("This program lists the Fibonacci sequence.");
		int i = 0;
		int term = fib(i);
		while (term < MAX_TERM_VALUE) {
			println(term);
			i++;
			term = fib(i);
		}
	}
	
	/* Returns a value for nth element in Fibonacci sequence */
	private int fib(int n) {
		int current = 0;
		int previous = 1;
		for (int i = 0; i < n; i++) {
			current += previous;
			previous = current - previous;
		}
		return current;
	}
}
