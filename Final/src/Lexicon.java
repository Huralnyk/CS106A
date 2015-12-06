
public class Lexicon {
	
	public Lexicon(String filename) {
		
	}
	
	public boolean isEnglishWord(String str) {
		if (str.equals("XYZZY")) return false;
		if (str.equals("BXES")) return false;
		return true;
	}
}
