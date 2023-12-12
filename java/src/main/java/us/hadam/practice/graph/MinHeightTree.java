package us.hadam.practice.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class MinHeightTree {
  public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n <= 2) {
      return IntStream.range(0, n).boxed().toList();
    }
    // initialize with empty sets
    List<Set<Integer>> neighbors = new ArrayList<>();
    for (int i=0; i<n; i++) {
      neighbors.add(new HashSet<>());
    }

    // add every neighbor
    for (int[] edge: edges) {
      int start = edge[0], end = edge[1];
      neighbors.get(start).add(end);
      neighbors.get(end).add(start);
    }

    // initial leaves
    Set<Integer> leaves = new HashSet<>();
    for (int i=0; i<n; i++) {
      if (neighbors.get(i).size() == 1) {
        leaves.add(i);
      }
    }
    // start pruning
    int remaining = n;
    while (remaining > 2) {
      remaining -= leaves.size();
      Set<Integer> newLeaves = new HashSet<>();
      for (Integer leaf: leaves) {
        for (Integer neighbor: neighbors.get(leaf)) {
          Set<Integer> hood = neighbors.get(neighbor);
          hood.remove(leaf);
          if (hood.size() <= 1) {
            newLeaves.add(neighbor);
          }
        }
      }
      leaves = newLeaves;
    }
    return leaves.stream().toList();
  }
}
