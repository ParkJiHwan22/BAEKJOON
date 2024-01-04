import sys
input = sys.stdin.readline

dx = [1, 1, 0, -1, -1, -1, 0, 1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]

n = int(input())
map_list = [input().strip() for _ in range(n)]
res_list = [[0]*n for _ in range(n)]


for i in range(n):
    for j in range(n):     
        if map_list[i][j] != '.':
            res_list[i][j] = '*'
            
        if res_list[i][j] == '*':
            for dir in range(8):
                if 0 <= i + dx[dir] < n and 0 <= j + dy[dir] < n:
                    if res_list[i + dx[dir]][j + dy[dir]] != '*': # 둘러싼 8방향을 돌 때, 정수가 아닌 부분에 더할 때 오류가 났다.
                        res_list[i + dx[dir]][j + dy[dir]] += int(map_list[i][j])

for i in range(n):
    for j in range(n):
        if res_list[i][j] != '*':
            if res_list[i][j] >= 10:
                res_list[i][j] = 'M'

for i in range(n):
    print(''.join(map(str, res_list[i])))