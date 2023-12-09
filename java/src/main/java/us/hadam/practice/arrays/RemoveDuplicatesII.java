package us.hadam.practice.arrays;


public class RemoveDuplicatesII {
  public static int removeDuplicates(int[] nums) {
    int i = 1, pi = 1;
    int dups = 0;
    while (pi < nums.length) {
      dups = (nums[pi] == nums[i - 1]) ? ++dups : 0;
      if (dups <= 1) {
        nums[i++] = nums[pi++];
      } else {
        pi++;
      }
    }
    return i;
  }
}
