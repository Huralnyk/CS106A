/*
 * File: Breakout.java
 * -------------------
 * Name: Alexey Huralnyk
 * Section Leader:
 * 
 * This file implements the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels.  On some platforms 
  * these may NOT actually be the dimensions of the graphics canvas. */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board.  On some platforms these may NOT actually
  * be the dimensions of the graphics canvas. */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;	  

/** Width of a row of bricks */
	private static final int ROW_WIDTH = 
	  (NBRICKS_PER_ROW - 1) * BRICK_SEP + NBRICKS_PER_ROW * BRICK_WIDTH;
	
/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	
/** Animation cycle delay */
	private static final int DELAY = 10;
	
/** Starting Y velocity*/
	private static final int Y_VEL = 3;

/* Method: run() */
	
	public void init() {
		addMouseListeners();
	}
/** Runs the Breakout program. */
	public void run() {
		setup();
		while (!gameIsOver()) {
			dropBall();
			moveBall();
			checkForCollision();
			pause(DELAY);
		}
		presentFeedback();
	}
	
	/** Initial preparation for a game */
	private void setup() {
		setupBricks();
		setupPaddle();
	}
	
	/**
	 * Checks whether game is over. Game overs when
	 * user runs out of turns or all bricks are hit.
	 */
	private boolean gameIsOver() {
		return turn >= NTURNS || nBricksRemaining == 0;
	}
	
	/**
	 * Drops ball on the center of the screen and waits for click
	 * to start moving it whenever it's new turn (when ball is null).
	 */
	private void dropBall() {
		if (ball == null) {
			ball = createFilledCircle(getWidth() / 2, getHeight() / 2, BALL_RADIUS);
			add(ball);
			vx = rgen.nextDouble(1.0, 3.0);
			vy = Y_VEL;
			if (rgen.nextBoolean()) vx = -vx;
			waitForClick();
		}
	}
	
	/** 
	 * Moves the ball on the screen.
	 */
	private void moveBall() {
		ball.move(vx, vy);
	}
	
	/** 
	 * Checks ball for collision with bricks or walls
	 */
	private void checkForCollision() {
		GObject collider = getCollidingObject();
		if (collider == null) {
			checkForCollisionWithBounds();
		} else {
			vy = -vy;
			bounceClip.play();
			if (collider != paddle) {
				remove(collider);
				nBricksRemaining--;
			}
		}
	}
	
	/**
	 * Gets graphical object which is collides with ball.
	 * If there is no one return null.
	 * @return GObject which is collided with ball.
	 */
	private GObject getCollidingObject() {
		double x = ball.getX();
		double y = ball.getY();
		if (getElementAt(x, y) != null) {
			return getElementAt(x, y);
		}
		if (getElementAt(x, y + 2 * BALL_RADIUS) != null) {
			return getElementAt(x, y + 2 * BALL_RADIUS);
		}
		if (getElementAt(x + 2 * BALL_RADIUS, y) != null) {
			return getElementAt(x + 2 * BALL_RADIUS, y);
		}
		if (getElementAt(x + 2 * BALL_RADIUS, y + 2 * BALL_RADIUS) != null) {
			return getElementAt(x + 2 * BALL_RADIUS, y + 2 * BALL_RADIUS);
		}
		return null;
	}
	
	/** 
	 * Checks for collision with walls
	 */
	private void checkForCollisionWithBounds() {
		double x = ball.getX();
		double y = ball.getY();
		if (x < 0 || x > getWidth() - 2 * BALL_RADIUS) {
			vx = -vx;
		}
		if (y < 0) {
			vy = -vy;
		} else if (y > getHeight() - 2 * BALL_RADIUS) {
			remove(ball);
			ball = null;
			turn++;
		}
	}
	
	/**
	 * Draws the grid of bricks at the top of the screen.
	 */
	private void setupBricks() {
		for (int i = 0; i < NBRICK_ROWS; i++) {
			Color c = colorForRow(i);
			drawRow(BRICK_Y_OFFSET + i * (BRICK_HEIGHT + BRICK_SEP), c);
		}
		nBricksRemaining = NBRICKS_PER_ROW * NBRICK_ROWS;
	}
	
	/**
	 * Draws a paddle at the bottom of the screen.
	 */
	private void setupPaddle() {
		int x = (getWidth() - PADDLE_WIDTH) / 2;
		int y = getHeight() - PADDLE_HEIGHT - PADDLE_Y_OFFSET;
		paddle = createFilledRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT, Color.BLACK);
		add(paddle);
	}
	
	/**
	 * Draws row of the bricks.
	 * @param y	The y-coordinate of the row
	 * @param c	The color of the row
	 */
	private void drawRow(int y, Color c) {
		int dx = (WIDTH - ROW_WIDTH) / 2;
		for (int i = 0; i < NBRICKS_PER_ROW; i++) {
			int x = dx + i * (BRICK_WIDTH + BRICK_SEP);
			add(createFilledRect(x, y, BRICK_WIDTH, BRICK_HEIGHT, c));
		}
	}
	
	/**
	 * Creates filled GRect object.
	 * @param x 		The x-coordinate of the rectangle
	 * @param y 		The x-coordinate of the rectangle
	 * @param width 	The width of the rectangle
	 * @param height 	The height of the rectangle
	 * @param c			The color of the rectangle
	 * @return			The filled GRect object
	 */
	private GRect createFilledRect(int x, int y, int width, int height, Color c) {
		GRect rect = new GRect(x, y, width, height);
		rect.setColor(c);
		rect.setFilled(true);
		return rect;
	}
	
	/**
	 * Creates filled circle which is GOval object with
	 * specified radius, centered at point (x, y).
	 * @param x The x-coordinate of the circle.
	 * @param y The y-coordinate of the circle.
	 * @param r The radius of the circle.
	 * @return 	The filled circle which is GOval object.
	 */
	private GOval createFilledCircle(int x, int y, int r) {
		GOval ball = new GOval(x - r, y - r, r * 2, r * 2);
		ball.setFilled(true);
		return ball;
	}
	/**
	 * Returns color for a specified row of bricks.
	 * @param n Number of row starting from 0
	 * @return	Color for a specified row
	 */
	private Color colorForRow(int n) {
		switch (n) {
			case 0: case 1: return Color.RED;
			case 2: case 3: return Color.ORANGE;
			case 4: case 5: return Color.YELLOW;
			case 6: case 7: return Color.GREEN;
			case 8: case 9: return Color.CYAN;
			default: return Color.BLACK;
		}
	}
	
	/**
	 * Called whenever the mouse is moved.
	 * Moves the paddle along x axis.
	 */
	public void mouseMoved(MouseEvent e) {
		if (lastX > PADDLE_WIDTH / 2 &&
			lastX < getWidth() - PADDLE_WIDTH / 2) {
			paddle.setLocation(lastX - PADDLE_WIDTH / 2, paddle.getY());
		}
		lastX = e.getX();
	}
	
	private void presentFeedback() {
		boolean isWon = nBricksRemaining == 0;
		String feedback = isWon ? "You win" : "You loose";
		Color c = isWon ? Color.GREEN : Color.RED;
		GLabel label = new GLabel(feedback);
		label.setFont("Arial-72");
		label.setColor(c);
		double x = (getWidth() - label.getWidth()) / 2;
		double y = getHeight() + label.getAscent();
		label.setLocation(x, y);
		add(label);
		while (label.getY() > (getHeight() + label.getAscent()) / 2) {
			label.move(0, -2);
			pause(DELAY);
		}
	}

	/** Private instance variables */
	GRect paddle;
	GOval ball;
	RandomGenerator rgen = RandomGenerator.getInstance();
	AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
	private double vx, vy; // Velocities of the ball.
	int lastX = 0;
	int turn = 0;
	int nBricksRemaining = 0;
}
