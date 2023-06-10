package telran.map.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordFreqAppl {
	public static void main(String[] args) {
		String[] words = { "abc", "ab", "limn", "limn", "ab", "limn", "a" };
		displayWordsFrequency(words);

	}

	private static void displayWordsFrequency(String[] words) {
		Map<String, Integer> res = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
//			if (!res.containsKey(words[i])) {
//				res.put(words[i], 1);
//			} else {
//				res.put(words[i], res.get(words[i]) + 1);
//			}
			// Additional
//			if (res.putIfAbsent(words[i], 1)!=null) {
//				res.put(words[i], res.get(words[i]) + 1);
//			}
			// Additional
//			res.computeIfPresent(words[i], (k, v) -> v + 1);
//			res.computeIfAbsent(words[i], k -> 1);

			res.merge(words[i], 1, (a, b) -> a + b);
		}
		Set<Map.Entry<String, Integer>> entrys = res.entrySet();
		for (Map.Entry<String, Integer> entry : entrys) {
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}
		System.out.println("===== Sorted =====");
//		List<Map.Entry<String, Integer>> entrysList = new ArrayList<>(res.entrySet());
//		Collections.sort(entrysList, (s1 , s2) -> s2.getValue() - s1.getValue());
		List<Map.Entry<String, Integer>> entrysList = new ArrayList<>(entrys);
		entrysList.sort((s1 , s2) -> Integer.compare(s2.getValue(), s1.getValue()));
		entrysList.forEach(t ->System.out.println(t));
	}
}
