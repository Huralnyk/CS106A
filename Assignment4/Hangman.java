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
    	setupGame();
		playGame();
		endGame();
	}
    
    private void setupGame() {
    	int index = rgen.nextInt(lexicon.getWordCount());
    	secret = lexicon.getWord(index);
    	currentWord = dashify(secret);
    	guesses = N_GUESSES;
    }
    
    private void playGame() {
    	println("Welcome to Hangman");
    	while (!gameIsOver()) {
    		println("The word now looks like this: " + currentWord);
    		print("You have ");
    		print(guesses > 1 ? guesses : "only one");
    		println(guesses > 1 ? " guesses left.": " guess left.");
    		char ch = makeGuess();
    		checkGuessForCorrectness(ch);
    	}
    }
    
    private void endGame() {
    	if (guesses == 0) {
    		println("You're completely hung.");
    		println("The word was: " + secret);
    		println("You lose.");
    	} else {
    		println("You guessed the word: " + currentWord);
    		println("You win.");
    	}
    }
    
    /**
     * Replace all characters in specified string to symbol "—".
     */
    private String dashify(String str) {
    	String result = "";
    	for (int i = 0; i < str.length(); i++) {
    		result += "—";
    	}
    	return result;
    }
    
    /**
     * Asks user to enter a guess and returns the correct guess.
     */
    private char makeGuess() {
    	while (true) {
    		String line = readLine("Your guess: ");
    		if (isLegalGuess(line)) {
    			return Character.toUpperCase(line.charAt(0));
    		}
    		println("Nice try cheater! Guess is illegal.");
    	}
    }
    
    private void checkGuessForCorrectness(char ch) {
    	if (secret.indexOf(ch) != -1) {
    		println("That guess is correct.");
    		currentWord = openLetter(ch);
    	} else {
    		println("There're no " + ch + "'s in the word.");
    		guesses--;
    	}
    }
    
    private String openLetter(char ch) {
    	String result = "";
    	for (int i = 0; i < currentWord.length(); i++) {
    		if (secret.charAt(i) == ch) {
    			result += ch;
    		} else {
    			result += currentWord.charAt(i);
    		}
    	}
    	return result;
    }
    
    /**
     * Checks to see whether a string is legal guess in the game,
     * which means it meets the following conditions.
     * (1) String consists of only one character.
     * (2) This character is English letter.
     */
    private boolean isLegalGuess(String str) {
    	return str.length() == 1 && Character.isLetter(str.charAt(0));
    }
    
    /**
     * Checks to see whether a game is over which happens when
     * one of the following situations occur.
     * (1) User runs out of guesses and he lose.
     * (2) User guessed all the letters in the word and he win.
     */
    private boolean gameIsOver() {
    	return guesses == 0 || currentWord.indexOf('—') == -1;
    }
    
    /** Private instance variables */
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private HangmanLexicon lexicon = new HangmanLexicon();
    
    private String secret;
    private String currentWord;
    private int guesses;
}
