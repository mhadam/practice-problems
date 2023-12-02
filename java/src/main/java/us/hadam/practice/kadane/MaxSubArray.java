package us.hadam.practice.kadane;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int best = Integer.MIN_VALUE;
        int sum = 0;
        for (int num: nums) {
            sum = Math.max(num, num + sum);
            best = Math.max(best, sum);
        }
        return best;
    }
}
