/*
 * File: CountNames.java
 * ---------------------
 * That program asks the user for a list of names untile the user enters
 * a blank line. After that program prints out how many times each name in
 * the list was entered.
 */

import acm.program.*;
import java.util.*;

public class CountNames extends ConsoleProgram {
	
	public void run() {
		Map<String, Integer> names = new HashMap<String, Integer>();
		while (true) {
			String name = readLine("Enter name: ");
			if (name.equals("")) break;
			if (names.get(name) == null) {
				names.put(name, 1);
			} else {
				int count = names.get(name);
				names.put(name, count + 1);
			}
		}
		printStatistics(names);
	}
	
	private void printStatistics(Map<String, Integer> stats) {
		for (String name : stats.keySet()) {
			println("Entry [" + name + "] has count " + stats.get(name));
		}
	}

}
