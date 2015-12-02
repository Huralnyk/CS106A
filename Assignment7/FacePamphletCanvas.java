/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */


import acm.graphics.*;
import java.awt.*;
import java.util.*;

public class FacePamphletCanvas extends GCanvas 
					implements FacePamphletConstants {
	
	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the display
	 */
	public FacePamphletCanvas() {
		nameLabel = new GLabel("");
		nameLabel.setColor(Color.BLUE);
		nameLabel.setFont(PROFILE_NAME_FONT);
		double x = LEFT_MARGIN;
		double y = TOP_MARGIN + nameLabel.getAscent();
		nameLabel.setLocation(x, y);
		
		msgLabel = new GLabel("");
		msgLabel.setFont(MESSAGE_FONT);	
	}

	
	/** 
	 * This method displays a message string near the bottom of the 
	 * canvas.  Every time this method is called, the previously 
	 * displayed message (if any) is replaced by the new message text 
	 * passed in.
	 */
	public void showMessage(String msg) {
		remove(msgLabel);
		msgLabel.setLabel(msg);
		double x = (getWidth() - msgLabel.getWidth()) / 2;
		double y = getHeight() - BOTTOM_MESSAGE_MARGIN;
		add(msgLabel, x, y);
	}
	
	
	/** 
	 * This method displays the given profile on the canvas.  The 
	 * canvas is first cleared of all existing items (including 
	 * messages displayed near the bottom of the screen) and then the 
	 * given profile is displayed.  The profile display includes the 
	 * name of the user from the profile, the corresponding image 
	 * (or an indication that an image does not exist), the status of
	 * the user, and a list of the user's friends in the social network.
	 */
	public void displayProfile(FacePamphletProfile profile) {
		removeAll();
		if (profile != null) {
			nameLabel.setLabel(profile.getName());
			add(nameLabel);
			
			double x = LEFT_MARGIN;
			double y = nameLabel.getY() + IMAGE_MARGIN;
			
			if (profile.getImage() != null) {
				picture = profile.getImage();
				picture.setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
				add(picture, x, y);
			} else {
				drawPlaceholder(x, y);
			}
			
			y += IMAGE_HEIGHT + STATUS_MARGIN;
			String status = profile.getStatus();
			if (status.isEmpty()) {
				status = "No current status";
			} else {
				status = profile.getName() + "'s status is " + status;
			}
			displayStatus(status, x, y);
			
			GLabel friends = new GLabel("Friends: ");
			friends.setFont(PROFILE_FRIEND_LABEL_FONT);
			x = getWidth() / 2;
			y = nameLabel.getY() + IMAGE_MARGIN;
			friends.setLocation(x, y);
			add(friends);
			displayFriends(profile.getFriends(), x, y);
		}
	}
	
	/* Draws status label on the given position */
	private void displayStatus(String status, double x, double y) {
		GLabel label = new GLabel(status);
		label.setFont(PROFILE_STATUS_FONT);
		add(label, x, y + label.getAscent());
	}
	
	/* 
	 * Draws list of label for each friend one per line 
	 * below the given position. 
	 */
	private void displayFriends(Iterator<String> it, double x, double y) {
		int i = 1;
		while (it.hasNext()) {
			GLabel label = new GLabel(it.next());
			label.setFont(PROFILE_FRIEND_FONT);
			add(label, x, y + label.getHeight() * i++);
		}
	}
	
	/* Draws the rectangle with text "No Image" on the given position */
	private void drawPlaceholder(double x, double y) {
		GRect rect = new GRect(x, y, IMAGE_WIDTH, IMAGE_HEIGHT);
		GLabel noImage = new GLabel("No Image");
		noImage.setFont(PROFILE_IMAGE_FONT);
		add(rect);
		add(noImage, x + (IMAGE_WIDTH - noImage.getWidth()) / 2, 
				   y + (IMAGE_HEIGHT + noImage.getAscent()) / 2);
	}

	/* Private instance variables */
	private GLabel nameLabel;
	private GLabel msgLabel;
	private GImage picture;
}
