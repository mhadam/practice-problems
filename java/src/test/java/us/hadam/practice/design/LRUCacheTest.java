package us.hadam.practice.design;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LRUCacheTest {

  static ObjectMapper mapper = new ObjectMapper();

  @ParameterizedTest
  @MethodSource("provider")
  void testLruCacheTest(
      List<String> commands, List<List<Integer>> argsList, List<Integer> expectedList) {
    LRUCache cache = null;
    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < commands.size(); i++) {
      String command = commands.get(i);
      List<Integer> args = argsList.get(i);
      switch (command) {
        case "LRUCache" -> {
          cache = new LRUCache(args.get(0));
          results.add(null);
        }
        case "put" -> {
          cache.put(args.get(0), args.get(1));
          results.add(null);
        }
        case "get" -> {
          Integer result = cache.get(args.get(0));
          results.add(result);
        }
        default -> {}
      }
    }
    assertIterableEquals(expectedList, results);
  }

  static Stream<Arguments> provider() throws IOException {
    Path path = Paths.get("src/test/resources/testdata/lrucache/cases.jsonl");
    List<String> lines = Files.readAllLines(path);
    List<List<String>> cases =
        IntStream.range(0, lines.size() / 3)
            .map(i -> i * 3)
            .mapToObj(i -> lines.subList(i, i + 3))
            .toList();
    List<Arguments> result = new ArrayList<>();
    for (List<String> c : cases) {
      result.add(
          Arguments.of(
              mapper.readValue(c.get(0), new TypeReference<List<String>>() {}),
              mapper.readValue(c.get(1), new TypeReference<List<List<Integer>>>() {}),
              mapper.readValue(c.get(2), new TypeReference<List<Integer>>() {})));
    }
    return result.stream();
  }
}
