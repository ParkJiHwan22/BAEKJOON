import sys
from collections import deque
input = sys.stdin.readline

m, n = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
change = 0

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

tmp = [[0]*m for _ in range(n)]

q = deque()
for y in range(n):
    for x in range(m):
        if graph[y][x] == 1:
            q.append((y, x))

while q:
    y, x = q.popleft()
    for dir in range(4):
        if 0 <= y + dy[dir] < n and 0 <= x + dx[dir] < m:
            if graph[y + dy[dir]][x + dx[dir]] == 0:
                graph[y + dy[dir]][x + dx[dir]] = graph[y][x] + 1
                change += 1
                q.append((y + dy[dir], x + dx[dir]))

err = 0
max_num = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] > max_num:
            max_num = graph[i][j]
        elif graph[i][j] == 0:
            err += 1
            break

if err == 0:
    print(max_num - 1)
else:
    print(-1)