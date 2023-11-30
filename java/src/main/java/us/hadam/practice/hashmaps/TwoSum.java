package us.hadam.practice.hashmaps;

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int c = 0;
        for (int n: nums) {
            int wanted = target - n;
            Integer found = numMap.get(wanted);
            if (found != null && found != c) {
                return new int[]{c, found};
            }
            numMap.put(n, c++);
        }
        return new int[]{};
    }
}
