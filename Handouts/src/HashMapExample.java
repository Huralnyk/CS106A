/*
 * HashMapExample.java
 * -------------------
 * This program shows an example of using a HashMap to keep
 * track of a simple phonebook (mapping names to phone numbers).
 */

import acm.program.*;
import java.util.*;

public class HashMapExample extends ConsoleProgram {
	
	public void run() {
		setFont("Times New Roman-24");
		
		println("Reading in phone numbers");
		readPhoneNumbers();
		
		println("Displaying phone numbers");
		displayAllNumbers();
		
		println("Looking up phone numbers");
		lookUpNumbers();
	}
	
	// Ask the user for phone numbers to store in phonebook.
	private void readPhoneNumbers() {
		while (true) {
			String name = readLine("Enter name: ");
			if (name.equals("")) break;
			int number = readInt("Phone number (as int): ");
			phonebook.put(name, number);
		}
	}
	
	// Print out all the names/phone numbers in the phonebook.
	// (This version of the method uses iterators.)
	private void displayAllNumbers() {
		Iterator<String> it = phonebook.keySet().iterator();
		while (it.hasNext()) {
			String name = it.next();
			Integer number = phonebook.get(name);
			println(name + ": " + number);
		}
	}
	
	// Print out all the names/phone numbers in the phonebook.
	// (This version of the method uses a foreach loop.)
	private void displayAllNumbers2() {
		for (String name : phonebook.keySet()) {
			Integer number = phonebook.get(name);
			println(name + ": " + number);
		}
	}
	
	// Allow the user to lookup phone numbers in the phonebook
	// by looking up the number associated with a name.
	private void lookUpNumbers() {
		while (true) {
			String name = readLine("Enter name to lookup: ");
			if (name.equals("")) break;
			Integer number = phonebook.get(name);
			if (number == null) {
				println(name + " not in phonebook");
			} else {
				println(number);
			}
		}
	}
	
	/* Private instance variable */
	private Map<String, Integer> phonebook = new HashMap<String, Integer>();

}
