/*
 * File: Hangman.java
 * ------------------
 * Author: Alexey Huralnyk
 * This program plays the Hangman game from 
 * Assignment #4 (Stanford's CS106A course).
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	
	/** Private constants */
	private static final int N_GUESSES = 8;

    public void run() {
		startNewGame();
		println("Welcome to Hangman");
		println("The word now looks like this: " + currentWord);
		
		
	}
    
    private void startNewGame() {
    	int index = rgen.nextInt(lexicon.getWordCount());
    	secret = lexicon.getWord(index);
    	currentWord = dashify(secret);
    	guessesLeft = N_GUESSES;
    }
    
    private String dashify(String str) {
    	String result = "";
    	for (int i = 0; i < str.length(); i++) {
    		result += "—";
    	}
    	return result;
    } 
    
    /** Private instance variables */
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private HangmanLexicon lexicon = new HangmanLexicon();
    
    private String secret;
    private String currentWord;
    private int guessesLeft;
}
