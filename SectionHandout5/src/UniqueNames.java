/*
 * File: UniqueNames.java
 * ----------------------
 * This program asks user to enter list of names until the user enters a blank line.
 * After that program prints out the list of names where each name listed only once
 * no matter how many times it were entered.
 */

import acm.program.*;
import java.util.*;

public class UniqueNames extends ConsoleProgram {
	
	public void run() {
		ArrayList<String> uniqueNames = new ArrayList<String>();
		while (true) {
			String name = readLine("Enter name: ");
			if (name.equals("")) break;
			if (uniqueNames.indexOf(name) == -1) {
				uniqueNames.add(name);
			}
		}
		println("Unique name list contatins: ");
		printList(uniqueNames);
	}
	
	/**
	 * Prints out a contents of a list of strings.
	 */
	private void printList(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			println(list.get(i));
		}
	}

}
