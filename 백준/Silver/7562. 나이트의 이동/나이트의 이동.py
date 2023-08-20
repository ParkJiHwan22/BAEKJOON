from collections import deque
import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    i = int(input())

    start_x, start_y = map(int, input().split())
    end_x, end_y = map(int, input().split())

    def bfs(start_x, start_y, cnt):
        dx = [2, 1, -1, -2, -2, -1, 1, 2]
        dy = [-1, -2, -2, -1, 1, 2, 2, 1]
        
        visited = [[0] * i for _ in range(i)]
        
        queue = deque([(start_x, start_y, 0)])  # x, y, cnt
        
        while queue:
            x, y, cnt = queue.popleft()
            
            if x == end_x and y == end_y: # 종료조건
                break
            
            for dir in range(8):
                new_x, new_y = x + dx[dir], y + dy[dir]
                
                if 0 <= new_x < i and 0 <= new_y < i and visited[new_y][new_x] == 0:
                    visited[new_y][new_x] = cnt + 1
                    queue.append((new_x, new_y, cnt + 1))
        
        print(cnt)

    bfs(start_x, start_y, 0)