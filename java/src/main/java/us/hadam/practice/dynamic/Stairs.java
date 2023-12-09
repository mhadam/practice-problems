package us.hadam.practice.dynamic;

import java.util.HashMap;
import java.util.Map;

public class Stairs {
  public int climbStairs(int n) {
    Map<Integer, Integer> memo = new HashMap<>();
    memo.put(0, 0);
    memo.put(1, 1);
    for (int i = 2; i < n; i++) {
      memo.put(i, memo.get(i) + memo.get(i - 2));
    }
    return memo.get(n);
  }
}
