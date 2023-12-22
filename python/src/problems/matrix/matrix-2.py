def new_generate_matrix(n):
    """
    :type n: int
    :rtype: List[List[int]]
    """
    result = [list(range(n)) for _ in range(n)]
    x, y = n - 1, 0
    p = 1
    c = n
    vn = 0
    vs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    while c > 0:
        for j in range(c):
            result[y][x] = p
            xn, xy = vs[vn % 4]
            x += xn
            y += xy
        vn += 1
        c -= 1
    return result


def generate_matrix(n):
    """
    :type n: int
    :rtype: List[List[int]]
    """
    result = [list(range(n)) for _ in range(n)]
    x, y = n - 1, 0
    c = n - 1
    vn = 1
    vs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    result[0] = list(range(1, n + 1))
    rest = list(range(n + 1, n * n + 1))
    while c > 0:
        for i in range(2):
            for j in range(c):
                sp = vs[vn % 4]
                x += sp[0]
                y += sp[1]
                result[y][x] = rest.pop(0)
            vn += 1
        c -= 1
    return result


for r in generate_matrix(10):
    print(r)

print(generate_matrix(1))
