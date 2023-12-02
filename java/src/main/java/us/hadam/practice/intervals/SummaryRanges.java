package us.hadam.practice.intervals;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        if (nums.length < 1) {
            return new ArrayList<>();
        }
        int stride = 0;
        String strideStr = "";
        List<String> result = new ArrayList<>();
        for (int i=1; i<nums.length; i++) {
            if (nums[i] - 1 == nums[i-1]) {
                stride++;
            } else {
                if (stride == 0) {
                    strideStr = String.valueOf(nums[i-1]);
                } else {
                    strideStr = nums[i-stride-1] + "->" + nums[i-1];
                }
                result.add(strideStr);
                stride = 0;
            }
        }
        if (stride == 0) {
            result.add(String.valueOf(nums[nums.length-1]));
        } else {
            result.add(nums[nums.length-stride-1] + "->" + nums[nums.length-1]);
        }
        return result;
    }

    public static List<String> summaryRangesIndex(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int start = nums[i];
            while (i+1<nums.length && nums[i]+1 == nums[i+1]) {
                i++;
            }
            if (start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else {
                result.add(String.valueOf(start));
            }
        }
        return result;
    }
}
