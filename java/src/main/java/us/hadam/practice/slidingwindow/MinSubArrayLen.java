package us.hadam.practice.slidingwindow;

public class MinSubArrayLen {
    // return the length of the smallest subarray that adds up to/exceeds target
    public static int minSubArrayLen(int target, int[] nums) {
        int best = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                best = Math.min(i-left+1, best);
                sum -= nums[left++];
            }
        }
        return best == Integer.MAX_VALUE ? 0 : best;
    }
}
