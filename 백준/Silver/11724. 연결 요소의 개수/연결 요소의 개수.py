import sys

n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
visited = [0]*(n + 1)
answer = 0

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a) 

for i in range(1, n+1): # dfs
    if visited[i] == 0: 
        visited[i] = 1
        answer += 1
        stack = [i]
        
        while stack:
            p = stack.pop()
            for j in graph[p]:
                if visited[j] == 0:
                    visited[j] = 1
                    stack.append(j)

print(answer)