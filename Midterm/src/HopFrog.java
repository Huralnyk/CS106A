/*
 * File: HopFrog.java
 * ------------------
 * This program puts an image of frog on the screen and
 * gets the frog to jump when the user clicks the mouse.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class HopFrog extends GraphicsProgram {
	
	/** Dimension of the grid in which the frog jumps */
	private static final int SQSIZE = 75;
	private static final int NCOLS = 7;
	private static final int NROWS = 3;
	
	/** Application dimensions  */
	public static final int APPLICATION_WIDTH = NCOLS * SQSIZE;
	public static final int APPLICATION_HEIGHT = NROWS * SQSIZE;
	
	/**
	 * Initializes the program.
	 * Puts the image of frog at the bottom of the graphics window
	 * centered horizontally.
	 */
	public void init() {
		frog.setSize(SQSIZE, SQSIZE);
		double x = (APPLICATION_WIDTH - SQSIZE) / 2;
		double y = APPLICATION_HEIGHT - SQSIZE;
		add(frog, x, y);
		addMouseListeners();
	}
	
	/**
	 * Called whenever the user clicks the mouse button.
	 * Gets the frog jump in the grid, specified by constants
	 * SQSIZE, NCOLS, NROWS.
	 */
	public void mouseClicked(MouseEvent e) {
		double dx = e.getX() - (frog.getX() + SQSIZE / 2);
		double dy = e.getY() - (frog.getY() + SQSIZE / 2);
		if (Math.abs(dx) > Math.abs(dy)) {
			dx /= Math.abs(dx);
			dy = 0;
		} else {
			dy /= Math.abs(dy);
			dx = 0;
		}
		jump(dx, dy);
	}
	
	/**
	 * Moves the frog on the graphics window on dx * SQSIZE, dy * SQSIZE pixels
	 * only if the frog stays inside the graphics window.
	 */
	private void jump(double dx, double dy) {
		double newX = frog.getX() + dx * SQSIZE;
		double newY = frog.getY() + dy * SQSIZE;
		if (newX >= 0 && newX <= getWidth() - SQSIZE &&
			newY >= 0 && newY <= getHeight() - SQSIZE) {
			frog.move(dx * SQSIZE, dy * SQSIZE);
		}
	}
	
	/** Private instance variables */
	private GImage frog = new GImage("frog.gif");
}
