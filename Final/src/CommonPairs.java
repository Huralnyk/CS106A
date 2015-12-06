import acm.program.*;
import java.util.*;

public class CommonPairs extends ConsoleProgram{
	
	public void run() {
		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		map1.put("Alice", "Healthy");
		map1.put("Mary", "Ecstatic");
		map1.put("Bob", "Happy");
		map1.put("Chuck", "Fine");
		map1.put("Felix", "Sick");
		map2.put("Felix", "Healthy");
		map2.put("Mary", "Ecstatic");
		map2.put("Bob", "Happy");
		map2.put("Ricardo", "Superb");
		map2.put("Tam", "Fine");
		println(commonKeyValuePairs(map1, map2));
	}
	
	public int commonKeyValuePairs(HashMap<String, String> map1, HashMap<String, String>map2) {
		int matches = 0;
		for (String key1 : map1.keySet()) {
			String value1 = map1.get(key1);
			for (String key2 : map2.keySet()) {
				String value2 = map2.get(key2);
				if (key1.equals(key2) && value1.equals(value2)) matches++;
			}
		}
		return matches;
	}
}
