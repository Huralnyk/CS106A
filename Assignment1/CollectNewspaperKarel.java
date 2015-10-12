/*
 * File: CollectNewspaperKarel.java
 * Author: Alexey Huralnyk
 * --------------------------------
 * Karel starts off in the northwest corner of its house as shown
 * in the diagram in the Assignment #1 of the Stanford CS106A course.
 * At the end of running program Karel collects the newspaper 
 * represented by a beeper from outside the doorway and then  
 * returns to its initial position.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends Karel {
	
	/* Goes pick up newspaper and returns to home */
	public void run() {
		walkToTheDoor();
		pickUpNewspaper();
		returnHome();
	}
	
	/* Goes to outside the home right in front of the door */
	private void walkToTheDoor() {
		moveToWall();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	/* Picks up newspaper represented by a beeper */
	private void pickUpNewspaper() {
		if (beepersPresent()) {
			pickBeeper();
		}
	}
	
	/* Goes back to its initial position */
	private void returnHome() {
		turnAround();
		moveToWall();
		turnRight();
		moveToWall();
		turnRight();
	}
	
	/* Turns Karel 90 degrees to the right */
	private void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	/* Turns Karel around 180 degrees */
	private void turnAround() {
		turnLeft();
		turnLeft();
	}

	/*
	 * Moves Karel to the nearest wall.
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
