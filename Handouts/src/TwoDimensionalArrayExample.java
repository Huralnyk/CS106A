/*
 * File: TwoDimensionalArrayExample.java
 * -------------------------------------
 * This program shows an example of using 2-dimensional arrays.
 */

import acm.program.*;

public class TwoDimensionalArrayExample extends ConsoleProgram {
	
	private static final int ROWS = 2;
	private static final int COLS = 3;
	
	public void run() {
		setFont("Courier New-bold-24");
		
		int[][] arr = new int[ROWS][COLS];
		initMatrix(arr);
		printMatrix(arr);
	}
	
	private void initMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = j;
			}
		}
	}

	private void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				print(matrix[i][j] + " ");
			}
			println();
		}
	}
}
