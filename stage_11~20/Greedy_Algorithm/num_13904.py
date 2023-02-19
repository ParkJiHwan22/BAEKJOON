import sys

n = int(sys.stdin.readline())
project = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

project = sorted(project, reverse=True)

tmp = []
for i in range(n):
    if project[i][0] > n - i:
        tmp.append(project[i])

print(tmp)