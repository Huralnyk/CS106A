/**
 * File: RandomCircles.java
 * ------------------------
 * @author Alexey Huralnyk
 * 
 * This program draws a set of then circles with different sizes,
 * positions and colors. Randomly chosen radius of each circle is
 * between MIN_RADIUS and MAX_RADIUS constant values. Each circle
 * is positioned inside the canvas without extending past the edge.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.*;

public class RandomCircles extends GraphicsProgram {
	
	/** Number of circles to draw */
	private static final int NCIRCLES = 10;
	
	/** Minimal radius of a circle */
	private static final int MIN_RADIUS = 5;
	
	/** Maximal radius of a circle */
	private static final int MAX_RADIUS = 50;
	
	/**
	 * Runs the program
	 */
	public void run() {
		for (int i = 0; i < NCIRCLES; i++) {
			int r = rgen.nextInt(MIN_RADIUS, MAX_RADIUS);
			int x = rgen.nextInt(r, getWidth() - r);
			int y = rgen.nextInt(r, getHeight() - r);
			add(createFilledCircle(x, y, r, rgen.nextColor()));
		}
	}
	
	/**
	 * Creates new filled circle which is actually GOval object.
	 * @param x X coordinate of a circle
	 * @param y Y coordinate of a circle
	 * @param r Radius of a circle
	 * @param c Color of a circle
	 * @return Filled circled which is GOval object.
	 */
	private GOval createFilledCircle(int x, int y, int r, Color c) {
		GOval circle = new GOval(x - r, y - r, r * 2, r * 2);
		circle.setFilled(true);
		circle.setColor(c);
		return circle;
	}
	/** Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
