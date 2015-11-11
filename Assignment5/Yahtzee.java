/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	/** Runs the program */
	public void run() {
		setup();
		playGame();
		endGame();
	}
	
	/** Initializes all instance variables */
	private void setup() {
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		playerNames = new String[nPlayers];
		initScorecard();
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
	}
	
	/** 
	 * Initializes scorecard for players with initial SENTINEL value,
	 * but leaves score for TOTAL category equals to 0.
	 */
	private void initScorecard() {
		scorecard = new int[nPlayers][N_CATEGORIES];
		for (int i = 0; i < nPlayers; i++) {
			for (int j = 0; j < N_CATEGORIES; j++) {
				if (j != TOTAL - 1) scorecard[i][j] = SENTINEL;
				
			}
		}
	}

	/** Plays the game */
	private void playGame() {
		while (!gameIsOver()) {
			for (int player = 1; player <= nPlayers; player++) {
				playRound(player);
			}
			scoredCategories++;
		}
	}
	
	/** 
	 * Ends the game with calculating total scores for 
	 * each player and congratulates the winner.
	 */
	private void endGame() {
		updateFinalScores();
		congratulateWinner();
	}
	
	/** Calculates final scores and updates display */
	private void updateFinalScores() {
		for (int player = 1; player <= nPlayers; player++) {
			int upperScore = getUpperScore(player);
			int bonus = upperScore >= 63 ? BONUS_SCORE : 0;
			display.updateScorecard(UPPER_SCORE, player, upperScore);
			display.updateScorecard(UPPER_BONUS, player, bonus);
		}
	}
	
	/** Calculates upper score for specified player */
	private int getUpperScore(int player) {
		int score = 0;
		for (int i = 0; i < UPPER_SCORE; i++) {
			score += scorecard[player - 1][i];
		}
		return score;
	}
	
	/** Congratulates the winner */
	private void congratulateWinner() {
		String name = "";
		int score = 0;
		for (int i = 0; i < nPlayers; i++) {
			int total = scorecard[i][TOTAL - 1];
			if (total > score) {
				score = total;
				name = playerNames[i];
			}
		}
		String message = "Congratulations, " + name + 
						 ", you're the winner with a total of " + score + "!";
		display.printMessage(message);
	}
	
	/** Plays one round for the specified player */
	private void playRound(int player) {
		String name = playerNames[player - 1];
		
		String message = name + "'s turn! Click the \"Roll Dice\" button to roll the dice.";
		display.printMessage(message);
		display.waitForPlayerToClickRoll(player);
		rollDice();
		
		message = "Select the dice you wish to re-roll and click \"Roll Again\"";
		for (int i = 0; i < 2; i++) {
			display.printMessage(message);
			display.waitForPlayerToSelectDice();
			rerollDice();
		}
		
		message = "Select a category for this roll";
		int category = choseeCategoryForPlayer(player);
		int score = scoreForCategery(category);
		scorecard[player - 1][TOTAL - 1] += score;
		scorecard[player - 1][category - 1] = score;
		display.updateScorecard(category, player, score);
		int total = scorecard[player - 1][TOTAL - 1];
		display.updateScorecard(TOTAL, player, total);
	}
	
	/**
	 * Checks whether game is over, which is true when
	 * all categories have been already scored.
	 */
	private boolean gameIsOver() {
		return scoredCategories >= N_SCORING_CATEGORIES;
	}
	
	/**
	 * Rolls the dice first time.
	 */
	private void rollDice() {
		for (int i = 0; i < N_DICE; i++) {
			dice[i] = rgen.nextInt(1, 6);
		}
		display.displayDice(dice);
	}
	
	/**
	 * Re-rolls selected dice.
	 */
	private void rerollDice() {
		for (int i = 0; i < N_DICE; i++) {
			if (display.isDieSelected(i)) {
				dice[i] = rgen.nextInt(1, 6);
			}
		}
		display.displayDice(dice);
	}
	
	/**
	 * Calculates score for the specified category.
	 */
	private int scoreForCategery(int category) {
		
		if (checkCategory(dice, category)) {
			switch (category) {
				case ONES: case TWOS: case THREES:
				case FOURS: case FIVES: case SIXES:
					return sumOfValues(category, dice);
					
				case THREE_OF_A_KIND: case FOUR_OF_A_KIND: case CHANCE:
					return sumOfArray(dice);
					
				case FULL_HOUSE:
					return 25;
				
				case SMALL_STRAIGHT:
					return 30;
				
				case LARGE_STRAIGHT:
					return 40;
				
				case YAHTZEE:
					return 50;
			}
		} 
		
		return 0;
	}
	
	/**
	 * Selects the category, if it's not already scored for
	 * specified player.
	 */
	private int choseeCategoryForPlayer(int player) {
		while (true) {
			int category = display.waitForPlayerToSelectCategory();
			if (scorecard[player - 1][category - 1] == -1) return category;
			String message = "You already picked that category. Please choose another category";
			display.printMessage(message);
		}
	}
	
	/**
	 * Sums all specified values in an array.
	 */
	private int sumOfValues(int value, int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			int n = array[i];
			if (n == value) {
				sum += n;
			}
		}
		return sum;
	}
	
	/**
	 * Sums all values in an array.
	 */
	private int sumOfArray(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
	
	/**
	 * Checks whether specified category is scored.
	 */
	private boolean checkCategory(int[] dice, int category) {
		int[] occurrences = getOccurrences(dice);
		
		switch (category) {
			case ONES: case TWOS: case THREES: case FOURS:
			case FIVES: case SIXES: case CHANCE:
				return true;
				
			case THREE_OF_A_KIND: 
				for (int i = 0; i < occurrences.length; i++) {
					if (occurrences[i] >= 3) return true;
				}
				
			case FOUR_OF_A_KIND: 
				for (int i = 0; i < occurrences.length; i++) {
					if (occurrences[i] >= 4) return true;
				}
				
			case YAHTZEE:
				for (int i = 0; i < occurrences.length; i++) {
					if (occurrences[i] == 5) return true;
				}
				
			case FULL_HOUSE:
				boolean hasDouble = false;
				boolean hasTriple = false;
				for (int i = 0; i < occurrences.length; i++) {
					if (occurrences[i] == 2) hasDouble = true;
					if (occurrences[i] == 3) hasTriple = true; 
				}
				return hasDouble && hasTriple;
				
			case SMALL_STRAIGHT: case LARGE_STRAIGHT:
				return checkForStraight(occurrences, category);
				
			default: return false;
		}
	}
	
	/** Returns array of occurrences for each value on dice */
	private int[] getOccurrences(int[] dice) {
		int[] ocurrences = new int[6];
		for (int i = 0; i < dice.length; i++) {
			int index = dice[i] - 1;
			ocurrences[index] += 1; 
		}
		return ocurrences;
	}
	
	/** Checks whether given category scored for a straight */
	private boolean checkForStraight(int[] occurrences, int category) {
		int straightLength = category == SMALL_STRAIGHT ? 4 : 5;
		for (int i = 0; i < occurrences.length; i++) {
			int n = occurrences[i];
			if (n != 0 && i <= occurrences.length - straightLength) {
				boolean inStraight = true;
				for (int j = 0; j < straightLength; j++) {
					if (occurrences[i + j] == 0) inStraight = false;
				}
				if (inStraight) return true;
			}
		}
		return false;
	}
		
	/* Private instance variables */
	private int nPlayers;
	private int scoredCategories = 0;
	private int[] dice = new int[N_DICE];
	private int[][] scorecard;
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();

	/* Private constants */
	private static final int SENTINEL = -1;
	private static final int BONUS_SCORE = 35;
}
