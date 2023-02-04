import sys

N = int(sys.stdin.readline())
pts_list = [list(sys.stdin.readline().strip()) for _ in range(N)]

pts = 0
for i in range(N):
    cnt = 0
    for j in range(N):
        if pts_list[i][j] == '.': # . 이 있을 경우
            cnt += 1 # 연속된 점의 개수
            if cnt == 2: # 연속된 점이 2개가 될 경우
                pts += 1 # 가로로 누울 수 있는 자리 + 1
                
        else:
            cnt = 0

pts_2 = 0
for k in range(N):
    cnt_2 = 0
    for l in range(N):
        if pts_list[l][k] == '.':  
            cnt_2 += 1  # 연속된 점의 개수
            if cnt_2 == 2: # 연속된 점이 2개가 될 경우
                pts_2 += 1 # 세로로 누울 수 있는 자리 + 1
                
        else:
            cnt_2 = 0

print(pts, pts_2)
