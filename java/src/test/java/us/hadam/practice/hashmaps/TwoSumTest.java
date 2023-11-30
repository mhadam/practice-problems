package us.hadam.practice.hashmaps;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.hashmaps.RansomNote.canConstruct;
import static us.hadam.practice.hashmaps.TwoSum.twoSum;

class TwoSumTest {

    @ParameterizedTest
    @MethodSource("argsAndExpectedProvider")
    void testTwoSum(int[] nums, int target, int[] expected) {
        int[] result = twoSum(nums, target);
        List<Integer> l1 = Arrays.stream(expected).boxed().toList();
        List<Integer> l2 = Arrays.stream(result).boxed().toList();
        assertTrue(CollectionUtils.isEqualCollection(l1, l2));
    }

    static Stream<Arguments> argsAndExpectedProvider() {
        return Stream.of(
                arguments(new int[]{2,7,11,15}, 9, new int[]{0,1}),
                arguments(new int[]{3,3}, 6, new int[]{0,1})
        );
    }
}