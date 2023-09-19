from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

matrix = [list(input().strip()) for _ in range(n)]

for i in range(n):
    for j in range(m):
        if matrix[i][j] == 'I':
            queue = deque([(i, j)])

cnt = 0            
while queue:
    y, x = queue.popleft()
    
    for dir in range(4):
        if 0 <= y + dy[dir] < n and 0 <= x + dx[dir] < m:
            if matrix[y + dy[dir]][x + dx[dir]] == 'P':
                matrix[y + dy[dir]][x + dx[dir]] = 'O'
                cnt += 1
                queue.append((y + dy[dir], x + dx[dir]))
            
            elif matrix[y + dy[dir]][x + dx[dir]] == 'O':
                matrix[y + dy[dir]][x + dx[dir]] = 'X'
                queue.append((y + dy[dir], x + dx[dir]))

if cnt == 0:
    print('TT')
else:
    print(cnt)
