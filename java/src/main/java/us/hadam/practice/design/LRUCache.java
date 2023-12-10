package us.hadam.practice.design;

import java.util.HashMap;
import java.util.Map;
import us.hadam.practice.design.lru.ListNode;

public class LRUCache {
  public final int capacity;
  public ListNode tail;
  public ListNode head;
  public final Map<Integer, ListNode> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>(capacity);
    tail = new ListNode(-1, -1);
    head = new ListNode(-1, -1);
    tail.prev = head;
    head.next = tail;
  }

  private void remove(ListNode e) {
    e.prev.next = e.next;
    e.next.prev = e.prev;
  }

  private void add(ListNode e) {
    ListNode last = tail.prev;
    e.next = tail;
    e.prev = last;
    last.next = e;
    tail.prev = e;
  }

  int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    ListNode e = map.get(key);
    remove(e);
    add(e);
    return e.val;
  }

  void put(int key, int value) {
    if (map.containsKey(key)) {
      ListNode existing = map.get(key);
      remove(existing);
      add(existing);
      return;
    }
    if (map.size() + 1 > capacity) {
      ListNode toRemove = map.remove(head.next.key);
      remove(toRemove);
    }
    ListNode created = new ListNode(key, value);
    add(created);
    map.put(key, created);
  }
}
