package us.hadam.practice.twopointers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.twopointers.TwoSumII.twoSum;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TwoSumIITest {
  @ParameterizedTest
  @MethodSource("argsAndExpectedProvider")
  void testTwoSumII(int[] nums, int target, int[] expected) {
    assertArrayEquals(twoSum(nums, target), expected);
  }

  static Stream<Arguments> argsAndExpectedProvider() {
    return Stream.of(
        arguments(new int[] {2, 7, 11, 15}, 9, new int[] {1, 2}),
        arguments(new int[] {2, 3, 4}, 6, new int[] {1, 3}),
        arguments(new int[] {-1, 0}, -1, new int[] {1, 2}));
  }
}
