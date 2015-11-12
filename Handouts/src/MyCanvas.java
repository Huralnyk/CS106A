/*
 * File: MyCanvas.java
 * -------------------
 */
import acm.graphics.*;
import java.awt.event.*;

public class MyCanvas extends GCanvas implements ComponentListener {

	public MyCanvas() {
		addComponentListener(this);
		rect = new GRect(BOX_WIDTH, BOX_HEIGHT);
		rect.setFilled(true);
	}

	private void update() {
		removeAll();
		add(rect, (getWidth() - BOX_WIDTH) / 2,
				  (getHeight() - BOX_HEIGHT) / 2);
	}

	// Must have these methods, even if they don't do anything
	public void componentResized(ComponentEvent e) { update();}
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentShown(ComponentEvent e) { }
	
	private static final double BOX_WIDTH = 50;
	private static final double BOX_HEIGHT = 50;
	
	/* Instance variables */
	private GRect rect;		
}