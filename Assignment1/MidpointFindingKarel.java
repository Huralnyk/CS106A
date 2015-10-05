/*
 * File: MidpointFindingKarel.java
 * Author: Alexey Huralnyk
 * -------------------------------
 * Karel starts at corner of 1st Street and 1st Avenue facing East.
 * At the end of running program Karel leaves a beeper on the corner
 * closest to the center of 1st Street (or either of the two central
 * corners if 1st Street has an even number of corners). Solution
 * uses recursive algorithm of finding midpoint.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	/* Places a beeper on the center of 1st Street */
	public void run() {
		goToMidpoint();
		putBeeper();
	}
	
	/* 
	 * Pre-condition: 	none
	 * Post-condition: 	Karel standing on the center corner of the
	 * street he was standing previously, facing the same direction.
	 */
	private void goToMidpoint() {
		moveWithCheckForWall();
		moveWithCheckForWall();
		if (frontIsClear()) {
			goToMidpoint();
		}
		moveBackwardWithCheckForWall();
	}
	
	/*
	 * Pre-condition:	none
	 * Post-condition:	Karel standing on the next corner if it's not
	 * blocked by the wall. Another way Karel standing on the same corner.
	 * In both cases Karel faces same direction as before.
	 */
	private void moveWithCheckForWall() {
		if (frontIsClear()) {
			move();
		}
	}
	
	/*
	 * Pre-condition:	none
	 * Post-condition:	Karel standing on the previous corner if it's not
	 * blocked by the wall. Another way Karel standing on the same corner.
	 * In both cases Karel faces same direction as before.
	 */
	private void moveBackwardWithCheckForWall() {
		turnAround();
		moveWithCheckForWall();
		turnAround();
	}
}
