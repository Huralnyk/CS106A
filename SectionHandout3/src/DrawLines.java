/**
 * File: DrawLines.java
 * --------------------
 * @author Alexey Huralnyk
 *
 * This program allows user to draw lines on the graphics
 * window by pressing and dragging the mouse in the canvas.
 *
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class DrawLines extends GraphicsProgram {
	
	public void init() {
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
		add(line);
	}
	
	public void mouseDragged(MouseEvent e) {
		line.setEndPoint(e.getX(), e.getY());
	}

	/** Private instance variables */
	GLine line;
}
