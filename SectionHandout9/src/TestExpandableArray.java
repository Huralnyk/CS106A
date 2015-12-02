/*
 * File: TestExpandableArray.java
 * ------------------------------
 * This program test the class ExpandableArray
 */

import javax.swing.*;
import acm.io.*;

public class TestExpandableArray {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Expandable Array");
		IOConsole console = new IOConsole();
		
		frame.add(console);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		ExpandableArray myList = new ExpandableArray();
		console.println(myList);
		
		myList.set(14, "Bob");
		console.println(myList);
		
		myList.set(21, "Sally");
		console.println(myList);
		
		String value = (String) myList.get(14); // Note the cast
		if (value != null) {
			console.println("Got value: " + value);
		}
	}
	
}
