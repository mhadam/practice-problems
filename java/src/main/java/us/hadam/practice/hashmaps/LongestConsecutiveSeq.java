package us.hadam.practice.hashmaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
  public static int longestConsecutive(int[] nums) {
    Set<Integer> numsSet = new HashSet<>(Arrays.stream(nums).boxed().toList());
    int longest = 0;
    for (int num : nums) {
      if (numsSet.contains(num - 1)) {
        continue;
      }
      int count = 0;
      while (numsSet.contains(num + count)) {
        count++;
      }
      longest = Math.max(count, longest);
    }
    return longest;
  }
}
