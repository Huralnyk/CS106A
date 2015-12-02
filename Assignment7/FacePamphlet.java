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

public class FacePamphlet extends Program 
					implements FacePamphletConstants {

	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	public void init() {
		canvas = new FacePamphletCanvas();
		add(canvas);
		
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
			changeStatus(statusfield.getText());
		} else if (cmd.equals(PICTURE_COMMAND) && !picturefield.getText().isEmpty()) {
			changePicture(picturefield.getText());
		} else if (cmd.equals(FRIEND_COMMAND) && !friendfield.getText().isEmpty()) {
			addFriend(friendfield.getText());
		}
	}
    
    /**
     * Adds new profile to database if it doesn't already exist.
     */
    private void addProfile(String name) {
    	if (database.containsProfile(name)) {
    		currentProfile = database.getProfile(name);
    		canvas.displayProfile(currentProfile);
    		canvas.showMessage("A profile with the name " + name + " already exists");
    	} else {
    		currentProfile = new FacePamphletProfile(name);
    		database.addProfile(currentProfile);
    		canvas.displayProfile(currentProfile);
    		canvas.showMessage("New profile created");
    	}
    }
    
    /**
     * Removes profile from database if it exists.
     */
    private void removeProfile(String name) {
    	currentProfile = null;
    	if (database.containsProfile(name)) {
    		database.deleteProfile(name);
    		canvas.displayProfile(currentProfile);
    		canvas.showMessage("Profile of " + name + " deleted");
    	} else {
    		canvas.displayProfile(currentProfile);
    		canvas.showMessage("A profile with the name " + name + " does not exist");
    	}
    }
    
    /**
     * Looks up for the profile in database.
     */
    private void lookupProfile(String name) {
    	if (database.containsProfile(name)) {
    		currentProfile = database.getProfile(name);
    		canvas.displayProfile(currentProfile);
    		canvas.showMessage("Displaying " + name);
    	} else {
    		currentProfile = null;
    		canvas.displayProfile(currentProfile);
    		canvas.showMessage("A profile with the name " + name + " does not exist");
    	}
    }
    
    private void changeStatus(String status) {
    	if (currentProfile == null) {
    		canvas.showMessage("Please select a profile to change status");
    	} else {
    		currentProfile.setStatus(status);
    		canvas.displayProfile(currentProfile);
    		canvas.showMessage("Status updated to " + status);
    	}
    	statusfield.setText("");
    }
    
    private void changePicture(String filename) {
    	if (currentProfile == null) {
    		canvas.showMessage("Please select a profile to change picture");
    	} else {
    		GImage image = null;
    		try {
    			image = new GImage(filename);
    			currentProfile.setImage(image);
    			canvas.displayProfile(currentProfile);
    			canvas.showMessage("Picture updated");
    		} catch (ErrorException ex) {
    			canvas.showMessage("Unable to open image file: " + filename);
    		}
    	}
    	picturefield.setText("");
    }
    
    private void addFriend(String friendname) {
    	if (currentProfile == null) {
    		canvas.showMessage("Please select a profile to add friend");
    	} else if (currentProfile.getName().equals(friendname)) {
    		canvas.showMessage("You cannot add yourself as a friend");
    	} else {
    		FacePamphletProfile friend = database.getProfile(friendname);
    		if (friend == null) {
    			canvas.showMessage(friendname + " does not exist");
    		} else {
    			if (currentProfile.addFriend(friendname)) {
    				friend.addFriend(currentProfile.getName());
    				canvas.displayProfile(currentProfile);
    				canvas.showMessage(friendname + " added as a friend");
    			} else {
    				canvas.showMessage(currentProfile.getName() + " already has "
    									+ friendname + " as a friend");
    			}
    		}
    	}
    	friendfield.setText("");
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
    private FacePamphletProfile currentProfile;
    private FacePamphletCanvas canvas;

}
