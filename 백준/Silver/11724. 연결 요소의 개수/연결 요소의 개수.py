import sys

n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]

for i in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

visited = [0]*(n + 1)
stack = []
cnt = 0

for x in range(1, n+1):
    if visited[x] != 1:
        visited[x] = 1
        cnt += 1
        stack.append(x)

        while stack:
            y = stack.pop()
            for z in graph[y]:
                if visited[z] == 0:
                    visited[z] = 1
                    stack.append(z)

print(cnt)