package us.hadam.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int n: nums) {
            m.compute(n, (k, v) -> v==null ? 1: v+1);
        }
        return m.entrySet()
                .stream()
                .filter(e -> e.getValue() > nums.length/2)
                .map(Map.Entry::getKey)
                .findAny().orElse(-1);
    }
}
