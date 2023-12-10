package us.hadam.practice.design;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LRUCacheTest {

  static ObjectMapper mapper = new ObjectMapper();

  @ParameterizedTest
  @MethodSource("provider")
  void testLruCacheTest(
      String[] commands, List<List<Integer>> argsList, List<Integer> expectedList) {
    LRUCache cache = null;
    for (int i = 0; i < commands.length; i++) {
      String command = commands[i];
      List<Integer> args = argsList.get(i);
      Integer expected = expectedList.get(i);
      switch (command) {
        case "LRUCache" -> cache = new LRUCache(args.get(0));
        case "put" -> cache.put(args.get(0), args.get(1));
        case "get" -> {
          Integer result = cache.get(args.get(0));
          assertEquals(expected, result);
        }
        default -> {}
      }
    }
  }

  static Stream<Arguments> provider() throws JsonProcessingException {
    String VALUES = "[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]";
    String RESULTS = "[null, null, null, 1, null, -1, null, -1, 3, 4]";
    String[] commands = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
    List<List<Integer>> values = mapper.readValue(VALUES, new TypeReference<>() {});
    List<Integer> results = mapper.readValue(RESULTS, new TypeReference<>() {});
    return Stream.of(Arguments.of(commands, values, results));
  }
}
