/*
 * File: Pyramid.java
 * Name: Alexey Huralnyk
 * ------------------
 * This program draws a pyramid on the graphics window.
 * Pyramid is centered at the bottom of the window and
 * use constants BRICK_WIDTH, BRICK_HEIGHT, BRICKS_IN_BASE
 * to represent width of brick, height of brick and number
 * of bricks in base respectively. 
 */

import acm.graphics.*;
import acm.program.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 40;

/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 18;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 16;
	
	/* Runs the program */
	public void run() {
		/* Calculate x and y coordinate of the first brick in the base */
		int xOffset = (getWidth()  - BRICK_WIDTH * BRICKS_IN_BASE) / 2;
		int yOffset = getHeight() - BRICK_HEIGHT;
		int bricksInRow = BRICKS_IN_BASE;
		for (int i = 0; i < BRICKS_IN_BASE; i++) {
			for (int j = 0; j < bricksInRow; j++) {
				int x = j * BRICK_WIDTH + xOffset;
				int y = yOffset;
				GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
				add(brick);
			}
			xOffset += BRICK_WIDTH / 2;
			yOffset -= BRICK_HEIGHT;
			bricksInRow--;
		}
	}
}

