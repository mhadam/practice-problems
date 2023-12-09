package us.hadam.practice.divideconquer;

import java.util.*;

public class MergeKSortedLists {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public record Entry(Integer key, Integer value) implements Comparable<Entry> {
    @Override
    public int compareTo(Entry o) {
      return Comparator.comparingInt(Entry::key).thenComparingInt(Entry::value).compare(this, o);
    }
  }

  public static ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<Entry> pq = new PriorityQueue<>();
    int count = 0;
    for (ListNode list : lists) {
      ListNode cur = list;
      while (cur != null) {
        pq.add(new Entry(cur.val, count++));
        cur = cur.next;
      }
    }
    ListNode head = null;
    ListNode prev = null;
    for (int i = 0; i < count; i++) {
      Entry e = pq.remove();
      if (i == 0) {
        head = new ListNode(e.key);
        prev = head;
      } else {
        ListNode next = new ListNode(e.key);
        prev.next = next;
        prev = next;
      }
    }
    return head;
  }

  public static ListNode mergeKListsDivideConquer(ListNode[] lists) {
    List<ListNode> queue = new ArrayList<>(Arrays.asList(lists));
    while (queue.size() >= 2) {
      ListNode first = queue.remove(0);
      ListNode second = queue.remove(0);
      ListNode merged = mergeLists(first, second);
      queue.add(merged);
    }
    return queue.remove(0);
  }

  public static ListNode mergeLists(ListNode l1, ListNode l2) {
    ListNode prev, head;
    prev = head = new ListNode();
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        prev.next = l1;
        prev = l1;
        l1 = l1.next;
      } else {
        prev.next = l2;
        prev = l2;
        l2 = l2.next;
      }
    }
    if (l1 != null) {
      prev.next = l1;
    } else if (l2 != null) {
      prev.next = l2;
    }
    return head.next;
  }
}
