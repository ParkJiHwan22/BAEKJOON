import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())


def bfs(start):
    cnt = 1
    queue = deque([start])
    visit = [0 for _ in range(n+1)]
    visit[start] = 1

    while queue:
        v = queue.popleft()

        for i in graph[v]:
            if not visit[i]:
                visit[i] = 1
                cnt += 1
                queue.append(i)
    
    return cnt


graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[b].append(a)

max_cnt = 1
ans = []

for j in range(1, n+1):
    cnt = bfs(j)
    print(cnt)
    if cnt > max_cnt:
        max_cnt = cnt
        ans.clear()
        ans.append(j)
    elif cnt == max_cnt:
        ans.append(j)

print(ans)