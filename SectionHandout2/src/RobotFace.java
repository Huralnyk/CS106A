/*
 * File: RobotFace.java
 * --------------------
 * This programs draws a robot face on the center of
 * graphics window.
 */

import acm.program.*;
import acm.graphics.*;

import java.awt.*;

public class RobotFace extends GraphicsProgram {
	
	private static final int HEAD_WIDTH = 200;
	
	private static final int HEAD_HEIGHT = 350;
	
	private static final int EYE_RADIUS = 20;
	
	private static final int MOUTH_WIDTH = 150;
	
	private static final int MOUTH_HEIGHT = 35;
	
	public void run() {
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		double qx = HEAD_WIDTH / 4;
		double qy = HEAD_HEIGHT / 4;
		drawHead(cx, cy);		
		drawEye(cx - qx, cy - qy);
		drawEye(cx + qx, cy - qy);
		drawMouth(cx, cy + qy);
	}
	
	private void drawHead(double x, double y) {
		x -= HEAD_WIDTH / 2;
		y -= HEAD_HEIGHT / 2;
		GRect head = new GRect(x, y, HEAD_WIDTH, HEAD_HEIGHT);
		head.setFillColor(Color.GRAY);
		head.setFilled(true);
		add(head);		
	}
	
	private void drawEye(double x, double y) {
		drawCircle(x, y, EYE_RADIUS, Color.YELLOW);
	}
	
	private void drawMouth(double x, double y) {
		x -= MOUTH_WIDTH / 2;
		y -= MOUTH_HEIGHT / 2;
		GRect mouth = new GRect(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setColor(Color.WHITE);
		mouth.setFilled(true);
		add(mouth);	
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
