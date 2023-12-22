def consecutive_ones(nums, k):
    left = 0
    for i, num in enumerate(nums):
        if num == 0:
            k -= 1

        if k < 0:
            k += 1 - nums[left]
            left += 1
    return len(nums) - left
