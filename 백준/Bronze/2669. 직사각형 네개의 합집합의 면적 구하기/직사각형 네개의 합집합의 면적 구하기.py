matrix = [[0]*100 for _ in range(100)]

for _ in range(4):
    p = list(map(int, input().split()))
    for i in range(p[0], p[2]):
        for j in range(p[1], p[3]):
            matrix[i][j] = 1
cnt = 0
for k in range(100):
    cnt += sum(matrix[k])

print(cnt)