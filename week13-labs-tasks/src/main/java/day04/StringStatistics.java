package day04;

import java.util.Map;
import java.util.TreeMap;

public class StringStatistics {

    private StringStatistics() {
    }

    private static final String UPPERCASE_VOWELS = "AEIOU";

    public static Map<Character, Integer> countVowels(String s) {
        Map<Character, Integer> result = new TreeMap<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                incrementCharacterCount(result, Character.toLowerCase(c));
            }
        }
        return result;
    }

    private static boolean isVowel(char c) {
        return UPPERCASE_VOWELS.indexOf(Character.toUpperCase(c)) >= 0;
    }

    private static void incrementCharacterCount(Map<Character, Integer> map, char c) {
        if (!map.containsKey(c)) {
            map.put(c, 1);
        } else {
            map.put(c, map.get(c) + 1);
        }
    }
}
