/*
 * File: AverageScores.java
 * ------------------------
 * This program shows an example of using arrays.
 */

import acm.program.*;

public class AverageScores extends ConsoleProgram {
	
	private static final int SENTINEL = -1;
	private static final int MAX_SCORES = 1000;	// actual size
	
	public void run() {
		setFont("Courier New-24-bold");
		
		int[] midtermScores = new int[MAX_SCORES];
		int numScores = 0;						// effective size
		
		while (true) {
			int score = readInt("Score: ");
			if (score == SENTINEL) break;
			midtermScores[numScores++] = score;
		}
		
		double averageScore = computeAverage(midtermScores, numScores);
		
		println("Average score: " + averageScore);
	}
	
	private double computeAverage(int[] arr, int numScores) {
		double average = 0;
		for (int i = 0; i < numScores; i++) {
			average += arr[i];
		}
		average = average / numScores;
		return average;
	}

}
