import sys

n = int(sys.stdin.readline())
square = [sys.stdin.readline() for _ in range(n)]

square_list = [[] for _ in range(n)]
total = cnt = 0
cnt_list = []

dy = [0, -1, 0, 1]
dx = [1, 0, -1, 0]

for k in range(n):
    for l in range(n):
        square_list[k].append(int(square[k][l]))


for i in range(n):
    for j in range(n):
        if square_list[i][j] == 1:
            square_list[i][j] = 2
            cnt += 1
            stack = []
            stack.append(j)
            stack.append(i)
            total += 1

            while stack:
                y = stack.pop()
                x = stack.pop()

                for dir in range(4):
                    if 0 <= y + dy[dir] < n and 0 <= x + dx[dir] < n:
                        if square_list[y + dy[dir]][x + dx[dir]] == 1:
                            cnt += 1
                            square_list[y + dy[dir]][x + dx[dir]] = 2
                            stack.append(x + dx[dir])
                            stack.append(y + dy[dir])

            cnt_list.append(cnt)
            cnt = 0


print(total)
print(*sorted(cnt_list), sep = '\n')