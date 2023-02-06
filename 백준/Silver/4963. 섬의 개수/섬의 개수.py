import sys

dx = [0, -1, -1, -1, 0, 1, 1, 1]
dy = [1, 1, 0, -1, -1, -1, 0, 1]

while True:
    w, h = map(int, sys.stdin.readline().split())
    if w == 0 and h == 0:
        break
    else:
        island_map = [list(map(int, sys.stdin.readline().split())) for _ in range(h)]
        cnt = 0
 
        for i in range(h):
            for j in range(w):
                if island_map[i][j] == 1:
                    cnt += 1
                    stack = []
                    stack.append(j)
                    stack.append(i)

                    while stack:
                        x = stack.pop()
                        y = stack.pop()

                        for k in range(8):
                            lx = x + dx[k]
                            ly = y + dy[k]

                            if 0 <= lx < h and 0 <= ly < w:
                                if island_map[lx][ly] == 1:
                                    island_map[lx][ly] = 2
                                    stack.append(ly)
                                    stack.append(lx)

    print(cnt)
