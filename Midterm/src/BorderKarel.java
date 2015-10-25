/*
 * File: BorderKarel.java
 * ----------------------
 * In this program Karel creates an inside border
 * around the world.
 */

import stanford.karel.*;

public class BorderKarel extends SuperKarel {
	
	/** Runs the program */
	public void run() {
		goToInitialPoint();
		for (int i = 0; i < 4; i++) {
			createBorder();
			repositionToNextDirection();
		}
	}
	
	/** 
	 * Places Karel on the corner of the 2nd Street and 2nd Avenue, facing East.
	 * Precondition: Karel is on corner of 1st Str and 1st Ave, facing East.
	 * Postcondition: Karel is on the corner of 2nd Str and 2nd Ave, facing East.
	 */
	private void goToInitialPoint() {
		move();
		turnLeft();
		move();
		turnRight();
	}
	
	/**
	 * Creates border along the street Karel is facing.
	 * Precondition: Karel is in the 2nd cell in a row.
	 * Postcondition: Karel is on the last corner in a row with
	 * a line of beepers behind him, facing same direction as before.
	 */
	private void createBorder() {
		while (frontIsClear()) {
			if (noBeepersPresent()) {
				putBeeper();
			}
			move();
		}
	}
	
	/**
	 * Turns Karel counterclockwise direction and places him on
	 * the 2nd corner of a row.
	 * Precondition: Karel is in the last cell of a row.
	 * Postcondition: Karel is in the 2nd cell of row or column,
	 * turned left.
	 */
	private void repositionToNextDirection() {
		moveBackward();
		turnLeft();
	}
	
	/**
	 * Moves Karel on step backward.
	 */
	private void moveBackward() {
		turnAround();
		move();
		turnAround();
	}
}
