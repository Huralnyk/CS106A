/*
 * File: Target.java
 * Name: Alexey Huralnyk
 * -----------------
 * This program draws an archery target on the graphics window.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	
	/* Number of pixels in one inch */
	private static final int PIXELS_PER_INCH = 72;
	
	/* Radius of the outer circle */
	private static final double OUTER_RADIUS = 1 * PIXELS_PER_INCH;
	
	/* Radius of the middle circle */
	private static final double MIDDLE_RADIUS = 0.65 * PIXELS_PER_INCH;
	
	/* Radius of the inner circle */
	private static final double INNER_RADIUS = 0.3 * PIXELS_PER_INCH;
	
	/* Runs the program */
	public void run() {
		double x = getWidth() / 2;
		double y = getHeight() / 2;
		drawCircle(x, y, OUTER_RADIUS, Color.RED);
		drawCircle(x, y, MIDDLE_RADIUS, Color.WHITE);
		drawCircle(x, y, INNER_RADIUS, Color.RED);
	}
	
	/* 
	 * Draws a circle centered at the point (x, y) with a
	 * radius of r pixels, filled with the specified color.
	 */
	private void drawCircle(double x, double y, double r, Color color) {
		GOval circle = new GOval(x - r, y - r, 2 * r, 2 * r);
		circle.setFilled(true);
		circle.setColor(color);
		add(circle);
	}
}
