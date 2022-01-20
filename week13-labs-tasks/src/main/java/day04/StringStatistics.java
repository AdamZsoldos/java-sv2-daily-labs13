package day04;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringStatistics {

    private StringStatistics() {
    }

    private static final List<Character> VOWELS = List.of('A', 'E', 'I', 'O', 'U');

    public static Map<Character, Integer> countVowels(String s) {
        Map<Character, Integer> result = new TreeMap<>();
        for (char c : s.toCharArray()) {
            if (VOWELS.contains(Character.toUpperCase(c))) {
                incrementCharacterCount(result, Character.toUpperCase(c));
            }
        }
        return result;
    }

    private static void incrementCharacterCount(Map<Character, Integer> map, char c) {
        if (!map.containsKey(c)) {
            map.put(c, 1);
        } else {
            map.put(c, map.get(c) + 1);
        }
    }
}
