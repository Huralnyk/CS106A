/*
 * File: Histogram.java
 * --------------------
 * This program reads a list of exam scores from the file specified by
 * constant FILENAME and then displays a histogram of those numbers,
 * divided into ranges 0-9, 10-19, and so forth, up to the range
 * containing only the value 100.
 */

import acm.program.*;
import java.io.*;

public class Histogram extends ConsoleProgram {
	
	/** Private constants */
	private static final String FILENAME = "MidtermScores.txt";
	
	public void run() {
		int[] histogram = new int[11];
		fillHistogram(histogram);
		printHistogram(histogram);
	}
	
	private void fillHistogram(int[] histogram) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(FILENAME));
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				int score = Integer.parseInt(line);
				int index = score / 10;
				histogram[index] += 1;
			}
			rd.close();
		} catch (IOException ex) {
			println("Oops, that file doesn't exists.");
		}
	}
	
	private void printHistogram(int[] histogram) {
		for (int i = 0; i < histogram.length; i++) {
			if (i == 10) {
				print("  100: ");
			} else {
				print(i + "0-" + i + "9: ");
			}
			println(repeatCharacter('*', histogram[i]));
		}
	}
	
	private String repeatCharacter(char ch, int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result += ch;
		}
		return result;
	}
}
