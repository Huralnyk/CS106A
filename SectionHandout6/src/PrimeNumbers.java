/*
 * File: PrimeNumbers.java
 * -----------------------
 * This program generates a list of prime numbers from 2 to N
 * using the sieve of Eratosthenes.
 */

import acm.program.*;

public class PrimeNumbers extends ConsoleProgram {
	
	private static final int N = 1000; // Upper threshold of prime number list
	
	public void run() {
		int[] numbers = new int[N-2];
		initNumbers(numbers);
		crossOutComposites(numbers);
		printPrimes(numbers);
	}
	
	// Initializes array with sequence of integer numbers starting from 2
	private void initNumbers(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 2;
		}
	}
	
	// Crossed-out composite numbers in a sequence, which mean set them to 0
	private void crossOutComposites(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			int n = numbers[i];
			if (n != 0) {
				for (int j = i + n; j < numbers.length; j += n) {
					numbers[j] = 0;
				}
			}
		}
	}
	
	// Prints numbers sequence with already crossed-out composite numbers.
	private void printPrimes(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			int n = numbers[i];
			if (n != 0) println(n);
		}
	}
}
