package us.hadam.practice.divideconquer;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static us.hadam.practice.divideconquer.MergeKSortedLists.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MergeKSortedListsTest {

  @ParameterizedTest
  @MethodSource("argsAndExpectedProvider")
  void testMergeKLists(int[][] lists, int[] expected) {
    MergeKSortedLists.ListNode[] input = generateLists(lists);
    MergeKSortedLists.ListNode result = mergeKLists(input);
    assertArrayEquals(expected, getResult(result));
  }

  @ParameterizedTest
  @MethodSource("argsAndExpectedProvider")
  void testMergeKListsDandC(int[][] lists, int[] expected) {
    MergeKSortedLists.ListNode[] input = generateLists(lists);
    MergeKSortedLists.ListNode result = mergeKListsDivideConquer(input);
    assertArrayEquals(expected, getResult(result));
  }

  @ParameterizedTest
  @MethodSource("mergeTwoListsProvider")
  void testMergeTwoLists(int[] list1, int[] list2, int[] expected) {
    MergeKSortedLists.ListNode l1 = generateList(list1);
    MergeKSortedLists.ListNode l2 = generateList(list2);
    MergeKSortedLists.ListNode result = mergeLists(l1, l2);
    assertArrayEquals(expected, getResult(result));
  }

  static MergeKSortedLists.ListNode[] generateLists(int[][] nums) {
    List<MergeKSortedLists.ListNode> nodes = new ArrayList<>();
    for (int[] list : nums) {
      nodes.add(generateList(list));
    }
    return nodes.toArray(MergeKSortedLists.ListNode[]::new);
  }

  static MergeKSortedLists.ListNode generateList(int[] nums) {
    MergeKSortedLists.ListNode head = null;
    MergeKSortedLists.ListNode prev = null;
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        head = new MergeKSortedLists.ListNode(nums[i]);
        prev = head;
      } else {
        prev.next = new MergeKSortedLists.ListNode(nums[i]);
        prev = prev.next;
      }
    }
    return head;
  }

  static int[] getResult(MergeKSortedLists.ListNode result) {
    List<Integer> nums = new ArrayList<>();
    MergeKSortedLists.ListNode cur = result;
    while (cur != null) {
      nums.add(cur.val);
      cur = cur.next;
    }
    return nums.stream().mapToInt(Integer::intValue).toArray();
  }

  static Stream<Arguments> argsAndExpectedProvider() {
    return Stream.of(
        arguments(
            new int[][] {new int[] {1, 4, 5}, new int[] {1, 3, 4}, new int[] {2, 6}},
            new int[] {1, 1, 2, 3, 4, 4, 5, 6}));
  }

  static Stream<Arguments> mergeTwoListsProvider() {
    return Stream.of(arguments(new int[] {1, 4, 5}, new int[] {2, 6}, new int[] {1, 2, 4, 5, 6}));
  }
}
