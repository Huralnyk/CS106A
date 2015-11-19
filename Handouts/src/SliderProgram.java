/*
 * File: SliderProgram.java
 * ------------------------
 * This program shows an example of threads.
 */

import acm.program.*;
import acm.util.*;
import java.awt.event.*;
import javax.swing.*;

public class SliderProgram extends GraphicsProgram {

	public void run() {
		add(new JButton("Slide"), SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Slide")) {
			// create a new slider
			Slider slider = new Slider(SIZE, rgen.nextColor());
			add(slider, 0, rgen.nextInt(0, 300));
			
			// run the slider on a new thread
			Thread sliderThread = new Thread(slider);
			sliderThread.start();
		}
	}
	
	/* Constants */
	private static final int SIZE = 40;
	
	/* Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
