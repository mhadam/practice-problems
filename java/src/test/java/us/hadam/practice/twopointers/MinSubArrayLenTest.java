package us.hadam.practice.twopointers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.slidingwindow.MinSubArrayLen.minSubArrayLen;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MinSubArrayLenTest {

  @ParameterizedTest
  @MethodSource("argsAndExpectedProvider")
  public void testMinSubArrayLen(int target, int[] nums, int expected) {
    int actual = minSubArrayLen(target, nums);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> argsAndExpectedProvider() {
    return Stream.of(
        arguments(7, new int[] {2, 3, 1, 2, 4, 3}, 2),
        arguments(4, new int[] {1, 4, 4}, 1),
        arguments(11, new int[] {1, 1, 1, 1, 1, 1, 1, 1}, 0),
        arguments(11, new int[] {1, 2, 3, 4, 5}, 3));
  }
}
