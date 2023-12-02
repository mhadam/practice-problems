package us.hadam.practice.kadane;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.kadane.MaxSubArray.maxSubArray;

class MaxSubArrayTest {

    @ParameterizedTest
    @MethodSource("argsAndExpectedProvider")
    void testMaxSubArray(int[] nums, int expected) {
        assertEquals(expected, maxSubArray(nums));
    }

    static Stream<Arguments> argsAndExpectedProvider() {
        return Stream.of(
                arguments(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6)
        );
    }
}