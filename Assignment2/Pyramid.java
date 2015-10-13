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
		for (int i = 0; i < BRICKS_IN_BASE; i++) {
			double y = (getHeight() - BRICK_HEIGHT) - i * BRICK_HEIGHT;
			drawRow(y, BRICKS_IN_BASE - i);
		}
	}
	
	/* 
	 * Draws a row of bricks centered on the graphics window with
	 * specified number of bricks and top position by parameters
	 * y and numBricks respectively.
	 */
	private void drawRow(double y, int numBricks) {
		double width = BRICK_WIDTH * numBricks;
		double x = (getWidth() - width) / 2;
		for (int i = 0; i < numBricks; i++) {
			add(new GRect((x + i * BRICK_WIDTH), y, BRICK_WIDTH, BRICK_HEIGHT));
		}
	}
}

