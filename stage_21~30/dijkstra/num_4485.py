import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)
cnt = 0

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def dijkstra(graph, x, y):
    distance = [[INF]*n for _ in range(n)]

    q = []
    heapq.heappush(q, (graph[x][y], x, y))
    distance[x][y] = graph[x][y]

    while q:
        dist, x, y = heapq.heappop(q)
        if distance[x][y] < dist:
            continue
        for dir in range(4):
            if 0 <= x + dx[dir] < n and 0 <= y + dy[dir] < n:
                cost = dist + graph[x + dx[dir]][ y + dy[dir]]

                if cost < distance[x + dx[dir]][ y + dy[dir]]:
                    distance[x + dx[dir]][ y + dy[dir]] = cost
                    heapq.heappush(q, (cost, x + dx[dir], y + dy[dir]))
        
    return distance[n-1][n-1]

while True:
    n = int(input())

    if n == 0:
      break

    graph = [list(map(int, input().split())) for _ in range(n)]
    cnt += 1
    print(f'Problem {cnt}: {dijkstra(graph, 0, 0)}')

    
