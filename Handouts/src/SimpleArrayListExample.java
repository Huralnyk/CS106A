/* 
 * SimpleArrayListExample.java
 * ---------------------------
 * This program shows an example of using an ArrayList.
 */

import acm.program.*;
import java.util.*;

public class SimpleArrayListExample extends ConsoleProgram {
	
	public void run() {
		setFont("Courier New-bold-24");
		
		ArrayList<String> strList = new ArrayList<String>();
		readStringList(strList);
		printArrayList(strList);
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		readIntList(intList);
		printArrayList(intList);
	}
	
	private void readStringList(ArrayList<String> list) {
		while (true) {
			String line = readLine("Next line: ");
			if (line.equals("")) break;
			list.add(line);
		}
	}
	
	private void printArrayList(ArrayList list) {
		println("List contains " + list.size() + " elements");
		for (int i = 0; i < list.size(); i++) {
			println(list.get(i));	// unboxes value if needed (e.g., int)
		}
	}
	
	private void readIntList(ArrayList<Integer> list) {
		while (true) {
			int value = readInt("Next integer (-1 to stop): ");
			if (value == -1) break;
			list.add(value);		// boxes value (int) to Integer
		}
	}

}
