from collections import Counter


def equal_pairs(grid: list[list[int]]) -> int:
    m = Counter([tuple(r) for r in grid])
    total = 0
    for i in range(len(grid[0])):
        row = [r[i] for r in grid]
        try:
            total += m[tuple(row)]
        except KeyError:
            pass
    return total
