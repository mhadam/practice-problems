import itertools
from typing import List


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
