/*
 * File: StringExamples.java
 * -------------------------
 * Contains methods for string manipulation from
 * Handout #25 by Mehran Sahami. Stanford CS106A
 */

public class StringExamples {
	
	public boolean isPalindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - (i+ 1))) {
				return false;
			}
		}
		return true;
	}
	
	public String reverseString(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			result = str.charAt(i) + result;
		}
		return result;
	}
	
	public boolean simpleIsPalindrome(String str) {
		return str.equals(reverseString(str));
	}
	
	public String replaceFirstOccurrence(String str,
										 String orig,
										 String repl) {
		int index = str.indexOf(orig);
		if (index != -1) {
			str = str.substring(0, index)
				  + repl
				  + str.substring(index + orig.length());
		}
		return str;
	}
	
	/*
	 * Removes any double letters from a string.
	 */
	public String removeDoubleLetters(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (i == 0 || ch != str.charAt(i - 1)) {
				result += ch;
			}
		}
		return result;	
	}
	
	private String addCommasToNumericString(String digits) {
		String result = "";
		int len = digits.length();
		int nDigits = 0;
		for (int i = len - 1; i >= 0; i--) {
			result = digits.charAt(i) + result;
			nDigits++;
			if (nDigits % 3 == 0 && i > 0) {
				result = "," + result;
			}
		}
		return result;
	}
	
	private String removeAllOccurrences(String str, char ch) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ch) {
				result += str.charAt(i);
			}
		}
		return result;
	}
	
	private String altCaps(String str) {
		String result = "";
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) counter++;
			
			if (counter % 2 == 0) {
				result += Character.toUpperCase(str.charAt(i));
			} else {
				result += Character.toLowerCase(str.charAt(i));
			}
		}
		return result;
	}
}
