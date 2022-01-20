package day04;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringStatisticsTest {

    @Test
    void testCountVowels() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 1);
        expected.put('e', 2);
        expected.put('i', 1);
        expected.put('o', 4);
        assertEquals(expected, StringStatistics.countVowels("Hello WOrld, my name is Otto!"));
    }
}
