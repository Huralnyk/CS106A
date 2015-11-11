/*
 * File: GLabeledBox.java
 * ----------------------
 * This subclass of GCompound represents a rect with
 * text label in the center of it.
 */

import acm.graphics.*;

public class GLabeledBox extends GCompound {
	
	public GLabeledBox(double width, double height, String name) {
		add(new GRect(width, height));
		nameLabel = new GLabel(name);
		double x = (width - nameLabel.getWidth()) / 2;
		double y = (height - nameLabel.getHeight()) / 2 + nameLabel.getAscent();
		add(nameLabel, x, y);
	}

	public String getName() {
		return nameLabel.getLabel();
	}
	
	/* Private instance variables */
	GLabel nameLabel;
}
