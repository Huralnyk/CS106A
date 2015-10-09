/*
 * Filename: UnitedNationsKarel.java
 * ---------------------------------
 * Karel starts off facing east at the corner of 1st Street and 
 * 1st Avenue with an infinite number beepers in its beeper bag.
 * At the end of running program Karel builds new house on each
 * corner where is a pile of debris represented by a beeper as
 * described in Section Handout #1 of Stanford CS106A course. 
 */

import stanford.karel.*;

public class UnitedNationsKarel extends SuperKarel {
	
	/*
	 * Runs Karel along the street to build new houses on the piles of debris.
	 */
	public void run() {
		while (frontIsClear()) {
			move();
			if (beepersPresent()) {
				cleanDebris();
				buildHouse();
				move();
			}
		}
	}
	
	/*
	 * Cleans up a pile of debris represented by a beeper.
	 * Pre-condition:	Standing on the corner with no more than one beeper
	 * Post-condition:	Standing on the corner with no beepers
	 */
	private void cleanDebris() {
		if (beepersPresent()) {
			pickBeeper();
		}
	}
	
	/*
	 * Builds a house on stilts.
	 * Pre-condition: 	Corners on the left and right must be empty
	 * and not blocked by wall 	
	 * Post-condition:	Stands right above fresh builded house between
	 * stilts, facing East
	 */
	private void buildHouse() {
		buildStilts();
		buildActualHouse();
	}
	
	/*
	 * Builds stilts which would hold future house.
	 * Pre-conditon:	Corners on the left and right must be empty
	 * and not blocked by wall
	 * Post-condition:	Stands between two stilts on the 1st street,
	 * facing East
	 */
	private void buildStilts() {
		moveBackward();
		buildTower();
		move();
		move();
		buildTower();
		moveBackward();
	}
	
	/*
	 * Builds an actual house between two stilts.
	 * Pre-condition:	Stands between two stilts on the 1st street,
	 * facing East
	 * Post-condition:	Stands right above fresh builded house between
	 * stilts, facing East
	 */
	private void buildActualHouse() {
		turnLeft();
		move();
		turnRight();
		buildTower();
		turnRight();
		move();
		turnLeft();
	}
	
	/*
	 * Builds 3 beepers height tower.
	 * Pre-condition:	Facing East with three not blocked and empty
	 * corners above the head
	 * Post-condition:	Standing at the bottom of tower
	 */
	private void buildTower() {
		turnLeft();
		putBeeper();
		for (int i = 0; i < 2; i++) {
			move();
			putBeeper();
		}
		turnAround();
		for (int i = 0; i < 2; i++) {
			move();
		}
		turnLeft();
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
