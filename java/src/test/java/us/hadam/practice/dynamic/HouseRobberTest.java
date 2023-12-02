package us.hadam.practice.dynamic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.dynamic.HouseRobber.rob;

class HouseRobberTest {

    @ParameterizedTest
    @MethodSource("provider")
    void testRob(int[] input, int expected) {
        int result = rob(input);
        assertEquals(result, expected);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                arguments(new int[]{1,2,3,1}, 4),
                arguments(new int[]{2,7,9,3,1}, 12)
        );
    }
}