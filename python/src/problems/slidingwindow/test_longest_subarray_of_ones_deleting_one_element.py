import pytest

from problems.slidingwindow.longest_subarray_of_ones_deleting_one_element import (
    longest_subarray,
)


@pytest.mark.parametrize(
    "nums, expected",
    [
        ([1, 1, 0, 1], 3),
        ([0, 1, 1, 1, 0, 1, 1, 0, 1], 5),
        ([1, 1, 0, 0, 1, 1, 1, 0, 1], 4),
    ],
)
def test_longest_subarray(nums, expected):
    assert longest_subarray(nums) == expected
