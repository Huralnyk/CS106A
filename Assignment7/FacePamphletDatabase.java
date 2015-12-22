/*
 * File: FacePamphletDatabase.java
 * -------------------------------
 * This class keeps track of the profiles of all users in the
 * FacePamphlet application.  Note that profile names are case
 * sensitive, so that "ALICE" and "alice" are NOT the same name.
 */

import java.util.*;
import java.io.*;

import acm.util.*;
import acm.graphics.*;

public class FacePamphletDatabase implements FacePamphletConstants {

	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the database.
	 */
	public FacePamphletDatabase() {
		database = new HashMap<String, FacePamphletProfile>();
	}
	
	
	/** 
	 * This method adds the given profile to the database.  If the 
	 * name associated with the profile is the same as an existing 
	 * name in the database, the existing profile is replaced by 
	 * the new profile passed in.
	 */
	public void addProfile(FacePamphletProfile profile) {
		database.put(profile.getName(), profile);
	}

	
	/** 
	 * This method returns the profile associated with the given name 
	 * in the database.  If there is no profile in the database with 
	 * the given name, the method returns null.
	 */
	public FacePamphletProfile getProfile(String name) {
		return database.get(name);
	}
	
	
	/** 
	 * This method removes the profile associated with the given name
	 * from the database.  It also updates the list of friends of all
	 * other profiles in the database to make sure that this name is
	 * removed from the list of friends of any other profile.
	 * 
	 * If there is no profile in the database with the given name, then
	 * the database is unchanged after calling this method.
	 */
	public void deleteProfile(String name) {
		FacePamphletProfile profile = getProfile(name);
		if (profile != null) {
			deleteFromFrienlist(profile);
			database.remove(name);
		}
	}
	
	/** 
	 * Removes profile from the list of friends of all friend profiles.
	 */
	private void deleteFromFrienlist(FacePamphletProfile profile) {
		Iterator<String> it = profile.getFriends();
		while (it.hasNext()) {
			FacePamphletProfile friend = getProfile(it.next());
			friend.removeFriend(profile.getName());
		}
	}
	
	/** 
	 * This method returns true if there is a profile in the database 
	 * that has the given name.  It returns false otherwise.
	 */
	public boolean containsProfile(String name) {
		return database.containsKey(name);
	}
	
	/**
	 * This method loads database from a specified BufferedReader.
	 */
	public void loadDatabaseFromFile(BufferedReader rd) {
		// Discard old database
		database = new HashMap<String, FacePamphletProfile>();
		try {
			int numOfProfiles = Integer.parseInt(rd.readLine());
			for (int i = 0; i < numOfProfiles; i++) {
				readProfile(rd);
			}
		} catch (IOException ex) {
			throw new ErrorException("Ilegal file format");
		}
	}
	
	/**
	 * This methods saves database to file with specified filename.
	 */
	public boolean saveDatabaseToFile(String filename) {
		try {
			PrintWriter wr = new PrintWriter(new FileWriter(filename));
			wr.println(database.size());
			for (String name : database.keySet()) {
				FacePamphletProfile profile = database.get(name);
				saveProfile(profile, wr);
			}
			wr.close();
		} catch (IOException ex) {
			return false;
		}
		return true;
	}
	
	/**
	 * Helper method reads one profile entry from specified BufferedReader
	 * and saves it to database. May throw exception.
	 */
	public void readProfile(BufferedReader rd) throws IOException {
		try {
			FacePamphletProfile profile = new FacePamphletProfile(rd.readLine());
    		String filename = rd.readLine();
    		profile.setImageName(filename);
    		if (!filename.equals("")) {
    			profile.setImage(new GImage(filename));
    		}
			profile.setStatus(rd.readLine());
			while (true) {
				String friend = rd.readLine();
				if (friend.equals("")) break;
				profile.addFriend(friend);
			}
			addProfile(profile);
		} catch (IOException ex) {
			throw ex;
		}
	}
	
	/**
	 * Helper method saves profile to specified PrintWriter.
	 */
	public void saveProfile(FacePamphletProfile profile, PrintWriter wr) {	
		wr.println(profile.getName());
		wr.println(profile.getImageName());
		wr.println(profile.getStatus());
		Iterator<String> friends = profile.getFriends();
		while (friends.hasNext()) {
			wr.println(friends.next());
		}
		wr.println("");
	}
	
	/* Private instance variables */
	private Map<String, FacePamphletProfile> database;

}
