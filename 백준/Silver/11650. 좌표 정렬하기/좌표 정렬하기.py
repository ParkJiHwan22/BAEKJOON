import sys

N = int(input())

point_list = []
for i in range(N):
    [x, y] = map(int, sys.stdin.readline().split())
    point_list.append([x,y])

point_list.sort()

for i in range(N):
    print(*point_list[i])
