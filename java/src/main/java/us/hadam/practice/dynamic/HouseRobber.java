package us.hadam.practice.dynamic;

class HouseRobber {
  public static int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int r_m1 = nums[0];
    int r_m2 = 0;
    for (int i = 1; i < nums.length; i++) {
      int current = Math.max(r_m1, r_m2 + nums[i]);
      r_m2 = r_m1;
      r_m1 = current;
    }
    return r_m1;
  }
}
