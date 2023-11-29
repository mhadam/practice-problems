package us.hadam.practice.hashmaps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.hashmaps.LongestConsecutiveSeq.longestConsecutive;

class LongestConsecutiveSeqTest {

    @ParameterizedTest
    @MethodSource("argsAndExpectedProvider")
    void testLongestConsecutive(int[] nums, int length) {
        int result = longestConsecutive(nums);
        assertEquals(length, result);
    }

    static Stream<Arguments> argsAndExpectedProvider() {
        return Stream.of(
                arguments(new int[]{100,4,200,1,3,2}, 4),
                arguments(new int[]{0,3,7,2,5,8,4,6,0,1}, 9)
        );
    }
}