def longest_subarray(nums: list[int]) -> int:
    left = 0
    zeroes = 0
    best = 0
    for i, n in enumerate(nums):
        zeroes += 1 - n
        while zeroes > 1 and left <= i:
            zeroes -= 1 - nums[left]
            left += 1
        best = max(best, i - left)
    return best
