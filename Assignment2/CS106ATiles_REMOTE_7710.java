/*
 * File: CS106ATiles.java
 * Name: Alexey Huralnyk
 * ----------------------
 * This program draws a set of four tiles containing the text "CS106A"
 * on the center of graphics window. Space between tiles specified by
 * constant TILE_SPACE.
 */

import acm.graphics.*;
import acm.program.*;

public class CS106ATiles extends GraphicsProgram {
	
	/** Amount of space (in pixels) between tiles */
	private static final int TILE_SPACE = 20;
	
	/** Width of the tile */
	private static final int TILE_WIDTH = 120;
	
	/** Height of the tile */
	private static final int TILE_HEIGHT = 60;
	
	/** Number of rows in a tile grid */
	private static final int NROWS = 2;
	
	/** Number of columns in a tile grid */
	private static final int NCOLUMNS = 2;

	/* Runs the program */
	public void run() {
		/* Calculate x and y coordinate of the entire tile grid */
		double width = NCOLUMNS * TILE_WIDTH + (NCOLUMNS - 1) * TILE_SPACE;
		double height = NROWS * TILE_HEIGHT + (NROWS - 1) * TILE_SPACE;
		double x = (getWidth() - width) / 2;
		double y = (getHeight() - height) / 2;
		drawGrid(x, y);
	}
	
	/*
	 * Draws a tile grid with top left at (x, y)
	 */
	private void drawGrid(double x, double y) {
		for (int i = 0; i < NROWS; i++) {
			for (int j = 0; j < NCOLUMNS; j++) {
				double gx = x + j * (TILE_WIDTH + TILE_SPACE);
				double gy = y + i * (TILE_HEIGHT + TILE_SPACE);
				drawTile(gx, gy, "CS106A");
			}
		}
	}
	
	/* 
	 * Draws a tile containing specified text in the center
	 * and puts its top left at (x,y).
	 */
	private void drawTile(double x, double y, String text) {
		GRect rect = new GRect(x, y, TILE_WIDTH, TILE_HEIGHT);
		GLabel label = new GLabel(text);
		double labelX = x + (TILE_WIDTH - label.getWidth()) / 2;
		double labelY = y + (TILE_HEIGHT - label.getHeight()) / 2 + label.getAscent();
		label.setLocation(labelX, labelY);
		add(rect);
		add(label);
	}
}

