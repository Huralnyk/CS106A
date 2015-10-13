/*
 * File: RobotFace.java
 * --------------------
 * This program draws a robot face using GRects and GOvals.
 * We make sure to define constants at the top of our program instead
 * of using magic numbers. We also write the program in terms of
 * reusable and general methods drawRectange and drawCircle.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class RobotFace extends GraphicsProgram {
	
	/* Parameters for the drawing */
	private static final int HEAD_WIDTH = 150;
	private static final int HEAD_HEIGHT = 250;
	private static final int EYE_RADIUS = 10;
	private static final int MOUTH_WIDTH = 60;
	private static final int MOUTH_HEIGHT = 20;
	
	/* Draw the entire face centered in the graphics window */
	public void run() {
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		drawHead(cx - HEAD_WIDTH / 2, cy - HEAD_HEIGHT / 2);
		drawEye(cx - HEAD_WIDTH / 4, cy - HEAD_HEIGHT / 4);
		drawEye(cx + HEAD_WIDTH / 4, cy - HEAD_HEIGHT / 4);
		drawMouth(cx - MOUTH_WIDTH / 2, cy + HEAD_HEIGHT / 4);
	}
	
	/*
	 * Add a head with top left at position x, y. Adding a head consists
	 * of drawing a rectangle with the given width, height and color.
	 */
	private void drawHead(double x, double y) {
		drawRectangle(x, y, HEAD_WIDTH, HEAD_HEIGHT, Color.GRAY);
	}
	
	/*
	 * Add an eye centered at cx, cy. Adding an eye consists of drawing
	 * a circle with the given radius and color.
	 */
	private void drawEye(double cx, double cy) {
		drawCircle(cx, cy, EYE_RADIUS, Color.YELLOW);
	}
	
	/*
	 * Add a mouth with top left at x, y. Adding a mouth consists of
	 * drawing a rectangle with given width, height and color.
	 */
	private void drawMouth(double x, double y) {
		drawRectangle(x, y, MOUTH_WIDTH, MOUTH_HEIGHT, Color.WHITE);
	}
	
	/*
	 * This method draws a general rectangle with its top left
	 * at position x, y with a specified width, height and color.
	 */
	private void drawRectangle(double x, double y, double width,
							   double height, Color color) {
		GRect rect = new GRect(x, y, width, height);
		rect.setFilled(true);
		rect.setColor(color);
		add(rect);
	}
	
	/*
	 * This method draws a general circle centered at (cx, cy),
	 * with a given radius r and a Color c.
	 */
	private void drawCircle(double cx, double cy, double r, Color c) {
		double x = cx - r;
		double y = cy - r;
		GOval circle = new GOval(2 * r, 2 * r);
		circle.setFilled(true);
		circle.setColor(c);
		add(circle, x, y);
	}
}
