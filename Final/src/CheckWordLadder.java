import acm.program.*;

public class CheckWordLadder extends ConsoleProgram {
	
	public void run() {
		println("Program to check a word ladder");
		println("Enter a sequence of words ending with a blank line.");
		String word = "";
		boolean isWordSet = false;
		while (true) {
			String line = readLine();
			if(line.equals("")) break;
			if(lexicon.isEnglishWord(line)) {
				if(!isWordSet) {
					word = line;
					isWordSet = true;
				} else if (line.length() != word.length()) {
					println("That word is not legal! Try again.");
				} else if (checkWordLadder(word.toUpperCase(), line.toUpperCase())) {
					word = line;
				} else {
					println("That word is not legal! Try again.");
				}
			} else {
				println("That word is not legal! Try again.");
			}
		}
	}
	
	private boolean checkWordLadder(String str1, String str2) {
		int count = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) count++;
		}
		return count == 1;
	}
	
	/* Private instance variables */
	private Lexicon lexicon = new Lexicon("english.dat");
	
	
}
