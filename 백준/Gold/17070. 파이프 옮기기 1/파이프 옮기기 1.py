from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
cnt = 0

command = [[(1, 1), (1, 0)], [(1, 1), (0, 1)], [(1, 1), (1, 0), (0, 1)]]
dp = [[[0, 0, 0] for _ in range(n)] for _ in range(n)]
dp[0][1][0] = 1
sum_x_y = 1

while sum_x_y <= 2*(n - 1):
    a = 0
    b = sum_x_y
    tmp = deque([])
    
    for i in range(sum_x_y + 1):
        if a < n and b < n:
            tmp.append((a, b))
        a += 1
        b -= 1     
    
    while tmp:
        x, y = tmp.popleft()     
        for k in range(3):
            if dp[y][x][k]:
                for j in command[k]:
                    if j == (1, 0):
                        if x + j[0] < n and y + j[1] < n and arr[y + j[1]][x + j[0]] == 0:
                            dp[y + j[1]][x + j[0]][0] += dp[y][x][k]

                    elif j == (0, 1):
                        if x + j[0] < n and y + j[1] < n and arr[y + j[1]][x + j[0]] == 0:
                            dp[y + j[1]][x + j[0]][1] += dp[y][x][k]
                            
                    else:
                        if x + j[0] < n and y + j[1] < n and arr[y + 1][x] + arr[y][x + 1] + arr[y + 1][x + 1] == 0:
                            dp[y + j[1]][x + j[0]][2] += dp[y][x][k]
            
    sum_x_y += 1
                
print(sum(dp[-1][-1]))