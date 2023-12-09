package us.hadam.practice.dynamic;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.dynamic.Triangle.minimumTotal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

 class TriangleTest {

  static ObjectMapper mapper = new ObjectMapper();

  @ParameterizedTest
  @MethodSource("provider")
   void testMinimumTotal(List<List<Integer>> input, int expected) {
    int result = minimumTotal(input);
    assertEquals(expected, result);
  }

  static List<List<Integer>> deserialize(String input) throws JsonProcessingException {
    return mapper.readValue(input, new TypeReference<>() {});
  }

  static Stream<Arguments> provider() throws JsonProcessingException {
    return Stream.of(
        arguments(deserialize("[[2],[3,4],[6,5,7],[4,1,8,3]]"), 11),
        arguments(deserialize("[[-10]]"), -10));
  }
}
