package us.hadam.practice.twopointers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.twopointers.IsPalindrome.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

 class IsPalindromeTest {

  @ParameterizedTest
  @MethodSource("argsAndExpectedProvider")
   void testIsPalindrome(String value, boolean expected) {
    assertEquals(isPalindrome(value), expected);
  }

  @ParameterizedTest
  @MethodSource("argsAndExpectedProvider")
   void testIsPalindromePointers(String value, boolean expected) {
    assertEquals(isPalindromePointersMethod(value), expected);
  }

  @ParameterizedTest
  @MethodSource("argsAndExpectedProvider")
   void testIsPalindromeIndex(String value, boolean expected) {
    assertEquals(isPalindromeIndexMethod(value), expected);
  }

  static Stream<Arguments> argsAndExpectedProvider() {
    return Stream.of(arguments("A man, a plan, a canal: Panama", true));
  }
}
