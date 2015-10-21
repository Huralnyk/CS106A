/*
 * File: StringProcessorTest.java
 * ------------------------------
 * This program runs tests of static methods
 * from StringProcessor class.
 */

import acm.program.*;

public class StringProcessorTest extends ConsoleProgram {
	
	/** Runs the program */
	public void run() {
		
		// Test removeAllOcccurrences method
		println(StringProcessor.removeAllOccurrences("This is a test", 't'));
		println(StringProcessor.removeAllOccurrences("Summer is here!", 'e'));
		println(StringProcessor.removeAllOccurrences("---0---", '-'));
		
		// Test altCaps method
		println(StringProcessor.altCaps("hello"));
		println(StringProcessor.altCaps("SECTIOS IS AWESOME"));
	}
}
