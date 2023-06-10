package telran.words.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Anagram {
	public static boolean isAnagram(String word, String part) {
		Map<Character, Integer> digit = new HashMap<>();
		Map<Character, Integer> digit2 = new HashMap<>();
		if (part == null || part == "") {
			return false;
		}
		word = word.toLowerCase();
		part = part.toLowerCase();
		for (int j = 0; j < word.length(); j++) {
			digit.merge(word.charAt(j), 1, (a, b) -> a + b);
		}
		for (int j = 0; j < part.length(); j++) {
			digit2.merge(part.charAt(j), 1, (a, b) -> a + b);
		}

		Set<Map.Entry<Character, Integer>> partEntry = digit2.entrySet();
		for (Map.Entry<Character, Integer> entry : partEntry) {
			if (!digit.containsKey(entry.getKey()) || digit.get(entry.getKey()) < entry.getValue()) {
				return false;
			}
		}

		return true;
		
//		Map<Character, Integer> digit = new HashMap<>();
//		if (part == null || part == "")return false;
//		
//		word = word.toLowerCase();
//		part = part.toLowerCase();
//		
//		for (int j = 0; j < word.length(); j++) {
//			if (digit.putIfAbsent(word.charAt(j), 1) != null) {
//				digit.put(word.charAt(j), digit.get(word.charAt(j)) + 1);
//			}
//		}
//		for (int i = 0; i < part.length(); i++) {
//			if (digit.getOrDefault(part.charAt(i), 0) <= 0)
//				return false;
//			digit.put(part.charAt(i), digit.get(part.charAt(i)) - 1);
//		}
//		return true;
	}
}
