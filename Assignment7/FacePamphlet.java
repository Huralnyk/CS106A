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
		statusfield.setActionCommand(STATUS_COMMAND);
		statusfield.addActionListener(this);
		picturefield.setActionCommand(PICTURE_COMMAND);
		picturefield.addActionListener(this);
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
			addProfile(namefield.getText());
		} else if (cmd.equals("Delete") && !namefield.getText().isEmpty()) {
			removeProfile(namefield.getText());
		} else if (cmd.equals("Lookup") && !namefield.getText().isEmpty()) {
			lookupProfile(namefield.getText());
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
    
    /**
     * Adds new profile to database if it doesn't already exist.
     */
    private void addProfile(String name) {
    	if (database.containsProfile(name)) {
    		println("Add: profile for " + name + " already exists: " + database.getProfile(name));
    	} else {
    		FacePamphletProfile profile = new FacePamphletProfile(name);
    		database.addProfile(profile);
    		println("Add: new profile: " + profile);
    	}
    }
    
    /**
     * Removes profile from database if it exists.
     */
    private void removeProfile(String name) {
    	if (database.containsProfile(name)) {
    		database.deleteProfile(name);
    		println("Delete: profile of " + name + " deleted");
    	} else {
    		println("Delete: profile with name " + name + " does not exist");
    	}
    }
    
    /**
     * Looks up for the profile in database.
     */
    private void lookupProfile(String name) {
    	if (database.containsProfile(name)) {
    		FacePamphletProfile profile = database.getProfile(name);
    		println("Lookup: " + profile);
    	} else {
    		println("Lookup: profile with name " + name + " does not exist");
    	}
    }
    
    /* Private constants */
    private static final String STATUS_COMMAND = "Change Status";
    private static final String PICTURE_COMMAND = "Change Picture";
    private static final String FRIEND_COMMAND = "Add Friend";
    
    /* Private instance variables */
    private JTextField namefield = new JTextField(TEXT_FIELD_SIZE);
    private JTextField statusfield = new JTextField(TEXT_FIELD_SIZE);
    private JTextField picturefield = new JTextField(TEXT_FIELD_SIZE);
    private JTextField friendfield = new JTextField(TEXT_FIELD_SIZE);
    private FacePamphletDatabase database = new FacePamphletDatabase();

}
