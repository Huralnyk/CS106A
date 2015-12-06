import acm.program.*;

public class SudokuSimple extends ConsoleProgram {
	
	public void run() {
		int[][] matrix = {
				{1,1,1,0,0,0,0,0,0},
				{1,1,1,0,0,0,0,0,0},
				{1,1,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
		};
		
		if (checkUpperLeftCorner(matrix)) {
			println("Valid");
		} else {
			println("Invalid");
		}
	}
	
	private boolean checkUpperLeftCorner(int[][] matrix) {
		int[] numbers = new int[9];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int value = matrix[i][j];
				numbers[value-1]++;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] != 1) return false;
		}
		return true;
	}

}
