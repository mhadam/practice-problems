package us.hadam.practice.intervals;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.intervals.SummaryRanges.summaryRanges;
import static us.hadam.practice.intervals.SummaryRanges.summaryRangesIndex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SummaryRangesTest {

  @ParameterizedTest
  @MethodSource("argsAndExpectedProvider")
  void testSummaryRanges(int[] nums, List<String> expected) {
    List<String> result = summaryRanges(nums);
    assertIterableEquals(result, expected);
  }

  @ParameterizedTest
  @MethodSource("argsAndExpectedProvider")
  void testSummaryRangesIndex(int[] nums, List<String> expected) {
    List<String> result = summaryRangesIndex(nums);
    assertIterableEquals(result, expected);
  }

  static Stream<Arguments> argsAndExpectedProvider() {
    return Stream.of(arguments(new int[] {0, 1, 2, 4, 5, 7}, Arrays.asList("0->2", "4->5", "7")));
  }
}
