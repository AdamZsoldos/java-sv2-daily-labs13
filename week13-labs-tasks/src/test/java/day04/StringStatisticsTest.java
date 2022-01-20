package day04;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class StringStatisticsTest {

    @Test
    void testCountVowels() {
        Map<Character, Integer> expected = new TreeMap<>();
        expected.put('A', 1);
        expected.put('E', 2);
        expected.put('I', 1);
        expected.put('O', 4);
        assertEquals(expected, StringStatistics.countVowels("Hello WOrld, my name is Otto!"));
    }
}
