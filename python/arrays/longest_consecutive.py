import itertools
from typing import List

import pytest


# Example 1:
#
# Input: nums = [100,4,200,1,3,2]
# Output: 4
# Explanation:
# The longest consecutive elements sequence is [1, 2, 3, 4].
# Therefore its length is 4.

# Example 2:
#
# Input: nums = [0,3,7,2,5,8,4,6,0,1]
# Output: 9


# which data structure?
# what defines a consecutive sequence?
def longest_consecutive(nums: List[int]) -> int:
    result = 0
    num_set = set(nums)
    for n in num_set:
        if n - 1 in num_set:
            continue
        c = itertools.count(1)
        while True:
            offset = next(c)
            if offset + n not in num_set:
                break
        if offset > result:
            result = offset
    return result


@pytest.mark.parametrize(
    "test_input,expected",
    [([100, 4, 200, 1, 3, 2], 4), ([0, 3, 7, 2, 5, 8, 4, 6, 0, 1], 9)],
)
def test_function(test_input, expected):
    assert expected == longest_consecutive(test_input)
