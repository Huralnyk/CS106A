import java.util.*;

public class StringQueue implements MinimalStringQueue {
	
	public void add(String str) {
		list.add(str);
	}
	
	public String poll() {
		if (list.isEmpty()) return null;
		return list.remove(0);
	}
	
	public int size() {
		return list.size();
	}
	
	/* Private instance variable */
	private ArrayList<String> list = new ArrayList<String>();
}
