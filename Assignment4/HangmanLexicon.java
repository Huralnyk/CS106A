/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a implementation of the HangmanLexicon which
 * provide lexicon to Hangman game from a file specified by constant
 * FILENAME.
 */

import acm.util.*;
import java.io.*;
import java.util.*;

public class HangmanLexicon {
	
	/** Private constants */
	private static final String FILENAME = "ShorterLexicon.txt";
	
	/**
	 * This is the HangmanLexicon constructor.
	 * Initializes content of lexicon from a file specified
	 * by a constant FILENAME.
	 */
	public HangmanLexicon() {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(FILENAME));
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				words.add(line);
			}
			rd.close();
		} catch (IOException ex){
			throw new ErrorException("File not found");
		}
	}

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return words.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return words.get(index);
	};
	
	/** Private instance variables */
	private ArrayList<String> words = new ArrayList<String>();
}
