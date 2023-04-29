import sys
from collections import deque
input = sys.stdin.readline

m, n = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

cnt = 0
tmp = [[0]*m for _ in range(n)]

q = deque()
for y in range(n):
    for x in range(m):
        if graph[y][x] == 1:
            q.appendleft((y, x))

while q:
    y, x = q.popleft()
    for dir in range(4):
        if 0 <= y + dy[dir] < n and 0 <= x + dx[dir] < m:
            if graph[y + dy[dir]][x + dx[dir]] == 0:
                graph[y + dy[dir]][x + dx[dir]] = cnt + 2
                graph.appendleft((y + dy[dir], x + dx[dir]))

                
print(cnt)


#     if change == 0:
#         break
#     else:
#         cnt += 1

# err = 0
# for i in range(n):
#     for j in range(m):
#         if graph[i][j] == 0:
#             err += 1

# if err == 0:
#     print(cnt)
# else:
#     print(-1)

# print(graph)