/*
 * File: StoneMasonKarel.java
 * Author: Alexey Huralnyk
 * --------------------------
 * Karel starts at 1st Avenue and 1st Street, facing East,
 * with an infinite number of beepers in Karel’s beeper bag.
 * At the end of running program Karel repairs all the arches
 * on the every fourth corner which are represented with column
 * of beepers as described in Assignment #4 of Stanford 
 * CS106A course. 
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	/* Repairs the arches on every fourth corner */
	public void run() {
		while (frontIsClear()) {
			repairArc();
			descendArc();
			moveToArc();
		}
		repairArc();
		descendArc();
	}
	
	/*
	 * Repairs one arc
	 * Pre-condition: 	Standing on the bottom of arc facing East
	 * Post-condition:	Standing on the top of the repaired arc
	 * facing East
	 */
	private void repairArc() {
		turnLeft();
		while (frontIsClear()) {
			checkForHole();
			move();
		}
		checkForHole();
		turnRight();
	}
	
	/*
	 * Descends from repaired arc
	 * Pre-condition:	Standig on the top of the arc facing East
	 * Post-condition: 	Standing on the bottom of repaired arc
	 * facing East
	 */
	private void descendArc() {
		turnRight();
		moveToWall();
		turnLeft();
	}
	
	/*
	 * Checks for hole in arc and fixes it.
	 * Pre-condition:	none
	 * Post-conditon:	One beeper placed on the corner
	 */
	private void checkForHole() {
		if (noBeepersPresent()) {
			putBeeper();
		}
	}
	
	/*
	 * Moves to the next arc in four avenues.
	 * Pre-condition:	Standing on the bottom of the arc facing East
	 * Post-condition:	Standing on the bottom ot the arc four
	 * corners to the East from the previous one.
	 */
	private void moveToArc() {
		for (int i = 0; i < 4; i++) {
			move();
		}
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
