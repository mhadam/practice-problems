package us.hadam.practice.arrays;

public class RemoveDuplicatesI {
    public static int removeDuplicates(int[] nums) {
        int i = 1;
        int pi = 1;
        while (i < nums.length) {
            if (nums[i-1] != nums[i]) {
                nums[pi] = nums[i];
                pi++;
            }
            i++;
        }
        return pi;
    }
}
