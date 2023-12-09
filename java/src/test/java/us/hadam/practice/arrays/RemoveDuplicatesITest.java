package us.hadam.practice.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.arrays.RemoveDuplicatesI.removeDuplicates;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RemoveDuplicatesITest {

  @ParameterizedTest
  @MethodSource("argsAndExpectedProvider")
  public void testRemoveDuplicates(int[] nums, int[] expectedArr, int expectedCount) {
    int result = removeDuplicates(nums);
    assertArrayEquals(expectedArr, nums);
    assertEquals(expectedCount, result);
  }

  static Stream<Arguments> argsAndExpectedProvider() {
    return Stream.of(arguments(new int[] {1, 1, 2}, new int[] {1, 2, 2}, 2));
  }
}
