/*
 * File: BoxDiagram.java
 * ---------------------
 * This program is a framework for an interactive design tool
 * that allows the user to arrange boxes with labels on the window. 
 */

import acm.program.*;
import acm.graphics.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class BoxDiagram extends GraphicsProgram {
	
	/* Private constants */
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;
	
	// Initializes program
	public void init() {
		namefield = new JTextField(10);
		namefield.setActionCommand("Add");
		namefield.addActionListener(this);
		add(new JLabel("Name"), SOUTH);
		add(namefield, SOUTH);
		
		JButton addButton = new JButton("Add");
		JButton removeButton = new JButton("Remove");
		JButton clearButton = new JButton("Clear");
		add(addButton, SOUTH);
		add(removeButton, SOUTH);
		add(clearButton, SOUTH);
		
		addMouseListeners();
		addActionListeners();
	}
	
	// Called whenever mouse button is pressed
	public void mousePressed(MouseEvent e) {
		last = new GPoint(e.getPoint());
		gobj = getElementAt(last); 
	}
	
	// Called whenever mouse is moved with button with button being pressed.
	public void mouseDragged(MouseEvent e) {
		if (gobj != null) {
			gobj.move(e.getX() - last.getX(), e.getY() - last.getY());
			last = new GPoint(e.getPoint());
		}
	}
	
	// Called whenever action event occurs in a program
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Add")) {
			addLabeledBox();
		} else if (cmd.equals("Remove")) {
			removeBoxWithName(namefield.getText());
		} else if (cmd.equals("Clear")) {
			removeAllBoxes();
		}
	}
	
	// Adds new labeled box to the center of graphics window
	// with name specified by the user.
	private void addLabeledBox() {
		GLabeledBox box = new GLabeledBox(BOX_WIDTH, BOX_HEIGHT, namefield.getText());
		double x = (getWidth() - box.getWidth()) / 2;
		double y = (getHeight() - box.getHeight()) / 2;
		add(box, x, y);
		boxList.add(box);
	}
	
	// Removes labeled box with specified name of the screen.
	private void removeBoxWithName(String boxname) {
		for (GLabeledBox box : boxList) {
			if (box.getName().equals(boxname)) {
				remove(box);
				boxList.remove(box);
				break;
			}
		}
	}
	
	// Removes all the labeled boxes from the graphics screen.
	private void removeAllBoxes() {
		for (GLabeledBox box : boxList) {
			remove(box);
		}
		boxList = new ArrayList<GLabeledBox>();
	}
	
	/** Private instance variables */
	private JTextField namefield;
	private GObject gobj;
	private GPoint last;
	private List<GLabeledBox> boxList = new ArrayList<GLabeledBox>();
}
