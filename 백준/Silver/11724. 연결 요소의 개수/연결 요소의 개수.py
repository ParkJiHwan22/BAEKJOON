import sys

n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
visited = [0 for _ in range(n+1)]


for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a) 
    
def dfs(n, graph, visited):
    answer = 0
    for i in range(1, n+1):
        if visited[i] == 1:
            continue
        
        else:
            answer += 1
            visited[i] = 1
            stack = [i]
            
            while stack:
                p = stack.pop()
                if graph[p]:
                    for j in range(len(graph[p])):
                        if visited[graph[p][j]] == 0:
                            visited[graph[p][j]] = 1
                            stack.append(graph[p][j])
     
    return answer

print(dfs(n, graph, visited))