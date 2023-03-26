n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

matrix = [[] for _ in range(n+1)]

for i in range(n):
    for j in range(n):
        if grid[i][j] == 1:
            matrix[i+1].append(j)
            
for i in range(n):
    for j in range(n):
        if match
