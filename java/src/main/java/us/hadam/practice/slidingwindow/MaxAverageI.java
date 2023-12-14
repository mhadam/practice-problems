package us.hadam.practice.slidingwindow;

public class MaxAverageI {
  public static double findMaxAverage(int[] nums, int k) {
    double best = Integer.MIN_VALUE;
    double sum = 0;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    if (sum >= best) best = sum;
    for (int i = k; i < nums.length; i++) {
      sum += nums[i] - nums[i - k];
      if (sum >= best) best = sum;
    }
    return best / (double) k;
  }
}
