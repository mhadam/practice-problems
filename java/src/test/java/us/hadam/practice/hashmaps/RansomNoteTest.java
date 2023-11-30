package us.hadam.practice.hashmaps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.hashmaps.LongestConsecutiveSeq.longestConsecutive;
import static us.hadam.practice.hashmaps.RansomNote.canConstruct;

class RansomNoteTest {

    @ParameterizedTest
    @MethodSource("argsAndExpectedProvider")
    void testRansom(String ransomNote, String magazine, boolean expected) {
        boolean result = canConstruct(ransomNote, magazine);
        assertEquals(result, expected);
    }

    static Stream<Arguments> argsAndExpectedProvider() {
        return Stream.of(
                arguments("a", "b", false),
                arguments("aa", "ab", false),
                arguments("aa", "aab", true)
        );
    }
}