/*
 * File: DoubleLetters.java
 * ------------------------
 * This program implements method which removes double
 * letters from a given string and tests it.
 */

import acm.program.*;

public class DoubleLetters extends ConsoleProgram {
	
	/** Runs the program */
	public void run() {
		String str = removeDoubleLetters("tresidder");
		println(str);
		str = removeDoubleLetters("bookkeeper");
		println(str);
	}
	
	/** Removes double letters from a string */
	private String removeDoubleLetters(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (i != 0) {
				if (ch != result.charAt(result.length() - 1)) {
					result += ch;
				}
			} else {
				result += ch;
			}
		}
		return result;
	}
}
