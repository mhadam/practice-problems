import pytest

from problems.arrays.longest_consecutive import longest_consecutive


@pytest.mark.parametrize(
    "test_input,expected",
    [([100, 4, 200, 1, 3, 2], 4), ([0, 3, 7, 2, 5, 8, 4, 6, 0, 1], 9)],
)
def test_function(test_input, expected):
    assert expected == longest_consecutive(test_input)
