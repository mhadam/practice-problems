import pytest


from problems.slidingwindow.max_consecutive_ones_3 import consecutive_ones


@pytest.mark.parametrize(
    "nums, k, expected",
    [([1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], 2, 6), ([1, 1, 1, 1, 0, 0, 0], 2, 6)],
)
def test_consecutive_ones(nums, k, expected):
    assert consecutive_ones(nums, k) == expected
