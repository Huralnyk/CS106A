/*
 * File: CountUppercase.java
 * -------------------------
 * This program from Handout #25 by professor
 * Mehran Sahami. Stanford CS106A
 */

import acm.program.*;

public class CountUppercase extends ConsoleProgram {
	
	private int countUppercase(String str) {
		int upperCount = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isUpperCase(ch)) {
				upperCount++;
			}
		}
		return upperCount;
	}
	
	public void run() {
		String str = readLine("Enter string: ");
		println(countUppercase(str) + " upper case letters.");
	}

}
