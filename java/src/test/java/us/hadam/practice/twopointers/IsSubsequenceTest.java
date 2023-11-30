package us.hadam.practice.twopointers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.twopointers.IsPalindrome.isPalindromePointersMethod;
import static us.hadam.practice.twopointers.IsSubsequence.isSubsequence;

class IsSubsequenceTest {

    @ParameterizedTest
    @MethodSource("argsAndExpectedProvider")
    public void testIsSubsequence(String sub, String value, boolean expected)
    {
        assertEquals(isSubsequence(sub, value), expected);
    }

    static Stream<Arguments> argsAndExpectedProvider() {
        return Stream.of(
                arguments("abc", "ahbgdc", true),
                arguments("axc", "ahbgdc", false),
                arguments("aaaaaa", "bbaaaa", false)
        );
    }
}