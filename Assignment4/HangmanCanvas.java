/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		setup();
		drawScaffold();
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		currentWord.setLabel(word);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		nGuesses++;
		String str = incorrectLetters.getLabel();
		incorrectLetters.setLabel(str + letter);
		evolvePicture(nGuesses);
	}
	
	/** 
	 * Instantiates and initializes labels to draw current word
	 * and incorrect letters in it and puts them to the canvas.
	 * Also resets number of guesses user made to zero.
	 */
	private void setup() {
		nGuesses = 0;
		
		currentWord = new GLabel("");
		currentWord.setFont("Courier New-24-bold");
		double y = getHeight() - INFO_SECTION_HEIGHT;
		double x = INFO_SECTION_X_OFFSET;
		add(currentWord, x, y);
		
		incorrectLetters = new GLabel("");
		incorrectLetters.setFont("Courier New-18");
		y += currentWord.getHeight();
		add(incorrectLetters, x, y);
	}
	
	/**
	 * Draws a part of Hangman body corresponding to an incorrect guess.
	 * @param guess Number of incorrect guess.
	 */
	private void evolvePicture(int guess) {
		switch (guess) {
			case 1: drawHead(); break;
			case 2: drawBody(); break;
			case 3: drawArm(LEFT); break;
			case 4: drawArm(RIGHT); break;
			case 5: drawLeg(LEFT); break;
			case 6: drawLeg(RIGHT); break;
			case 7: drawFoot(LEFT); break;
			case 8: drawFoot(RIGHT); break;
		}
	}
	
	private void drawScaffold() {
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		sx = cx - BEAM_LENGTH;
		sy = cy - SCAFFOLD_HEIGHT / 2 - INFO_SECTION_HEIGHT / 2;
		add(new GLine(sx, sy, sx, sy + SCAFFOLD_HEIGHT));
		add(new GLine(cx, sy, cx - BEAM_LENGTH, sy));
		add(new GLine(cx, sy, cx, sy + ROPE_LENGTH));
	}
	
	private void drawHead() {
		double x = getWidth() / 2 - HEAD_RADIUS;
		double y = sy + ROPE_LENGTH;
		add(new GOval(x, y, 2 * HEAD_RADIUS, 2 * HEAD_RADIUS));
	}
	
	private void drawBody() {
		double x = getWidth() / 2;
		double y = sy + ROPE_LENGTH + 2 * HEAD_RADIUS;
		add(new GLine(x, y, x, y + BODY_LENGTH));
	}
	
	private void drawArm(int side) {
		double x0 = getWidth() / 2;
		double y0 = sy + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD;
		double x1 = x0 + side * UPPER_ARM_LENGTH;
		double y1 = y0;
		add(new GLine(x0, y0, x1, y1));
		add(new GLine(x1, y1, x1, y1 + LOWER_ARM_LENGTH));
	}
	
	private void drawLeg(int side) {
		double x0 = getWidth() / 2;
		double y0 = sy + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH;
		double x1 = x0 + side * HIP_WIDTH;
		double y1 = y0;
		add(new GLine(x0, y0, x1, y1));
		add(new GLine(x1, y1, x1, y1 + LEG_LENGTH));
	}
	
	private void drawFoot(int side) {
		double x0 = getWidth() / 2 + side * HIP_WIDTH;
		double y0 = sy + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH;
		double x1 = x0 + side * FOOT_LENGTH;
		double y1 = y0;
		add(new GLine(x0, y0, x1, y1));
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	
	private static final int INFO_SECTION_HEIGHT = 60;
	private static final int INFO_SECTION_X_OFFSET = 30;
	
	private static final int LEFT = -1;
	private static final int RIGHT = 1;
	
	/** Private instance variables */
	private GLabel currentWord;			// current word label
	private GLabel incorrectLetters;	// incorrect letters label
	private double sx;					// scaffold's x-coordinate
	private double sy;					// scaffold's y-coordinate
	private int nGuesses;				// number of guesses
}
