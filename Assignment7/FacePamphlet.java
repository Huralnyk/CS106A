/* 
 * File: FacePamphlet.java
 * Author: Alexey Huralnyk
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import javax.swing.*;

public class FacePamphlet extends ConsoleProgram 
					implements FacePamphletConstants {

	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	public void init() {
		namefield = new JTextField(TEXT_FIELD_SIZE);
		statusfield = new JTextField(TEXT_FIELD_SIZE);
		statusfield.setActionCommand(STATUS_COMMAND);
		statusfield.addActionListener(this);
		picturefield = new JTextField(TEXT_FIELD_SIZE);
		picturefield.setActionCommand(PICTURE_COMMAND);
		picturefield.addActionListener(this);
		friendfield = new JTextField(TEXT_FIELD_SIZE);
		friendfield.setActionCommand(FRIEND_COMMAND);
		friendfield.addActionListener(this);
		
		add(new JLabel("Name"), NORTH);
		add(namefield, NORTH);
		add(new JButton("Add"), NORTH);
		add(new JButton("Delete"), NORTH);
		add(new JButton("Lookup"), NORTH);
		
		add(statusfield, WEST);
		add(new JButton(STATUS_COMMAND), WEST);
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		add(picturefield, WEST);
		add(new JButton(PICTURE_COMMAND), WEST);
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		add(friendfield, WEST);
		add(new JButton(FRIEND_COMMAND), WEST);
		
		addActionListeners();
    }
    
  
    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Add") && !namefield.getText().isEmpty()) {
			println(cmd + ": " + namefield.getText());
		} else if (cmd.equals("Delete") && !namefield.getText().isEmpty()) {
			println(cmd + ": " + namefield.getText());
		} else if (cmd.equals("Lookup") && !namefield.getText().isEmpty()) {
			println(cmd + ": " + namefield.getText());
		} else if (cmd.equals(STATUS_COMMAND) && !statusfield.getText().isEmpty()) {
			println(cmd + ": " + statusfield.getText());
			statusfield.setText("");
		} else if (cmd.equals(PICTURE_COMMAND) && !picturefield.getText().isEmpty()) {
			println(cmd + ": " + picturefield.getText());
			picturefield.setText("");
		} else if (cmd.equals(FRIEND_COMMAND) && !friendfield.getText().isEmpty()) {
			println(cmd + ": " + friendfield.getText());
			friendfield.setText("");
		}
	}
    
    /* Private constants */
    private static final String STATUS_COMMAND = "Change Status";
    private static final String PICTURE_COMMAND = "Change Picture";
    private static final String FRIEND_COMMAND = "Add Friend";
    
    /* Private instance variables */
    private JTextField namefield;
    private JTextField statusfield;
    private JTextField picturefield;
    private JTextField friendfield;

}
