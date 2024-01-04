import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

n, m, k, x = map(int, input().split())

graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)

for i in range(1, m + 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    
    
def dijkstra(x):
    q = []
    heapq.heappush(q, (0, x)) # 최단거리, 현재위치
    distance[x] = 0
    
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for j in graph[now]: 
            cost = dist + 1

                        
            if cost < distance[j]:
                distance[j] = cost
                heapq.heappush(q, (cost, j))
                
        
dijkstra(x)        

cnt = 0        
for l in range(1, n+1):
    if distance[l] == k:
        cnt += 1
        print(l)
    
if cnt == 0:
    print(-1)