/*
 * File: TestScores.java
 * ---------------------
 */

import acm.program.*;

public class TestScores extends ConsoleProgram {

	// Maximum number of students in a course
	private static final int MAX_STUDENTS = 1000;
	
	public void run() {
		setFont("Times New Roman-24");
		
		int numScores = readInt("Number of scores per student: ");
		scores = new int[MAX_STUDENTS][numScores];
		
		initScores();
		
		println("Scores[0] before increment");
		printList(scores[0]);
		
		incrementScoreList(scores[0]);
		println("Scores[0] after increment");
		printList(scores[0]);
	}
	
	// Initialized score grid to all be 0
	private void initScores() {
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[0].length; j++) {
				scores[i][j] = 0;
			}
		}
	}
	
	// Prints every element of list on a separate line
	private void printList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			println(list[i]);
		}
	}
	
	// Adds 1 to every element of list
	private void incrementScoreList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			list[i]++;
		}
	}
	
	/* Private instance variables */
	private int[][] scores;

}
