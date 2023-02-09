import sys

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