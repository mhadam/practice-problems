package us.hadam.practice.arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.arrays.RemoveDuplicatesII.removeDuplicates;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RemoveDuplicatesIITest {

  @ParameterizedTest
  @MethodSource("argsAndExpectedProvider")
  public void testRemoveDuplicates(int[] nums, int[] expectedArr, int expectedCount) {
    int result = removeDuplicates(nums);
    assertArrayEquals(expectedArr, nums);
    assertEquals(expectedCount, result);
  }

  static Stream<Arguments> argsAndExpectedProvider() {
    return Stream.of(
        arguments(new int[] {1, 1, 1, 2, 2, 3}, new int[] {1, 1, 2, 2, 3, 3}, 5),
        arguments(new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3}, new int[] {0, 0, 1, 1, 2, 3, 3, 3, 3}, 7));
  }
}
