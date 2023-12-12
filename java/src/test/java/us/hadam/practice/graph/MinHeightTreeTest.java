package us.hadam.practice.graph;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.graph.MinHeightTree.findMinHeightTrees;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MinHeightTreeTest {

  static ObjectMapper mapper = new ObjectMapper();

// n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]], [3,4]

  @ParameterizedTest
  @MethodSource("provider")
  void testFindMinHeightTrees(int n, int[][] edges, List<Integer> expected) {
    assertThat(findMinHeightTrees(n, edges)).containsExactlyInAnyOrderElementsOf(expected);
  }

  static int[][] parseEdges(String edges) throws JsonProcessingException {
    return mapper.readValue(edges, new TypeReference<>(){});
  }

  static List<Integer> parseResult(String result) throws JsonProcessingException {
    return mapper.readValue(result, new TypeReference<>() {
    });
  }

  static Stream<Arguments> provider() throws JsonProcessingException {
    return Stream.of(
        arguments(6, parseEdges("[[3,0],[3,1],[3,2],[3,4],[5,4]]"), parseResult("[3,4]")),
        arguments(4, parseEdges("[[1,0],[1,2],[1,3]]"), parseResult("[1]")),
        arguments(3, parseEdges("[[0,1],[0,2]]"), parseResult("[0]"))
    );
  }
}