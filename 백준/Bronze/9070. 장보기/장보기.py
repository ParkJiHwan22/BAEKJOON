import sys

num_cases = int(sys.stdin.readline())

for _ in range(num_cases):
    min_ratio = float('inf')
    min_b_value = 0

    num_pairs = int(sys.stdin.readline())
    for _ in range(num_pairs):
        a, b = map(int, sys.stdin.readline().split())

        ratio = b / a
        if ratio < min_ratio:
            min_ratio = ratio
            min_b_value = b
        elif ratio == min_ratio:
            if b < min_b_value:
                min_b_value = b

    print(min_b_value)