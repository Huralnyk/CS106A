/*
 * File: SwapExample.java
 * ----------------------
 * This program shows an example of using array
 * when swapping values.
 */

import acm.program.*;

public class SwapExample extends ConsoleProgram {

	public void run() {
		setFont("Courier New-bold-24");
		
		int[] array = new int[5];
		array[0] = 1;
		array[1] = 2;
		
		println("Buggy swap results:");
		swapElementsBuggy(array[0], array[1]);
		println("array[0] = " + array[0]);
		println("array[1] = " + array[1]);
		
		println("Happy swap results:");
		swapElementsHappy(array, 0, 1);
		println("array[0] = " + array[0]);
		println("array[1] = " + array[1]);
	}
	
	private void swapElementsBuggy(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}
	
	private void swapElementsHappy(int[] arr, int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
}
