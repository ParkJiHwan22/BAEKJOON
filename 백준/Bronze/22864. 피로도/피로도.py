import sys

A, B, C, M = map(int, sys.stdin.readline().split())
t, work = 0, 0

for _ in range(24):
    if t + A <= M:
        t = t + A
        work += B
    else:
        t = max(0, t - C)

print(work)