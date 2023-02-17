import sys

n, m = map(int, sys.stdin.readline().split())
chess_board = [sys.stdin.readline().split() for _ in range(n)]
board = [[] for _ in range(n)]
result = 0

for i in range(n):
    for j in chess_board[i][0]:
        board[i].append(j)
        
wh_board = [[] for _ in range(8)]

for i in range(8):
    for j in range(8):
        if (i+j) % 2 == 0:
            wh_board[j].append('W')
        else:
            wh_board[j].append('B')

for i in range(n-7):
    for j in range(m-7):
        cnt = 0
        for x in range(8):
            for y in range(8):
                if board[i+x][j+y] == wh_board[x][y]:
                    cnt += 1
        
        cnt_max = max(cnt, 64-cnt)
        if cnt_max > result:
            result = cnt_max

print(64 - result)