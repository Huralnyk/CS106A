/*
 * File: StringProcessor.java
 * --------------------------
 * This class contains public methods for string processing.
 */

public class StringProcessor {
	
	/**
	 * Removes all occurrences of character from string
	 * and returns new string without given character.
	 * @param str	String to process on
	 * @param ch	Character to remove
	 * @return		String without all occurrences of ch
	 */
	public static String removeAllOccurrences(String str, char ch) {
		int index = str.indexOf(ch);
		while (index != -1) {
			str = str.substring(0, index) + str.substring(index + 1);
			index = str.indexOf(ch);
		}
		return str;
	}
	
	/**
	 * Converts a string to alternating capital letters,
	 * meaning you alternate between uppercase and lowercase.
	 * @param str 	String to alternate
	 * @return		String with alternated letters
	 */
	public static String altCaps(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (i % 2 != 0) {
				result += Character.toUpperCase(ch);
			} else {
				result += Character.toLowerCase(ch);
			}
		}
		return result;
	}
}
