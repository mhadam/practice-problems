def remove_stars(s: str) -> str:
    result = []
    for l in s:
        if l == "*":
            result.pop()
        else:
            result.append(l)
    return "".join(result)
