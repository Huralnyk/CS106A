/*
 * File: AddCommas.java
 * --------------------
 * This program takes a string of decimal digits representing a number
 * from user input and then separates the digits into groups of three.
 * Program asks user for a new string to convert until user enters an
 * empty line.
 */

import acm.program.*;

public class AddCommas extends ConsoleProgram {
	
	public void run() {
		while (true) {
			String digits = readLine("Enter a numeric string: ");
			if (digits.isEmpty()) break;
			println(addCommasToNumericString(digits));
		}
	}
	
	/**
	 * Separates the digits in numeric string into groups of three.
	 * @param str	Numeric string
	 * @return		String with separated digits
	 */
	private String addCommasToNumericString(String str) {
		if (!isNumericString(str)) return str;
		
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			int rank = str.length() - i;
			if (i != 0 && rank % 3 == 0) result += ",";
			char ch = str.charAt(i);
			result += ch;
		}
		return result;
	}
	
	/**
	 * Checks whether given string is numeric string.
	 */
	private boolean isNumericString(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
