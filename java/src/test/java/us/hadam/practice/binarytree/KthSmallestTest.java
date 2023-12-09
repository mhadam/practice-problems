package us.hadam.practice.binarytree;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.binarytree.KthSmallest.kthSmallestIterative;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.hadam.practice.binarytree.util.BinarySearchTree;
import us.hadam.practice.binarytree.util.TreeNode;

 class KthSmallestTest {

  @ParameterizedTest
  @MethodSource("argsProvider")
   void testKthSmallest(TreeNode root, int k, int expected) {
    assertEquals(kthSmallestIterative(root, k), expected);
  }

  static Stream<Arguments> argsProvider() {
    return Stream.of(
        arguments(BinarySearchTree.create(new Integer[] {5, 3, 6, 2, 4, null, null, 1}), 3, 3),
        arguments(BinarySearchTree.create(new Integer[] {3, 1, 4, null, 2}), 1, 1));
  }
}
