import sys

n, m, k = map(int, sys.stdin.readline().split())

dy = [0, -1, 0, 1, 0]
dx = [1, 0, -1, 0, 0]
trash = [[0]*m for _ in range(n)]
trash_max = 0
cnt = 0

for _ in range(k):
    r, c = map(int, sys.stdin.readline().split())
    trash[r-1][c-1] = 1

for i in range(n):
    for j in range(m):
        if trash[i][j] == 1:
            stack = []
            stack.append(j)
            stack.append(i)
            cnt = 0
            
            while stack:
                y = stack.pop()
                x = stack.pop()

                for dir in range(5):
                    if 0 <= y + dy[dir] < n and 0 <= x + dx[dir] < m:
                        if trash[y + dy[dir]][x + dx[dir]] == 1:
                            trash[y + dy[dir]][x + dx[dir]] = 2
                            stack.append(x + dx[dir])
                            stack.append(y + dy[dir])
                            cnt += 1
                            if trash_max <= cnt:
                                trash_max = cnt

print(trash_max)