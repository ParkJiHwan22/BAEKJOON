import sys

n, m = map(int, sys.stdin.readline().split())
rectangle = [sys.stdin.readline().strip() for _ in range(n)]

rec_list = [[] for _ in range(n)]
for r in range(len(rectangle)):
    for num in rectangle[r]:
        rec_list[r].append(num)

area = 1
for k in range(1, min(n, m)):
    for i in range(n - k):
        for j in range(m - k):
            if rectangle[i][j] == rectangle[i+k][j] == rectangle[i][j+k] == rectangle[i+k][j+k]:
                if area <= (k+1)**2:
                    area = (k+1)**2

print(area)