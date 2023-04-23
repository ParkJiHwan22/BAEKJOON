# 10026 적록색약
# 문제
# 적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.

# 크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 
# 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)

# 예를 들어, 그림이 아래와 같은 경우에

# RRRBB
# GGBBB
# BBBRR
# BBRRR
# RRRRR

# 적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)

# 그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)

# 둘째 줄부터 N개 줄에는 그림이 주어진다.

# # 출력
# # 적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.

n = int(input())
visited = [[] for _ in range(n)]
dx = [1, 0, -1, 0, 0]
dy = [0, 1, 0, -1, 0]
cnt_R = 0
cnt_G = 0
cnt_B = 0
cnt_RG = 0

for _ in range(n):
    colors = input()
    for color in range(len(colors)):
        if colors[color] == 'R':
            visited[color].append(1)
        elif colors[color] == 'G':
            visited[color].append(2)
        else:
             visited[color].append(3)

for i in range(n): # R, 1
    for j in range(n):
        if visited[i][j] == 1:
            stack = []
            stack.append(j)
            stack.append(i)
            cnt_R += 1

            while stack:
                x = stack.pop()
                y = stack.pop()

                for dir in range(5):
                    if 0 <= x + dx[dir] < n and 0 <= y + dy[dir] < n:
                        if visited[x + dx[dir]][ y + dy[dir]] == 1:
                            visited[x + dx[dir]][ y + dy[dir]] = 4
                            stack.append(y + dy[dir])
                            stack.append(x + dx[dir])

for i in range(n): # G, 2
    for j in range(n):
        if visited[i][j] == 2:
            stack = []
            stack.append(j)
            stack.append(i)
            cnt_G += 1

            while stack:
                x = stack.pop()
                y = stack.pop()

                for dir in range(5):
                    if 0 <= x + dx[dir] < n and 0 <= y + dy[dir] < n:
                        if visited[x + dx[dir]][ y + dy[dir]] == 2:
                            visited[x + dx[dir]][ y + dy[dir]] = 4
                            stack.append(y + dy[dir])
                            stack.append(x + dx[dir])

for i in range(n): # B, 3
    for j in range(n):
        if visited[i][j] == 3:
            stack = []
            stack.append(j)
            stack.append(i)
            cnt_B += 1

            while stack:
                x = stack.pop()
                y = stack.pop()

                for dir in range(5):
                    if 0 <= x + dx[dir] < n and 0 <= y + dy[dir] < n:
                        if visited[x + dx[dir]][ y + dy[dir]] == 3:
                            visited[x + dx[dir]][ y + dy[dir]] = 5
                            stack.append(y + dy[dir])
                            stack.append(x + dx[dir])

for i in range(n): # R = G = 4
    for j in range(n):
        if visited[i][j] == 4:
            stack = []
            stack.append(j)
            stack.append(i)
            cnt_RG += 1

            while stack:
                x = stack.pop()
                y = stack.pop()

                for dir in range(5):
                    if 0 <= x + dx[dir] < n and 0 <= y + dy[dir] < n:
                        if visited[x + dx[dir]][ y + dy[dir]] == 4:
                            visited[x + dx[dir]][ y + dy[dir]] = 6
                            stack.append(y + dy[dir])
                            stack.append(x + dx[dir])



print(cnt_R + cnt_G + cnt_B ,cnt_RG + cnt_B)

# #============================================================================================

# import sys
# sys.setrecursionlimit(1000000)
# input = sys.stdin.readline

# n = int(input().rstrip())
# matrix = [list(input().rstrip()) for _ in range(n)]
# visited = [[False] * n for _ in range(n)]

# cnt_2, cnt_3 = 0, 0

# dx = [-1, 1, 0, 0]
# dy = [0, 0, -1, 1]

# def dfs(x,y):
#     #현재 색상 좌표를 방문해준다.
#     visited[x][y] = True
#     current_color = matrix[x][y]

#     for k in range(4):
#         nx = x + dx[k]
#         ny = y + dy[k]
#         if (0 <= nx < n) and (0 <= ny < n):
#             #현재 좌표의 색상과 상하좌우 좌표에 있는 색상이 같으면 dfs로 넣어준다.
#             if visited[nx][ny] == False:
#                 if matrix[nx][ny] == current_color:
#                     dfs(nx, ny)

# for i in range(n):
#     for j in range(n):
#         # 방문하지 않은 좌표이면 dfs로 넣어준다.
#         if visited[i][j] == False:
#             dfs(i, j)
#             cnt_3 += 1

# #R을 G로 바꾸어준다. --> 적록색약은 같은 색으로 보기 때문에
# for i in range(n):
#     for j in range(n):
#         if matrix[i][j] == 'R':
#             matrix[i][j] = 'G'

# visited = [[False] * n for _ in range(n)]

# for i in range(n):
#     for j in range(n):
#         if visited[i][j] == False:
#             dfs(i, j)
#             cnt_2 += 1

# print(cnt_3, cnt_2)


#=========================================================================

# import sys
# sys.setrecursionlimit(1000000)

# n = int(sys.stdin.readline())
# matrix = [list(sys.stdin.readline().rstrip()) for _ in range(n)]
# visited = [[False] * n for _ in range(n)] # 방문 기록

# dx = [1, 0, -1, 0] # 방향을 나타냄
# dy = [0, -1, 0, 1]

# cnt2, cnt3 = 0, 0

# def dfs(x, y):
#     visited[x][y] = True
#     color = matrix[x][y]

#     for dir in range(4):
#         nx = x + dx[dir]
#         ny = y + dy[dir]

#         if 0 <= nx < n and 0 <= ny < n:
#             if visited[nx][ny] == False:
#                 if matrix[nx][ny] == color:
#                     dfs(nx, ny)


# for i in range(n): # 적록색약이 아닌 사람
#     for j in range(n):
#         if visited[i][j] == False:
#             dfs(i, j)
#             cnt3 += 1

# for i in range(n): # 적록색약으로 만들기
#     for j in range(n):
#         if matrix[i][j] == 'R':
#             matrix[i][j] = 'G'

# visited = [[False] * n for _ in range(n)] # 방문 기록 갱신

# for i in range(n): # 적록색약인 사람
#     for j in range(n):
#         if visited[i][j] == False:
#             dfs(i, j)
#             cnt2 += 1

# print(cnt3, cnt2)


# 예제 입력 1 
# 5
# RRRBB
# GGBBB
# BBBRR
# BBRRR
# RRRRR
# 예제 출력 1 
# 4 3