/*
 * File: CheckerboardKarel.java
 * Author: Alexey Huralnyk
 * ----------------------------
 * Karel draws a checkerboard using beepers. Solution based on pattern using
 * in CleanupKarel program providing in Handout #9 "Example Karel Problems"
 * by Mehran Sahami as part of cs109a course handouts.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		// Check if world is only one column wide
		if (frontIsBlocked()) {
			// If so just turn Karel left to draw only one line.
			turnLeft();
		}
		drawLine();
		while (leftIsClear()) {
			repositionForRowToWest();
			drawLine();
			if (rightIsClear()) {
				repositionForRowToEast();
				drawLine();
			} else {
				turnAround();
			}
		}
	}
	
	/*
	 * Draws a single line with checkboard pattern.
	 * Pre-condition:	none
	 * Post-conditon:	Facing first wall in whichever direction
	 * Karel was facing previously.
	 */
	private void drawLine() {
		putBeeper();
		while (frontIsClear()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			}
		}
	}
	
	/*
	 * Pre-condition:	Facing wall in East direction with no wall 
	 * above the head.
	 * Post-condition:	Facing West on the row right above previous
	 * one. If there was a beeper on the previous corner Karel moved
	 * one corner to the East.
	 */
	private void repositionForRowToWest() {
		if (beepersPresent()) {
			moveBackward();
		}
		turnLeft();
		move();
		turnLeft();
	}
	
	/*
	 * Pre-condition:	Facing wall in West direction with no wall 
	 * above the head.
	 * Post-condition:	Facing East on the row right above previous
	 * one. If there was a beeper on the previous corner Karel moved
	 * one corner to the East.
	 */
	private void repositionForRowToEast() {
		if (beepersPresent()) {
			move();
		}
		turnRight();
		move();
		turnRight();
	}
	
	/*
	 * Pre-condition:	There is a no-blocked corner behind Karel
	 * Post-condition:  Standing one corner behind facind same
	 * direction as before.
	 */
	private void moveBackward() {
		turnAround();
		move();
		turnAround();
	}
}
