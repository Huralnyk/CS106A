/*
 * File: SimpleFrogger.java
 * ------------------------
 * This program solves the Frogger problem from the practice midterm.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

/*
 * This program gets a frog to jump one square in the closest
 * direction to a mouse click.
 */
public class SimpleFrogger extends GraphicsProgram {
	
	public void run() {
		frog = new GImage("frog.gif");
		fx = (NCOLS / 2 + 0.5) * SQSIZE;
		fy = (NROWS - 0.5) * SQSIZE;
		add(frog, fx - frog.getWidth() / 2, fy - frog.getHeight() / 2);
		addMouseListeners();
	}
	
	/* Responds to a mouse click */
	public void mouseClicked(MouseEvent e) {
		double mx = e.getX();
		double my = e.getY();
		if (Math.abs(mx - fx) > Math.abs(my - fy)) {
			if (mx > fx) {
				moveFrog(SQSIZE, 0);
			} else {
				moveFrog(-SQSIZE, 0);
			}
		} else {
			if (my > fy) {
				moveFrog(0, SQSIZE);
			} else {
				moveFrog(0, -SQSIZE);
			}
		}
	}
	
	/* Moves the frog by dx/dy as long as it remains inside the world */
	private void moveFrog(double dx, double dy) {
		if (insideFroggerWorld(fx + dx, fy + dy)) {
			fx += dx;
			fy += dy;
			frog.move(dx, dy);
		}
	}
	
	/* Returns true if the point (x, y) is inside the frog's world */
	private boolean insideFroggerWorld(double x, double y) {
		return (x >= 0 && x <= NCOLS * SQSIZE &&
				y >= 0 && y <= NROWS * SQSIZE);
	}
	
	/* Private constants */
	private static final int SQSIZE = 75;
	private static final int NROWS = 4;
	private static final int NCOLS = 7;
	
	/* Private instance variables */
	private GImage frog;	/* The image of the frog */
	private double fx;		/* The x-coordinate of the frog's center */
	private double fy;		/* The y-coordinate of the frog's center */
	
	/* Sets the graphics window size */
	public static final int APPLICATION_WIDTH = NCOLS * SQSIZE;
	public static final int APPLICATION_HEIGHT = NROWS * SQSIZE;
}
