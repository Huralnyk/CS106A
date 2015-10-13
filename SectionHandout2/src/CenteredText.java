/*
 * File: CenteredText.java
 * -----------------------
 * This programs draws a GLabel with "CS106A rocks my socks!"
 * on the center of graphics window.
 */

import acm.program.*;
import acm.graphics.*;

public class CenteredText extends GraphicsProgram {
	
	/* Runs the program */
	public void run() {
		GLabel label = createCenteredLabel("CS106A rocks my socks!", "SansSerif-28");
		add(label);
	}
	
	/* 
	 * Creates a GLabel centered on the screen with
	 * specified text and font. 
	 */ 
	private GLabel createCenteredLabel(String text, String font) {
		GLabel label = new GLabel(text);
		label.setFont(font);
		double x = (getWidth() - label.getWidth()) / 2;
		double y = (getHeight() + label.getAscent()) / 2;
		label.setLocation(x, y);
		return label;
	}
}
