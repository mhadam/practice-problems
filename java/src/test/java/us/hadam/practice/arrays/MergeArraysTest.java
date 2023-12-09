package us.hadam.practice.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.arrays.MergeArrays.merge;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

 class MergeArraysTest {
  @ParameterizedTest
  @MethodSource("argsAndExpectedProvider")
   void mergesCorrectly(int[] nums1, int l1, int[] nums2, int l2, int[] expected) {
    merge(nums1, l1, nums2, l2);
    assertArrayEquals(expected, nums1);
  }

  static Stream<Arguments> argsAndExpectedProvider() {
    return Stream.of(
        arguments(
            new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3, new int[] {1, 2, 2, 3, 5, 6}),
        arguments(new int[] {2, 0}, 1, new int[] {1}, 1, new int[] {1, 2}));
  }
}
