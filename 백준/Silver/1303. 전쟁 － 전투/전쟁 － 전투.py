from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

soldier = [input().rstrip() for _ in range(m)]
visited = [[0] * n for _ in range(m)]
W_ans = []
B_ans = []

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

q = deque()

for i in range(m):
    for j in range(n):
        if visited[i][j] == 0:
            if soldier[i][j] == 'W':
                visited[i][j] = 1
                q.append((i, j))

                tmp = 1
                while q:
                    y, x = q.popleft()
                    
                    for dir in range(4):
                        nx = x + dx[dir]
                        ny = y + dy[dir]
                        
                        if 0 <= nx < n and 0 <= ny < m and visited[ny][nx] == 0 and soldier[ny][nx] == 'W':
                            visited[ny][nx] = 1
                            tmp += 1
                            q.append((ny, nx))
                
                W_ans.append(tmp)
                
            else:
                visited[i][j] = 1
                q.append((i, j))

                tmp = 1
                while q:
                    y, x = q.popleft()
                    
                    for dir in range(4):
                        nx = x + dx[dir]
                        ny = y + dy[dir]
                        
                        if 0 <= nx < n and 0 <= ny < m and visited[ny][nx] == 0 and soldier[ny][nx] == 'B':
                            visited[ny][nx] = 1
                            tmp += 1
                            q.append((ny, nx))
                
                B_ans.append(tmp)
                
print(sum([x ** 2 for x in W_ans]), (sum([y ** 2 for y in B_ans])))