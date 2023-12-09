package us.hadam.practice.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.arrays.RemoveElement.removeElement;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RemoveElementTest {
  @ParameterizedTest
  @MethodSource("argsAndExpectedProvider")
  public void testRemove(int[] nums, int val, int[] expected, int expectedRemoved) {
    int result = removeElement(nums, val);
    assertArrayEquals(expected, nums);
    assertEquals(expectedRemoved, result);
  }

  static Stream<Arguments> argsAndExpectedProvider() {
    return Stream.of(
        arguments(new int[] {0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[] {0, 1, 4, 0, 3, 0, 4, 2}, 5));
  }
}
