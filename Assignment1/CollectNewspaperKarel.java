/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends Karel {
	
	public void run() {
		walkToTheDoor();
		pickUpNewspaper();
		returnHome();
	}
	
	private void walkToTheDoor() {
		moveToWall();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	private void pickUpNewspaper() {
		if (beepersPresent()) {
			pickBeeper();
		}
	}
	
	private void returnHome() {
		turnAround();
		moveToWall();
		turnRight();
		moveToWall();
		turnRight();
	}
	
	private void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	private void turnAround() {
		turnLeft();
		turnLeft();
	}

	/*
	 * Moves to the nearest wall.
	 * Pre-condition:	none
	 * Post-condition:	Facing first wall in whichever direction
	 * Karel was facing previously 
	 */
	private void moveToWall() {
		while (frontIsClear()) {
			move();
		}
	}
}
