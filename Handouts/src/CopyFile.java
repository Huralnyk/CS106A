/*
 * File: CopyFile.java
 * -------------------
 * This program shows an example of copying a text file
 * line by line.
 */

import acm.program.*;
import acm.util.*;

import java.io.*;

public class CopyFile extends ConsoleProgram {
	
	public void run() {
		setFont("Times New Roman-24");
		BufferedReader rd = openFile("Please enter filename: ");
		
		try {
			PrintWriter wr = new PrintWriter(new FileWriter("copy.txt"));
			
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				println(line);		// console
				wr.println(line);	// file
			}
			
			rd.close();
			wr.close();
			
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}

	private BufferedReader openFile(String prompt) {
		BufferedReader rd = null;
		
		while (rd == null) {
			try {
				String filename = readLine(prompt);
				rd = new BufferedReader(new FileReader(filename));
			} catch (IOException ex) {
				println("Nice try punk. That file doesn't exist.");
			}
		}
		return rd;
	}
}
