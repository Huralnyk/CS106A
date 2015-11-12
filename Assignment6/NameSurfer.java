/*
 * File: NameSurfer.java
 * ---------------------
 * Author: Alexey Huralnyk
 * This program implements the viewer for the baby-name database
 * described in the assignment handout of Stanford CS106A course.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends ConsoleProgram implements NameSurferConstants {

	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base
	 * and initializing the interactors at the top of the window.
	 */
	public void init() {
	    namefield = new JTextField(20);
	    namefield.setActionCommand("Graph");
	    
	    add(new JLabel("Name"), NORTH);
	    add(namefield, NORTH);
	    add(new JButton("Graph"), NORTH);
	    add(new JButton("Clear"), NORTH);
	    
	    addActionListeners();
	    namefield.addActionListener(this);
	}

	/* Method: actionPerformed(e) */
	/**
	 * This class is responsible for detecting when the buttons are
	 * clicked, so you will have to define a method to respond to
	 * button actions.
	 */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Graph")) {
			println(cmd + ": \"" + namefield.getText() + "\"");
		} else if (cmd.equals("Clear")) {
			println(cmd);
		}
	}
	
	/* Private instance variables */
	private JTextField namefield;
}
