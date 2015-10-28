/*
 * File: WordCount.java
 * --------------------
 * This program reads a file and reports how many lines,
 * words, and characters appear in it. Name of the file
 * to process specified by user's input.
 */

import acm.program.*;
import acm.util.*;
import java.util.*;
import java.io.*;

public class WordCount extends ConsoleProgram {
	
	/** Private constants */
	private static final String DELIMETERS = " '";
	
	public void run() {		
		BufferedReader rd = openFile("File: ");
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				nLines++;
				nWords += countWords(line);
				nChars += line.length();
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		println("Lines: " + nLines);
		println("Words: " + nWords);
		println("Characters: " + nChars);
	}
	
	/**
	 * Opens the file with the name specified by user.
	 * @param prompt Prompt to represent to the user.
	 * @return	Non-null BufferedReader object.
	 */
	private BufferedReader openFile(String prompt) {
		BufferedReader rd = null;
		
		while (rd == null) {
			try {
				String filename = readLine(prompt);
				rd = new BufferedReader(new FileReader(filename));
			} catch (IOException ex) {
				println("Couldn't open that file. Try again.");
			}
		}
		
		return rd;
	}
	
	/**
	 * Counts how many words in specified string.
	 */
	private int countWords(String str) {
		int counter = 0;
		StringTokenizer tokenizer = new StringTokenizer(str, DELIMETERS);
		while (tokenizer.hasMoreTokens()) {
			counter++;
			tokenizer.nextToken();
		}
		return counter;
	}
	
	/** Private instance variables */
	private int nLines = 0; // Number of lines in the file.
	private int nWords = 0; // Number of words in the file.
	private int nChars = 0; // Number of characters in the file.

}
